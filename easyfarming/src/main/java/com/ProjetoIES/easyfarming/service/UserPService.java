package com.ProjetoIES.easyfarming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.ProjetoIES.easyfarming.model.UserP;
import com.ProjetoIES.easyfarming.repository.UserPRepository;

@Service
public class UserPService {
    @Autowired
    private UserPRepository userPRepository;

    public UserP savePlant(UserP plant){
        return userPRepository.save(plant);
    }

    public List<UserP> savePlant(List<UserP> plants) {
        return userPRepository.saveAll(plants);
    }

    public List<UserP> getPlants(){
        return userPRepository.findAll();
    }

    public UserP getPlantById(Long id) {
        return userPRepository.findById(id).orElse(null);
    }

    public String deletePlant(String name) {
        userPRepository.deleteByName(name);
        return "plant removed !! " + name;
    }

    public UserP getPlantByName(String name) {
        return userPRepository.findByName(name);
    }

    
    public UserP updatePlant(UserP plant) {
        UserP existingPlant = userPRepository.findById(plant.getId()).orElse(null);
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
        return userPRepository.save(existingPlant);
    }
}
