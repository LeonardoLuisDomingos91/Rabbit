package br.com.leo.devrabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public Queue primeiraFila(){
        return QueueBuilder
                .durable("PRIMEIRA-FILA-BASICA")
                .build();
    }

    @Bean
    public Queue segundaFila(){
        return QueueBuilder
                .durable("SEGUNDA-FILA-BASICA")
                .build();
    }
}
