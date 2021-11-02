package com.example.basicchatapp.repository;

import com.example.basicchatapp.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES")
    List<Message> getAllMessages();

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES (#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(Message message);
}
