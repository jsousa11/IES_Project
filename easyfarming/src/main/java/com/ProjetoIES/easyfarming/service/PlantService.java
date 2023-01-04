package com.ProjetoIES.easyfarming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.ProjetoIES.easyfarming.model.Plant;
import com.ProjetoIES.easyfarming.repository.PlantRepository;

@Service
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    public Plant savePlant(Plant plant){
        return plantRepository.save(plant);
    }

    public List<Plant> savePlant(List<Plant> plants) {
        return plantRepository.saveAll(plants);
    }

    public List<Plant> getPlants(){
        return plantRepository.findAll();
    }

    public Plant getPlantById(Long id) {
        return plantRepository.findById(id).orElse(null);
    }

    public String deletePlant(Long id) {
        plantRepository.deleteById(id);
        return "plant removed !! " + id;
    }

    public Plant getPlantByName(String name) {
        return plantRepository.findByName(name);
    }

    
    public Plant updatePlant(Plant plant) {
        Plant existingPlant = plantRepository.findById(plant.getId()).orElse(null);
        existingPlant.setDescription(plant.getDescription());
        existingPlant.setClasss(plant.getClasss());
        existingPlant.setFamily(plant.getFamily());
        existingPlant.setGenus(plant.getGenus());
        existingPlant.setKingdom(plant.getKingdom());
        existingPlant.setOrderr(plant.getOrderr());
        existingPlant.setPhylum(plant.getPhylum());
        existingPlant.setHarmless(plant.getHarmless());
        return plantRepository.save(existingPlant);
    }
}
