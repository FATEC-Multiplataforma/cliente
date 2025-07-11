package br.com.fatec.pokemon.messaging;

import br.com.fatec.pokemon.entity.User;
import br.com.fatec.pokemon.messaging.adapter.PedidoMessagingImplAdapter;
import br.com.fatec.pokemon.messaging.dto.PedidoFreteAmqp;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PedidoMessagingImpl implements PedidoMessaging {
    private final String exchange;
    private final String routingKey;
    private final RabbitTemplate rabbitTemplate;

    public PedidoMessagingImpl(
            @Value("${spring.rabbitmq.request.exchange.producer}") String exchange,
            @Value("${spring.rabbitmq.request.routing-key.producer}") String routingKey,
            RabbitTemplate rabbitTemplate) {
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendToQueue(User user) {
        PedidoFreteAmqp amqp = PedidoMessagingImplAdapter.cast(user);
        rabbitTemplate.convertAndSend(exchange, routingKey, amqp);
    }
}
