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
@Table( name = "Notification" )
public class Notification implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idNotification" )
    private Long         idNotificationn;

    @Column( name = "nom" )
    private String       nom;

    @Column( name = "prenom" )
    private String       prenom;

    @Column( name = "message" )
    private String       message;

    @Column( name = "dateDemande" )
    private String       dateDemande;

    @ManyToOne
    @JoinColumn( name = "missionnaire_fk" )
    @JsonIgnore
    private Missionnaire missionnaire_fk = new Missionnaire();

    public Notification() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Notification( String nom, String prenom, String message, String dateDemande ) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.message = message;
        this.dateDemande = dateDemande;
    }

    public Long getIdNotificationn() {
        return idNotificationn;
    }

    public void setIdNotificationn( Long idNotificationn ) {
        this.idNotificationn = idNotificationn;
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

    public String getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande( String dateDemande ) {
        this.dateDemande = dateDemande;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public Missionnaire getMissionnaire_fk() {
        return missionnaire_fk;
    }

    public void setMissionnaire_fk( Missionnaire missionnaire_fk ) {
        this.missionnaire_fk = missionnaire_fk;
    }

    public String toString() {
        return this.getNom() + " " + this.getPrenom() + " " + this.getMessage() + " " + this.getDateDemande() + " "
                + this.getMissionnaire_fk().getIdMissionnaire();
    }
}
