package com.opendevup.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "Transport" )
public class Transport {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idTransportContenu" )
    private int     idTransportContenu;

    @Column( name = "objetDeplacement" )
    private String  objetDeplacement;

    @Column( name = "destination" )
    private String  destination;

    @Column( name = "pays" )
    private String  pays;

    @Temporal( TemporalType.DATE )
    @Column( name = "dateDepart" )
    private Date    dateDepart;

    @Temporal( TemporalType.TIME )
    @Column( name = "heureDepart" )
    private Date    heureDepart;

    @Temporal( TemporalType.DATE )
    @Column( name = "dateArrivee" )
    private Date    dateArrivee;

    @Temporal( TemporalType.TIME )
    @Column( name = "HeureArrivee" )
    private Date    HeureArrivee;

    @Column( name = "moyenTransport" )
    private String  moyenTransport;

    @ManyToOne
    @JoinColumn( name = "mission_fk" )
    @JsonIgnore
    private Mission mission_fk = new Mission();

    public Transport() {
        super();
    }

    public Transport( String destination, String pays, Date dateDepart, Date heureDepart, Date dateArrivee,
            Date heureArrivee, String moyenTransport ) {
        super();
        this.destination = destination;
        this.pays = pays;
        this.dateDepart = dateDepart;
        this.heureDepart = heureDepart;
        this.dateArrivee = dateArrivee;
        HeureArrivee = heureArrivee;
        this.moyenTransport = moyenTransport;
    }

    public Mission getMission_fk() {
        return mission_fk;
    }

    public void setMission_fk( Mission mission_fk ) {
        this.mission_fk = mission_fk;
    }

    public int getIdTransportContenu() {
        return idTransportContenu;
    }

    public void setIdTransportContenu( int idTransportContenu ) {
        this.idTransportContenu = idTransportContenu;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination( String destination ) {
        this.destination = destination;
    }

    public String getPays() {
        return pays;
    }

    public void setPays( String pays ) {
        this.pays = pays;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart( Date dateDepart ) {
        this.dateDepart = dateDepart;
    }

    public Date getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart( Date heureDepart ) {
        this.heureDepart = heureDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee( Date dateArrivee ) {
        this.dateArrivee = dateArrivee;
    }

    public Date getHeureArrivee() {
        return HeureArrivee;
    }

    public void setHeureArrivee( Date heureArrivee ) {
        HeureArrivee = heureArrivee;
    }

    public String getMoyenTransport() {
        return moyenTransport;
    }

    public void setMoyenTransport( String moyenTransport ) {
        this.moyenTransport = moyenTransport;
    }

    public String getObjetDeplacement() {
        return objetDeplacement;
    }

    public void setObjetDeplacement( String objetDeplacement ) {
        this.objetDeplacement = objetDeplacement;
    }

}
