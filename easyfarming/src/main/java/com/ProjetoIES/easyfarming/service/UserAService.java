package com.ProjetoIES.easyfarming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.ProjetoIES.easyfarming.model.UserA;
import com.ProjetoIES.easyfarming.repository.UserARepository;

@Service
public class UserAService {
    @Autowired
    private UserARepository userARepository;

    public UserA savePlant(UserA plant){
        return userARepository.save(plant);
    }

    public List<UserA> savePlant(List<UserA> plants) {
        return userARepository.saveAll(plants);
    }

    public List<UserA> getPlants(){
        return userARepository.findAll();
    }

    public UserA getPlantById(Long id) {
        return userARepository.findById(id).orElse(null);
    }

    public String deletePlant(String name) {
        userARepository.deleteByName(name);
        return "plant removed !! " + name;
    }

    public UserA getPlantByName(String name) {
        return userARepository.findByName(name);
    }

    
    public UserA updatePlant(UserA plant) {
        UserA existingPlant = userARepository.findById(plant.getId()).orElse(null);
        existingPlant.setName(plant.getName());
        existingPlant.setImage(plant.getImage());
        existingPlant.setDescription(plant.getDescription());
        existingPlant.setClasss(plant.getClasss());
        existingPlant.setFamily(plant.getFamily());
        existingPlant.setGenus(plant.getGenus());
        existingPlant.setKingdom(plant.getKingdom());
        existingPlant.setOrderr(plant.getOrderr());
        existingPlant.setPhylum(plant.getPhylum());
        existingPlant.setHarmless(plant.getHarmless());
        return userARepository.save(existingPlant);
    }
}
