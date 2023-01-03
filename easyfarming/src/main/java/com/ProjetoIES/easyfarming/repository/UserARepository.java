package com.ProjetoIES.easyfarming.repository;

import com.ProjetoIES.easyfarming.model.UserA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

public interface UserARepository extends JpaRepository<UserA, Long> {
    UserA findByName(String username);
    boolean existsByNameIgnoreCase(String username);
    void deleteByName(String username);
}
