package com.opendevup.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;

public interface MissionnaireRepository extends JpaRepository<Missionnaire, Long> {

    @Query( "SELECT m from Missionnaire m where m.login=:x and  m.password=:y" )
    public Missionnaire chercherMissionnaire( @Param( "x" ) String login, @Param( "y" ) String password );

    @Query( "SELECT m from Missionnaire m where m.typeMissionnaire=:x" )
    public Missionnaire chercherMissionnaire( @Param( "x" ) String typeMissionnaire );

   /* @Query( "SELECT m from Missionnaire m where m.missions=:x" )
    public Missionnaire chercherMissionnaire( @Param( "x" ) Mission x );*/
    
    @Modifying
    @Transactional
    @Query( "UPDATE Missionnaire m SET m.affectation = ?1 , m.anniversaire = ?2 , m.departement = ?3 , m.etatInscription = true , m.grade = ?4 , m.etablissement = ?5 , m.laboratoire = ?6, m.numeroTel = ?7 , m.residenceAdministrative = ?8 , m.residencePersonnelle = ?9 , m.securiteSocial = ?10 , m.typeMissionnaire = ?11\r\n"
            +
            " WHERE m.idMissionnaire = ?11" )
    public int validerMissionnaire( String affectaion, Date anniversaire, String departement, String grade,
            String etablissement, String laboratoire, String telephone, String residenceAdministrative,
            String residencePersonnelle, String securiteSociale, String typeMissionnaire, Long id );
}
