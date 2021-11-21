package com.example.basicchatapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement messageTextField;

    @FindBy(id = "submitMessage")
    private WebElement submitButton;

    @FindBy(className = "chatMessageUsername")
    private WebElement firstMessageUsername;

    @FindBy(className = "chatMessageText")
    private WebElement firstMessageText;



}
