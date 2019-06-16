package com.example.demo.services;

import com.example.demo.Repository.PersonRepository;
import com.example.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private final PersonRepository repository;

    PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/person")
    List<Person> findAll() {
        return repository.findAll();
    }

    @PostMapping("/person")
    Person saveNewPerson(@RequestBody Person newPerson) {
        return repository.save(newPerson);
    }

    @GetMapping("/person/{id}")
    Person findPersonById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping("/person")
    Person savePerson(@RequestBody Person newPerson) {
        Person savedPerson = new Person(newPerson.getFirstName(), newPerson.getLastName());
        return repository.save(savedPerson);
    }

    @PutMapping("/person/{firstName}/{lastName}")
    Person savePerson(@PathVariable String firstName, @PathVariable String lastName) {
        logger.info("New Person : " + firstName + " " + lastName);
        Person savedPerson = new Person(firstName, lastName);
        return repository.save(savedPerson);
    }

    @DeleteMapping("/person/{id}")
    void deletePerson(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
