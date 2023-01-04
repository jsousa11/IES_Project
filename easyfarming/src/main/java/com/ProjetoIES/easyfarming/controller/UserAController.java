package com.ProjetoIES.easyfarming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.ProjetoIES.easyfarming.model.User;
import com.ProjetoIES.easyfarming.model.UserA;
import com.ProjetoIES.easyfarming.repository.UserARepository;
import com.ProjetoIES.easyfarming.service.UserAService;

@RestController
@RequestMapping("/api/v1")
public class UserAController {
    @Autowired
    private UserARepository userARepository;
    private UserAService userAService;

    @GetMapping("/userAplants")
    public List<UserA> getAllPlants() {
        return userARepository.findAll();
    }

    @PostMapping("/userAplants")
    public UserA createPlant(@Valid @RequestBody UserA plant) {
        return userARepository.save(plant);
    }

    @GetMapping("/userAplantByName/{username}")
    public boolean plantExists(@PathVariable String username) {
        return userARepository.existsByNameIgnoreCase(username);
      }

    @GetMapping("/userAplants/{username}")
    public UserA getPlantByName(@PathVariable String username) {
        return userARepository.findByName(username);
    }

    @Transactional
    @DeleteMapping("/deletePlantA/{username}")
    public void deletePlantByName(@PathVariable String username) {
        userARepository.deleteByName(username);
    }
}
