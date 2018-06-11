package com.opendevup.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opendevup.entities.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {
	
	@Query("SELECT m From Message m where m.idDestinataire=:x ")
	public List<Message> ChercherMessage(@Param("x") Long idDestinataire);
	

}
