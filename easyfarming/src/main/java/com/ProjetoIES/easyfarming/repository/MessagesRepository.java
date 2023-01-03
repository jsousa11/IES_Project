package com.ProjetoIES.easyfarming.repository;

import com.ProjetoIES.easyfarming.model.Messages;
import com.ProjetoIES.easyfarming.beans.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Messages, Long> {

}
