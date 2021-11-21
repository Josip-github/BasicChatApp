package com.example.basicchatapp;

import com.example.basicchatapp.model.ChatForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement messageTextField;

    @FindBy(id = "submitMessage")
    private WebElement submitButton;

    @FindBy(className = "chatMessageUsername")
    private WebElement firstMessageUsername;

    @FindBy(className = "chatMessageText")
    private WebElement firstMessageText;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void submitNewMessage(String text){
        this.messageTextField.sendKeys(text);
        this.submitButton.click();
    }

    public ChatForm getFirstMessage(){
        ChatForm message = new ChatForm();
        message.setUsername(firstMessageUsername.getText());
        message.setMessageText(firstMessageText.getText());
        return message;
    }
}
