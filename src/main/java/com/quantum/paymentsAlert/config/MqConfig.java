package com.quantum.paymentsAlert.config;

import com.ibm.mq.MQQueue;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

public class MqConfig {

    @Bean
    public JmsListenerContainerFactory<?> mqContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("1-1");
        return factory;
    }


    @Bean
    public ConnectionFactory getConnectionFactory() {
      MQQueueConnectionFactory connectionFactory = new MQQueueConnectionFactory();

      try {
      connectionFactory.setHostName("localhost");
        connectionFactory.setPort(1414);
        connectionFactory.setQueueManager("QM1");
        connectionFactory.setChannel("DEV.APP.SVRCONN");
        connectionFactory.setTransportType(1);
      } catch (JMSException e) {
        throw new RuntimeException(e);
      }

      return connectionFactory;

    }
}
