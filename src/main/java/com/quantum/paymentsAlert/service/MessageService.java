package com.quantum.paymentsAlert.service;

import com.quantum.paymentsAlert.model.Message;
import com.quantum.paymentsAlert.repository.MessageRepossitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepossitory messageRepossitory;


    private String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Message getMessageById(Long id) {
        return messageRepossitory.findById(id).orElse(null);
    }

    public List<Message> getAllMessages() {
        return  messageRepossitory.findAll();
    }

    public Message saveMessage(String message) {
        Message savedMessage = new Message();
        savedMessage.setMessage(message);
        savedMessage.setDateTime(LocalDateTime.now());
        return messageRepossitory.save(savedMessage);
    }

}
