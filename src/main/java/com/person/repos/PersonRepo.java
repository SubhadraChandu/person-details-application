package com.person.repos;

import com.person.entitiy.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person,Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into person(id,email,firstName,lastName,phone) values(:id,:email,:firstName,:lastName,:phone)",
            nativeQuery = true)
    void createNewPerson_main(Long id, String email, String firstName, String lastName, String phone);


    default void createNewPerson(Person person) {
        createNewPerson_main(person.getId(), person.getEmail(), person.getFirstName(), person.getLastName(), person.getPhone());

    }







//
//    @Modifying
//    @Query("insert into Person (id,name,age) select :id,:name,:age")
//    public int modifyingQueryInsertPerson(@Param("id")Long id, @Param("name")String name, @Param("age")Integer age);
    @Override
    List<Person> findAll();

    @Override
    default Optional<Person> findById(Long aLong) {
        return Optional.empty();
    }
}
