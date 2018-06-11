package com.opendevup.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "Message" )
public class Message implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idMessage" )
    private Long         idMessage;

    @Column( name = "nom" )
    private String       nom;

    @Column( name = "prenom" )
    private String       prenom;

    @Column( name = "message" )
    private String       message;

    @Column( name = "dateDemande" )
    private String       dateDemande;

    private Long idMission;
    
    private Long idDestinataire;

    public Message() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Message( String nom, String prenom, String message, String dateDemande, Long idMission, Long idDestinataire) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.message = message;
        this.dateDemande = dateDemande;
        this.idMission = idMission;
        this.idDestinataire = idDestinataire;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage( Long idMessage ) {
        this.idMessage = idMessage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public String getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande( String dateDemande ) {
        this.dateDemande = dateDemande;
    }

	public Long getIdMission() {
		return idMission;
	}

	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}

	public Long getIdDestinataire() {
		return idDestinataire;
	}

	public void setIdDestinataire(Long idDestinataire) {
		this.idDestinataire = idDestinataire;
	}

	

	

}
