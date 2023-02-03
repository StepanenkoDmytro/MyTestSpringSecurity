package com.springsecurityapp.service.impl;

import com.springsecurityapp.model.Message;
import com.springsecurityapp.repository.MessageRepository;
import com.springsecurityapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;


    @Override
    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public Message getMessageById(long id) {
        return null;
    }

    @Override
    public void deleteMessage(long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public boolean existsMessageById(long id) {
        return messageRepository.existsById(id);
    }

    @Override
    public List<Message> getByTag(String text) {
        return messageRepository.findByTag(text);
    }
}
