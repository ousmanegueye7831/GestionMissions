package com.opendevup.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    public List<Mission> findByObjetDeplacement( String n );

    public Page<Mission> findByObjetDeplacement( String n, Pageable pageable );

    @Query( "SELECT m from Mission m where m.idMission=:x" )
    public boolean chercherMissionARemboucher( @Param( "x" ) Long id );

    @Query( "SELECT m from Mission m where m.missionnaire_fk=:x" )
    public List<Mission> chercherMission( @Param( "x" ) Missionnaire missionnaire );
    
   
    


}
