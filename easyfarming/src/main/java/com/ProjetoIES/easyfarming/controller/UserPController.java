package com.ProjetoIES.easyfarming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoIES.easyfarming.exceptions.ResourceNotFoundException;
import com.ProjetoIES.easyfarming.model.UserP;
import com.ProjetoIES.easyfarming.repository.UserPRepository;
import com.ProjetoIES.easyfarming.service.UserPService;

@RestController
@RequestMapping("/api/v1")
public class UserPController {
    @Autowired
    private UserPRepository userPRepository;
    private UserPService userPService;

    @GetMapping("/userPplants")
    public List<UserP> getAllPlants() {
        return userPRepository.findAll();
    }

    @PostMapping("/userPplants")
    public UserP createPlant(@Valid @RequestBody UserP plant) {
        return userPRepository.save(plant);
    }

    @GetMapping("/userPplantByName/{username}")
    public boolean plantExists(@PathVariable String username) {
        return userPRepository.existsByNameIgnoreCase(username);
      }

    @GetMapping("/userPplants/{username}")
    public UserP getPlantByName(@PathVariable String username) {
        return userPRepository.findByName(username);
    }

    @Transactional
    @DeleteMapping("/deletePlantP/{username}")
    public void deletePlantByName(@PathVariable String username) {
        userPRepository.deleteByName(username);
    }
}
