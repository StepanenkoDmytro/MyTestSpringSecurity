package com.springsecurityapp.service;

import com.springsecurityapp.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessage();
    void saveMessage(Message message);
    Message getMessageById(long id);
    void deleteMessage(long id);
    boolean existsMessageById(long id);
    List<Message> getByTag(String tag);
}
