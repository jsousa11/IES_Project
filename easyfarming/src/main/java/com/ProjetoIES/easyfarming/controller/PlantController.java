package com.ProjetoIES.easyfarming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.ProjetoIES.easyfarming.model.Plant;
import com.ProjetoIES.easyfarming.repository.PlantRepository;
import com.ProjetoIES.easyfarming.service.PlantService;


@RestController
@RequestMapping("/api/v1")
public class PlantController {
    @Autowired
    private PlantRepository plantRepository;
    private PlantService plantService;

    @GetMapping("/plants")
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @PostMapping("/plants")
    public Plant createPlant(@Valid @RequestBody Plant plant) {
        return plantRepository.save(plant);
    }

    @GetMapping("/plantByName/{name}")
    public boolean plantExists(@PathVariable String name) {
        return plantRepository.existsByNameIgnoreCase(name);
      }
}