package com.quantum.paymentsAlert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MQService {

  @Autowired
  private JmsTemplate jmsTemplate;

  public void sendMessage(String message) {
    jmsTemplate.convertAndSend("DEV.QUEUE.1", message);
    System.out.println("Message sent in File : " + message );
  }

}
