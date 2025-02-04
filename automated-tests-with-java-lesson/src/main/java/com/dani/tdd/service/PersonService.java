package com.dani.tdd.service;

import java.util.concurrent.atomic.AtomicLong;

import com.dani.tdd.model.Person;

public class PersonService implements IPersonService {

    @Override
    public Person createPerson(Person person) {

        // validando se o email é nulo ou vazio
        if (person.getEmail() == null || person.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        // simulando um acesso ao banco para buscar o id
        var id = new AtomicLong().incrementAndGet();
        person.setId(id);

        return person;
    }

}
