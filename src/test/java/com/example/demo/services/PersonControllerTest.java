package com.example.demo.services;

import com.example.demo.Repository.PersonRepository;
import com.example.demo.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
@RestClientTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockRestServiceServer server;

    private PersonRepository mockRepository = mock(PersonRepository.class);

    @Before
    public void before() {
        /*controller = new PersonController(mockRepository);*/
    }

    @Test
    public void findAll() {
        /*List<Person> personExpected = new ArrayList<>();
        when(mockRepository.findAll()).thenReturn(personExpected);
        List<Person> persons = controller.findAll();
        verify(mockRepository).findAll();*/

        /*this.server.expect(requestTo("/person"))
                .andRespond(withSuccess("hello", MediaType.APPLICATION_JSON_VALUE));
        String greeting = this.service.callRestService();
        assertThat(greeting).isEqualTo("hello");*/
    }

}
