package com.example.basicchatapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage {

    @FindBy(id = "inputFirstName")
    private WebElement firstnameField;

    @FindBy(id = "inputLastName")
    private WebElement lastnameField;

    @FindBy(id = "inputUsername")
    private WebElement usernameField;

    @FindBy(id = "inputPassword")
    private WebElement passwordField;

    @FindBy(id = "submit-button")
    private WebElement submitButton;





}
