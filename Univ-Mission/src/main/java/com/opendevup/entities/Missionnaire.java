package com.opendevup.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "Missionnaire" )
public class Missionnaire implements Serializable {

    private static final long  serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idMissionnaire" )
    private Long               idMissionnaire;

    @Column( name = "typeMissionnaire" )
    private String             typeMissionnaire;

    @Column( name = "nom" )
    private String             nom;

    @Column( name = "prenom" )
    private String             prenom;

    @Column( name = "securiteSocial" )
    private String             securiteSocial;

    @Column( name = "login" )
    private String             login;

    @Column( name = "password" )
    private String             password;

    @Column( name = "residencePersonnelle" )
    private String             residencePersonnelle;

    @Column( name = "residenceAdministrative" )
    private String             residenceAdministrative;

    @Column( name = "grade" )
    private String             grade;

    @Column( name = "affectation" )
    private String             affectation;

    @Temporal( TemporalType.DATE )
    @Column( name = "anniversaire" )
    private Date               anniversaire;

    @Column( name = "numeroTel" )
    private String             numeroTel;

    @Column( name = "departement" )
    private String             departement;

    @Column( name = "etablissement" )
    private String             etablissement;
    
    @Column( name = "laboratoire" )
    private String            laboratoire;
    
    @Column( name = "etatInscription" )
    private Boolean            etatInscription;

    @Column( name = "photo" )
    private String             photo;

    @OneToMany( targetEntity = Mission.class, mappedBy = "missionnaire_fk", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Mission>      missions         = new ArrayList<Mission>();

    @OneToMany( targetEntity = Notification.class, mappedBy = "missionnaire_fk", cascade = CascadeType.ALL )
    @JsonIgnore
    private List<Notification> notifications    = new ArrayList<Notification>();

    public Missionnaire() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Missionnaire( String typeMissionnaire, String nom, String prenom, String securiteSocial, String login,
            String password, String residencePersonnelle, String residenceAdministrative, String grade,
            String affectation, Date anniversaire, String numeroTel, String departement,
            String etablissement, String laboratoire) {
        super();
        this.typeMissionnaire = typeMissionnaire;
        this.nom = nom;
        this.prenom = prenom;
        this.securiteSocial = securiteSocial;
        this.login = login;
        this.password = password;
        this.residencePersonnelle = residencePersonnelle;
        this.residenceAdministrative = residenceAdministrative;
        this.grade = grade;
        this.affectation = affectation;
        this.anniversaire = anniversaire;
        this.numeroTel = numeroTel;
        this.departement = departement;
        this.etablissement = etablissement;
        this.laboratoire = laboratoire;
    }
    
    
    
/*
    public Missionnaire(String typeMissionnaire, String nom, String prenom, String securiteSocial, String login,
			String password, String residencePersonnelle, String residenceAdministrative, String grade,
			String affectation, Date anniversaire, String numeroTel, String departement, String etablissement,
			String laboratoire, Boolean etatInscription, String photo, List<Mission> missions,
			List<Notification> notifications) {
		super();
		this.typeMissionnaire = typeMissionnaire;
		this.nom = nom;
		this.prenom = prenom;
		this.securiteSocial = securiteSocial;
		this.login = login;
		this.password = password;
		this.residencePersonnelle = residencePersonnelle;
		this.residenceAdministrative = residenceAdministrative;
		this.grade = grade;
		this.affectation = affectation;
		this.anniversaire = anniversaire;
		this.numeroTel = numeroTel;
		this.departement = departement;
		this.etablissement = etablissement;
		this.laboratoire = laboratoire;
		this.etatInscription = etatInscription;
		this.photo = photo;
		this.missions = missions;
		this.notifications = notifications;
	}*/

	public Long getIdMissionnaire() {
        return idMissionnaire;
    }

    public void setIdMissionnaire( Long idMissionnaire ) {
        this.idMissionnaire = idMissionnaire;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications( List<Notification> notifications ) {
        this.notifications = notifications;
    }

    public String getTypeMissionnaire() {
        return typeMissionnaire;
    }

    public void setTypeMissionnaire( String typeMissionnaire ) {
        this.typeMissionnaire = typeMissionnaire;
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

    public String getSecuriteSocial() {
        return securiteSocial;
    }

    public void setSecuriteSocial( String securiteSocial ) {
        this.securiteSocial = securiteSocial;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions( List<Mission> missions ) {
        this.missions = missions;
    }

    public Boolean getEtatInscription() {
        return etatInscription;
    }

    public void setEtatInscription( Boolean etatInscription ) {
        this.etatInscription = etatInscription;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getResidencePersonnelle() {
        return residencePersonnelle;
    }

    public void setResidencePersonnelle( String residencePersonnelle ) {
        this.residencePersonnelle = residencePersonnelle;
    }

    public String getResidenceAdministrative() {
        return residenceAdministrative;
    }

    public void setResidenceAdministrative( String residenceAdministrative ) {
        this.residenceAdministrative = residenceAdministrative;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade( String grade ) {
        this.grade = grade;
    }

    public String getAffectation() {
        return affectation;
    }

    public void setAffectation( String affectation ) {
        this.affectation = affectation;
    }

    public Date getAnniversaire() {
        return anniversaire;
    }

    public void setAnniversaire( Date anniversaire ) {
        this.anniversaire = anniversaire;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel( String numeroTel ) {
        this.numeroTel = numeroTel;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement( String departement ) {
        this.departement = departement;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement( String etablissement ) {
        this.etablissement = etablissement;
    }

	public String getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(String laboratoire) {
		this.laboratoire = laboratoire;
	}
    
}
