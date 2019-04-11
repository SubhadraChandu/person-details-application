package com.person.controllers;

import com.person.entitiy.Person;
import com.person.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/people")
    public  List<Person> retrieveAll() {
        return personRepo.findAll();
    }

    @GetMapping("/people/{id}")
    public Person retrievePerson(@PathVariable Long id) {
        return personRepo.getOne(id);
    }

    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepo.deleteById(id);
    }

    @PostMapping("/people") //Pass String type
    public void createPerson(@RequestBody String xmlString) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse( new InputSource( new StringReader( xmlString ) ) );
        NodeList nodes = doc.getElementsByTagName("firstName");
        String firstName = nodes.item(0).getTextContent();
        String queueName = firstName.concat(".queue");
        jmsTemplate.send(queueName, session -> session.createTextMessage(xmlString));
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Object> updatePerson(@RequestBody Person person, @PathVariable Long id) {
        Optional<Person> optionalPerson = personRepo.findById(id);

        if (!optionalPerson.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        person.setId(id);


        personRepo.save(person);

        return ResponseEntity.noContent().build();

    }

}


