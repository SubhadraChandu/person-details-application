package com.person.exceptions;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(String message) {
       super(message);
    }
//    //public String toString(){
//        return "Entered Id does not belongs to any Person!";
//    }
}
