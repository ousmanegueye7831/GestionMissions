package com.opendevup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opendevup.entities.Deplacement;
import com.opendevup.entities.Mission;


public interface DeplacementRepository extends JpaRepository <Deplacement, Long> {
    @Query( "SELECT m from Deplacement m where m.mission_fk=:x" )
    public List<Deplacement> chercherDeplacement( @Param( "x" ) Mission mission );
}
