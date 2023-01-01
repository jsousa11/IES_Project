package com.ProjetoIES.easyfarming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.ProjetoIES.easyfarming.model.User;
import com.ProjetoIES.easyfarming.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "user removed !! " + id;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }
}
