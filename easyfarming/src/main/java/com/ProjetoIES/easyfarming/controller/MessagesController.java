package com.ProjetoIES.easyfarming.controller;
import com.ProjetoIES.easyfarming.model.Messages;
import com.ProjetoIES.easyfarming.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    private MessagesRepository MessagesRepository;

    @GetMapping("/allmessages")
    public List<Messages> getAllMessages() {
        return MessagesRepository.findAll();
    }

    @PostMapping("/allmessages")
    public Messages saveMessages(Messages messages){
        return MessagesRepository.save(messages);
    }

    /*@DeleteMapping("/deleteall")
    public boolean deleteMessages(){
        List<Messages> messages = MessagesRepository.findAll();
        MessagesRepository.deleteAll(messages);
        return true;
    }*/
}

