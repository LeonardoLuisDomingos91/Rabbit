package br.com.leo.devrabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    @Autowired
    private QueueConfig queueConfig;

    @Bean
    public Exchange directExchange(){
        return ExchangeBuilder
                .directExchange("DIRECT-EXCHANGE-BASIC")
                .durable(true)
                .build();
    }

    @Bean
    public Binding firstDirectBinding(){
        return BindingBuilder
                .bind(queueConfig.primeiraFila())
                .to(directExchange())
                    .with("PARA-PRIMEIRA-FILA")
                .noargs();
    }

    @Bean
    public Binding secondDirectBinding(){
        return BindingBuilder
                .bind(queueConfig.segundaFila())
                .to(directExchange())
                .with("PARA-SEGUNDA-FILA")
                .noargs();
    }
}
