package com.ProjetoIES.easyfarming.repository;

import com.ProjetoIES.easyfarming.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param; 

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    Plant findByName(String username);
    boolean existsByNameIgnoreCase(String username);
}
