package com.example.basicchatapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasicChatAppApplicationTests {

    @LocalServerPort
    private Integer port;



    @Test
    void contextLoads() {
    }

}
