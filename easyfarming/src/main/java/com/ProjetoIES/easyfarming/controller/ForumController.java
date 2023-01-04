package com.ProjetoIES.easyfarming.controller;

import com.ProjetoIES.easyfarming.model.Forum;
import com.ProjetoIES.easyfarming.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forumMessages")
public class ForumController {
    @Autowired
    private ForumRepository ForumRepository;

    @GetMapping("/allForumMessages")
    public List<Forum> getAllMessages() {
        return ForumRepository.findAll();
    }

    @PostMapping("/allForumMessages")
    public Forum saveMessages(Forum messages){
        return ForumRepository.save(messages);
    }

    @DeleteMapping("/deleteall")
    public boolean deleteMessages(){
        List<Forum> messages = ForumRepository.findAll();
        ForumRepository.deleteAll(messages);
        return true;
    }

}
