package com.opendevup.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opendevup.entities.EtatsMission;

public interface EtatsRepository extends JpaRepository<EtatsMission, Long> {

    @Modifying
    @Transactional
    @Query( "UPDATE EtatsMission e SET e.etat = ?1 WHERE e.idmission= ?2 and e.typemissionnaire= ?3 " )
    public void validerMission( String etat, Long id, String type );
    
    @Modifying
    @Transactional
    @Query( "UPDATE EtatsMission e SET e.etat = ?1 WHERE e.idEtats= ?2 " )   
    public void AnnulerMission( String etat, Long id );
    
  
    @Query( "UPDATE EtatsMission e SET e.typemission = ?1 WHERE e.idmission= ?2 and e.typemissionnaire= ?3 " )
    public void updateTypeMission( String typemission, Long id, String type );
    
    @Modifying
    @Transactional
    @Query( "UPDATE EtatsMission e SET e.etatRemboursement = ?1 WHERE e.idmission= ?2 and e.typemissionnaire= ?3 " )
    public void updateEtatRemboursement( String etat, Long id, String type );

    @Query( "SELECT e from EtatsMission e where e.idmission=:x and e.typemissionnaire=:y" )
    public EtatsMission chercherEtatMission( @Param( "x" ) Long id, @Param( "y" ) String type );
    
    @Query( "SELECT e from EtatsMission e where e.etat=:x and e.typemissionnaire=:y" )
    public List<EtatsMission> chercherMission( @Param( "x" ) String etat, @Param( "y" ) String type );
    
    @Query( "SELECT e from EtatsMission e where e.etatRemboursement=:x and e.typemissionnaire=:y" )
    public List<EtatsMission> chercherMissionARemb( @Param( "x" ) String etat, @Param( "y" ) String type );
    
    @Query( "SELECT e from EtatsMission e where e.idmission=:x and e.etat=:y" )
    public EtatsMission chercherEtatMissions( @Param( "x" ) Long id, @Param( "y" ) String etat );

    @Query( "SELECT etat from EtatsMission e where e.idmission=:x" )
    public String chercherMission( @Param( "x" ) Long id );
    
    @Query( "SELECT etat from EtatsMission e where e.idmission=:x and e.typemissionnaire=:y" )
    public String chercherMission( @Param( "x" ) Long id,  @Param( "y" ) String type);
    
/*    @Query( "SELECT typemission from EtatsMission e where e.idmission=:x and e.typemissionnaire=:y " )
    public String chercherMission( @Param( "x" ) Long id,  @Param( "y" ) String type);*/
}
