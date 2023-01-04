package com.ProjetoIES.easyfarming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controller1 {

    @GetMapping("/home")
    public String home() {
        return "index";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/userpageP")
    public String userpageP() {
        return "userpageP";
    }

    @GetMapping("/userpageA")
    public String userpageA() {
        return "userpageA";
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @GetMapping("/premium")
    public String premium() {
        return "premium";
    }

    @PostMapping("/upload")
    public String uploadPost() {
        return "upload";
    }

    @GetMapping("/forum")
    public String forum() {
        return "forum";
    }


}
