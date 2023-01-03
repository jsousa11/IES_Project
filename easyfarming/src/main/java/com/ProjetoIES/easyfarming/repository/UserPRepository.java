package com.ProjetoIES.easyfarming.repository;

import com.ProjetoIES.easyfarming.model.UserP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

public interface UserPRepository extends JpaRepository<UserP, Long>{
    UserP findByName(String username);
    boolean existsByNameIgnoreCase(String username);
    void deleteByName(String username);
}
