package com.ProjetoIES.easyfarming.beans;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Rabbitmq {
    @RabbitListener(queues = "generator")
    public void receiveMessage(String jsonMessage) {
        // convert to object
        JsonMapper mapper = new JsonMapper();

        try {
            Message message = mapper.readValue(jsonMessage, Message.class);
            if (message.getTemperature() > 25) {
                System.out.println("ALERT: Temperature is high!");
            }
            if (message.getHumidity() < 50) {
                System.out.println("ALERT: Humidity is low!");
            }
            if (message.getPercipitation() > 50) {
                System.out.println("ALERT: Percipitation is high!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
