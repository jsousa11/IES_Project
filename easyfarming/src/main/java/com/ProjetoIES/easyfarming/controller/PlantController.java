package com.ProjetoIES.easyfarming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
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

    @Autowired
    private PlantService plantService;  

    @GetMapping("/plants")
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @PostMapping("/plants")
    public Plant createPlant(@Valid @RequestBody Plant plant) {
        return plantRepository.save(plant);
    }

    @GetMapping("/plantByName/{username}")
    public boolean plantExists(@PathVariable String username) {
        return plantRepository.existsByNameIgnoreCase(username);
      }

    @GetMapping("/plants/{username}")
    public Plant getPlantByName(@PathVariable String username) {
        return plantRepository.findByName(username);
    }

    @PutMapping("/updatePlant/{username}")
    public Plant updatePlant(@PathVariable String username, @RequestBody Plant plantUpdates){
        Plant plant = plantRepository.findByName(username);
        plant.setDescription(plantUpdates.getDescription());
        plant.setFamily(plantUpdates.getFamily());
        plant.setGenus(plantUpdates.getGenus());
        plant.setKingdom(plantUpdates.getKingdom());
        plant.setOrderr(plantUpdates.getOrderr());
        plant.setPhylum(plantUpdates.getPhylum());
        plant.setHarmless(plantUpdates.getHarmless());
        return plantRepository.save(plant);
    }

    @DeleteMapping("/deleteAll")
    public boolean deletePlants(){
        List<Plant> plants = plantRepository.findAll();
        plantRepository.deleteAll(plants);
        return true;
    }
}