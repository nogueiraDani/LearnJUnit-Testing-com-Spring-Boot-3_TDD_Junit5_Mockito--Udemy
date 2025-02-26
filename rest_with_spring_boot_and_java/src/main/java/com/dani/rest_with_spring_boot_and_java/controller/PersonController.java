package com.dani.rest_with_spring_boot_and_java.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dani.rest_with_spring_boot_and_java.entity.Person;
import com.dani.rest_with_spring_boot_and_java.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
    public Person getById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
    public List<Person> getAll() {
        return personService.findAll();
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
    public Optional<Person> getByName(@PathVariable String firstName) {
        return personService.findByName(firstName);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

}
