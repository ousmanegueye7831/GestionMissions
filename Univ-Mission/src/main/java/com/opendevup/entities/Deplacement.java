package com.opendevup.entities;


import java.time.LocalDateTime;
import java.time.LocalTime;
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


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table( name = "Deplacement" )
public class Deplacement {
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idDeplacement" )
	private Long idDeplacement;
	private String motifDeplacement;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
	private String lieuDepart;
	private String lieuArrive;
	private String moyenTransport;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm", timezone="GMT")
	private Date dateHeureDepart;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm", timezone="GMT")
	private Date dateHeureArrive;
	
	@ManyToOne
	@JoinColumn( name = "mission_fk" )
	@JsonIgnore
	private Mission mission_fk = new Mission();
	
	public Deplacement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deplacement( String motifDeplacement, String lieuDepart, String lieuArrive,
			String moyenTransport, Date dateHeureDepart, Date dateHeureArrive, Mission mission_fk) {
		super();
		
		this.motifDeplacement = motifDeplacement;
		this.lieuDepart = lieuDepart;
		this.lieuArrive = lieuArrive;
		this.moyenTransport = moyenTransport;
		this.dateHeureDepart = dateHeureDepart;
		this.dateHeureArrive = dateHeureArrive;
		this.mission_fk = mission_fk;
	}

	public Long getIdDeplacement() {
		return idDeplacement;
	}

	public void setIdDeplacement(Long idDeplacement) {
		this.idDeplacement = idDeplacement;
	}

	public String getMotifDeplacement() {
		return motifDeplacement;
	}

	public void setMotifDeplacement(String motifDeplacement) {
		this.motifDeplacement = motifDeplacement;
	}

	public String getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public String getLieuArrive() {
		return lieuArrive;
	}

	public void setLieuArrive(String lieuArrive) {
		this.lieuArrive = lieuArrive;
	}

	public String getMoyenTransport() {
		return moyenTransport;
	}

	public void setMoyenTransport(String moyenTransport) {
		this.moyenTransport = moyenTransport;
	}

	public  Date  getDateHeureDepart() {
		return dateHeureDepart;
	}

	public void setDateHeureDepart(Date  dateHeureDepart) {
		this.dateHeureDepart = dateHeureDepart;
	}

	public  Date  getDateHeureArrive() {
		return dateHeureArrive;
	}

	public void setDateHeureArrive(Date  dateHeureArrive) {
		this.dateHeureArrive = dateHeureArrive;
	}

	public Mission getMission_fk() {
		return mission_fk;
	}

	public void setMission_fk(Mission mission_fk) {
		this.mission_fk = mission_fk;
	}
	
	
	
	
}
