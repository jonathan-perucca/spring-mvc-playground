package com.github.jperucca.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void should_test() {
        final Result result = restTemplate.getForObject("http://localhost:{port}/users", Result.class, port);

        assertThat(result.getResponse()).isEqualTo("test");
    }

    @Test
    public void should_respond_ok() {
        final UserCreationDTO john = UserCreationDTO.builder().name("John").build();

        final Result result = restTemplate.postForObject("http://localhost:{port}/users", john, Result.class, port);

        assertThat(result.getResponse()).isEqualTo("ok");
    }

    @Test
    public void should_respond_nok() {
        final UserCreationDTO john = UserCreationDTO.builder().name(null).build();

        final Result result = restTemplate.postForObject("http://localhost:{port}/users", john, Result.class, port);

        assertThat(result.getResponse()).isEqualTo("nok");
    }
}
