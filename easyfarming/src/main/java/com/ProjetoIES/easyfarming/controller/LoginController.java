package com.ProjetoIES.easyfarming.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.ui.Model;

import com.ProjetoIES.easyfarming.model.User;
import com.ProjetoIES.easyfarming.inputForms.InputLogin;
import com.ProjetoIES.easyfarming.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private User user;

    @Autowired
    private UserService userService;

    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @ModelAttribute("inputLogin")
    public InputLogin getGreetingObject() {
      return new InputLogin();
    }

    @GetMapping("/login")
    public String getAskIdentifier(Model model) {
      return "login";
    }

    @PostMapping("/login/check")
    public String greetingSubmit(@ModelAttribute InputLogin inputLogin, Model model) throws NoSuchAlgorithmException {
      HttpSession session = httpSessionFactory.getObject();
      String email = inputLogin.getEmail().strip();
      String password = inputLogin.getPassword();
      if (email == "" || password == "") {
        model.addAttribute("error", "All fields must be filled!");
        return "login";
      }

      User user = userService.getUserByEmail(email);

      if(user != null && user.getPassword().equals(password)) {
        session.setAttribute("email", email);
        session.setAttribute("firstName", user.getFirst_name());
        session.setAttribute("lastName", user.getLast_name());
        model.addAttribute("firstName", user.getFirst_name());
        model.addAttribute("lastName", user.getLast_name());
        model.addAttribute("email", email);
        return "userpageP";
      }

      model.addAttribute("error", "Email and/or password incorrect!");
      return "login";
    }
    
}
