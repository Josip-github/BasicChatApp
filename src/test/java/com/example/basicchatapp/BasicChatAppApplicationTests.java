package com.example.basicchatapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasicChatAppApplicationTests {

    @LocalServerPort
    private Integer port;

    private static WebDriver driver;

    private String baseURL;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @BeforeEach
    public void beforeEach(){
        baseURL = "http://localhost:" + port;
    }

    @Test
    void contextLoads() {
    }

}
