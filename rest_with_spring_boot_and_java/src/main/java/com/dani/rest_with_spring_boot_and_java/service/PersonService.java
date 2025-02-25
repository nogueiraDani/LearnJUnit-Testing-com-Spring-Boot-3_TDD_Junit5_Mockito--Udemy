package com.dani.rest_with_spring_boot_and_java.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.dani.rest_with_spring_boot_and_java.entity.Person;

@Service
public class PersonService {

    private AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {

        logger.info(String.format("Searching for person with id %s", id));

        // mock simulando um retorno do banco de dados
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Daniela");
        person.setLastName("Rampim");
        person.setAddress("Santa Catarina - Brasil");

        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First Name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Some address - Brasil " + i);

        return person;
    }

    public Person createPerson(Person person) {

        logger.info(String.format(
                "Creating a new person with name %s",
                person.getFirstName()));

        return person;
    }

    public Person updatePerson(Person person) {
        logger.info(String.format(
                "Updating person with id %s",
                person.getId()));

        return person;
    }

    public void deletePerson(String id) {
        logger.info(String.format(
                "Deleting person with id %s",
                id));
    }
}
