package com.example.basicchatapp.service;

import com.example.basicchatapp.model.ChatForm;
import com.example.basicchatapp.model.Message;
import com.example.basicchatapp.repository.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating MessageService bean");
    }

    public void addMessage(ChatForm chatForm){
        Message newMessage = new Message();
        newMessage.setUsername(chatForm.getUsername());
        if(chatForm.getMessageType().equals("Say")){
            newMessage.setMessageText(chatForm.getMessageText());
        }
        if(chatForm.getMessageType().equals("Shout")){
            newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
        }
        if(chatForm.getMessageType().equals("Whisper")){
            newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
        }
        messageMapper.insert(newMessage);
        //this.messages.add(newMessage);
    }

    public List<Message> getChatMessages(){
        return messageMapper.getAllMessages();
    }
}
