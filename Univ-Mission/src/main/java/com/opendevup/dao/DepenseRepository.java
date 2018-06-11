package com.opendevup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opendevup.entities.Depense;
import com.opendevup.entities.Mission;

public interface DepenseRepository extends JpaRepository <Depense, Long>{
	@Query( "SELECT m from Depense m where m.mission_fk=:x" )
    public List<Depense> chercherDepense( @Param( "x" ) Mission mission );
}
