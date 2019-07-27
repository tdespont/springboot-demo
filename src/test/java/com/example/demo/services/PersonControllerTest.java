package com.example.demo.services;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class PersonControllerTest {

    private PersonController controller;

    private final PersonRepository mockRepository = mock(PersonRepository.class);

    @Before
    public void before() {
        controller = new PersonController(mockRepository);
    }

    @Test
    @Sql(scripts = "classpath:/test-sql/personData.sql")
    public void findAll() {
        List<Person> personsExpected = new ArrayList<>();
        when(mockRepository.findAll()).thenReturn(personsExpected);
        List<Person> persons = controller.findAll();
        verify(mockRepository).findAll();
        assertEquals(persons, personsExpected);
    }

    @Test
    public void findAllThrowException() {
        List<Person> personsExpected = new ArrayList<>();
        when(mockRepository.findAll()).thenThrow(new RuntimeException());
        try {
            List<Person> persons = controller.findAll();
        } catch (RuntimeException re) {
            verify(mockRepository).findAll();
            return;
        }
        fail();
    }

}
