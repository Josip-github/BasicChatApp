package com.example.basicchatapp.service;

import com.example.basicchatapp.model.ChatForm;
import com.example.basicchatapp.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating MessageService bean");
        chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        if(chatForm.getMessageType().equals("Say")){
            newMessage.setMessage(chatForm.getMessageText());
        }
        if(chatForm.getMessageType().equals("Shout")){
            newMessage.setMessage(chatForm.getMessageText().toUpperCase());
        }
        if(chatForm.getMessageType().equals("Whisper")){
            newMessage.setMessage(chatForm.getMessageText().toLowerCase());
        }
        this.chatMessages.add(newMessage);
    }

    public List<ChatMessage> getChatMessages(){
        return chatMessages;
    }
}
