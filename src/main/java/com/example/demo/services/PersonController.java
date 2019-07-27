package com.example.demo.services;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
class PersonController {

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
    private Resource<Person> findPersonById(@PathVariable Long id) {

        Person person = repository.findById(id).get();
        /*.orElseThrow(() -> new EmployeeNotFoundException(id));*/

        return new Resource<>(person,
                linkTo(methodOn(PersonController.class).findPersonById(id)).withSelfRel(),
                linkTo(methodOn(PersonController.class).findAll()).withRel("persons"));
    }

    @PutMapping("/person")
    Person savePerson(@RequestBody Person newPerson) {
        Person savedPerson = new Person(newPerson.getFirstName(), newPerson.getLastName());
        return repository.save(savedPerson);
    }

    @PutMapping("/person/{firstName}/{lastName}")
    ResponseEntity<Person> savePerson(@PathVariable String firstName, @PathVariable String lastName) {
        logger.info("New Person : " + firstName + " " + lastName);
        Person savedPerson = new Person(firstName, lastName);
        savedPerson = repository.save(savedPerson);
        return ResponseEntity.ok(savedPerson);
    }

    @DeleteMapping("/person/{id}")
    ResponseEntity<?> deletePerson(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
