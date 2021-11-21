package com.example.basicchatapp;

import com.example.basicchatapp.model.ChatForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testSignupLoginAndSubmitingMessage(){
        String username = "darthVader";
        String password = "forceAwakens";
        String messageText = "Let the force be with you";

        driver.get(baseURL + "/signup");
        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup("Anakin", "Skywalker", username, password);

        driver.get(baseURL + "/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        ChatPage chatPage = new ChatPage(driver);
        chatPage.submitNewMessage(messageText);

        ChatForm sentMessage = chatPage.getFirstMessage();

        assertEquals(username, sentMessage.getUsername());
        assertEquals(messageText, sentMessage.getMessageText());
    }

    @Test
    void contextLoads() {
    }

}
