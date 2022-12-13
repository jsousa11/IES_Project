package com.ProjetoIES.easyfarming.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProjetoIES.easyfarming.model.User;

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

    @GetMapping("/signup")
    public String signup() {
        return "signup";
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

    @PostMapping("/upload")
    public String uploadPost() {
        return "upload";
    }

    @GetMapping("/info/{plant}")
    public String info(@PathVariable("plant") String plant) {
        return plant;
    }
}
