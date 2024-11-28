package com.quantum.paymentsAlert.listener;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MQListener {


  @JmsListener(destination = "DEV.QUEUE.1")
  public void receiveMessage(String message) {
    System.out.println("message received : " + message);
  }
}
