package com.ProjetoIES.easyfarming.service;

import com.ProjetoIES.easyfarming.model.Forum;
import com.ProjetoIES.easyfarming.repository.ForumRepository;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {

    @Autowired
    private ForumRepository forumRepository;

    public Forum saveForumMessage(Forum message){
        return forumRepository.save(message);
    }

    public List<Forum> getAllForumMessages(){
        return forumRepository.findAll();
    }

    @RabbitListener(queues = "forum")
    public void receiveMessage(String jsonMessage) {
        // convert to object
        JsonMapper mapper = new JsonMapper();

        try {
            Forum message = mapper.readValue(jsonMessage, Forum.class);
            saveForumMessage(new Forum(message.getUsername(), message.getQuestion(), message.getUsername1(), message.getAnswer1(), message.getUsername2(), message.getAnswer2(), message.getUsername3(), message.getAnswer3(), message.getUsername4(), message.getAnswer4(), message.getUsername5(), message.getAnswer5()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
