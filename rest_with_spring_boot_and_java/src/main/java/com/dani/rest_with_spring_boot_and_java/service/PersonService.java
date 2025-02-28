package com.dani.rest_with_spring_boot_and_java.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dani.rest_with_spring_boot_and_java.entity.Person;
import com.dani.rest_with_spring_boot_and_java.exceptions.ResourceNotFoundException;
import com.dani.rest_with_spring_boot_and_java.repositories.PersonRepository;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public Person findById(Long id) {

        logger.info(String.format("Searching for person with id %s", id));

        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    public List<Person> findAll() {

        return personRepository.findAll();
    }

    public Optional<Person> findByName(String firstName) {

        logger.info(String.format(
                "Searching for person with name %s",
                firstName));

        return personRepository.findByFirstName(firstName);
    }

    private Optional<Person> findByFirstNameAndLastName(String firstName, String lastName) {
        return personRepository.findByFirstNameAndLastNameJPQL(firstName, lastName);
    }

    public Person createPerson(Person person) {

        logger.info(String.format(
                "Creating a new person with name %s",
                person.getFirstName()));

        Optional<Person> personOptional = findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
        if (personOptional.isPresent()) {
            throw new ResourceNotFoundException("Person already exists");
        }

        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        logger.info(String.format(
                "Updating person with id %s",
                person.getId()));

        Person newPerson = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        newPerson.setFirstName(person.getFirstName());
        newPerson.setLastName(person.getLastName());
        newPerson.setAddress(person.getAddress());

        return personRepository.save(newPerson);
    }

    public void deletePerson(Long id) {
        logger.info(String.format(
                "Deleting person with id %s",
                id));

        Person newPerson = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        personRepository.delete(newPerson);
    }
}
