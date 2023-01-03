package com.ProjetoIES.easyfarming.beans;

import com.ProjetoIES.easyfarming.model.Messages;
import com.ProjetoIES.easyfarming.repository.MessagesRepository;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class Rabbitmq {

    @Autowired
    private com.ProjetoIES.easyfarming.repository.MessagesRepository MessagesRepository;

    public Messages saveMessages(Messages messages){
        return MessagesRepository.save(messages);
    }
    public List<Messages> getAllMessages(){
        return MessagesRepository.findAll();
    }
    @RabbitListener(queues = "generator")
    public void receiveMessage(String jsonMessage) {
        // convert to object
        JsonMapper mapper = new JsonMapper();

        try {
            Message message = mapper.readValue(jsonMessage, Message.class);
            if (message.getTemperature() > 25) {
                System.out.println("ALERT: Temperature is high!");
                saveMessages(new Messages("Today's temperature is high. Don't forget to water your plants!"));
            }
            if (message.getHumidity() < 50) {
                System.out.println("ALERT: Humidity is low!");
                saveMessages(new Messages("Today's humidity is low! Make sure to water your plants!"));
            }
            if (message.getHumidity() > 50) {
                System.out.println("ALERT: Humidity is high!");
                saveMessages(new Messages("Today is very humid so you shouldn't water your plants..."));
            }
            if (message.getPrecipitation() > 50) {
                System.out.println("ALERT: Precipitation is high!");
                saveMessages(new Messages("Today the precipitation is at a high level... It is not necessary to water the plants"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
