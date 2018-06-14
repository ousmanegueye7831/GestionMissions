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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "Mission" )
public class Mission implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idMission" )
    private Long            idMission;

    @Column( name = "ordreRemboursement" )
    private Boolean         ordreRemboursement;
    
    @Column( name = "typeMission" )
    private String       typeMission;

    @Column( name = "dateDemande" )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @Temporal( TemporalType.DATE )
    private Date            dateDemande;
    	
    @Column( name = "typeDestination" )
    private String          typeDestination;
    
    @Column( name = "destination" )
    private String          destination;
    
    
    @Column( name = "pays" )
    private String          pays;       

    @Column( name = "dateDepart" )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @Temporal( TemporalType.DATE )
    private Date            dateDepart;

    @Column( name = "dateArrive" )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @Temporal( TemporalType.DATE )
    private Date            dateArrive;

    @Column( name = "objetDeplacement" )
    private String          objetDeplacement;

    @Column( name = "demandeAvance" )
    private Boolean         demandeAvance;

    @OneToMany( targetEntity = Transport.class, mappedBy = "mission_fk", cascade = CascadeType.ALL )
    @JsonIgnore
    private List<Transport> transport       = new ArrayList<Transport>();
    
/*    @OneToMany( targetEntity = Message.class, mappedBy = "mission", cascade = CascadeType.ALL )
    @JsonIgnore
    private List<Message> message   = new ArrayList<Message>();*/

    @OneToOne
    @JoinColumn( name = "idRemboursement" )
    private Remboursement   remboursement;

    @ManyToOne
    @JoinColumn( name = "idMissionnaire" )
   
    private Missionnaire    missionnaire_fk = new Missionnaire();
    
    @OneToMany( targetEntity =Deplacement.class, mappedBy = "mission_fk", cascade = CascadeType.ALL )
    @JsonIgnore
    private List<Deplacement> deplacement = new ArrayList<Deplacement>();
   
    @OneToMany( targetEntity =Depense.class, mappedBy = "mission_fk", cascade = CascadeType.ALL )
    @JsonIgnore
    private List<Depense> depense = new ArrayList<Depense>();
    
/*    @Column( name = "missionEtrangère" )
    private Boolean MissionEtrangere;
*/
    public Mission() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Mission( Boolean ordreRemboursement, Date dateDemande, String typeMission, String typeDestination, String destination, String pays,
            Date dateDepart, Date dateArrive, String objetDeplacement, Boolean demandeAvance ) {
        super();
        this.ordreRemboursement = ordreRemboursement;
        this.dateDemande = dateDemande;
        this.typeMission = typeMission;
        this.destination = destination;
        this.typeDestination = typeDestination;
        this.pays = pays;
        this.dateDepart = dateDepart;
        this.dateArrive = dateArrive;
        this.objetDeplacement = objetDeplacement;
        this.demandeAvance = demandeAvance;
    }
    
    
    public Mission( Boolean ordreRemboursement, String typeMission, Date dateDemande,
			String typeDestination, String destination, String pays, Date dateDepart, Date dateArrive,
			String objetDeplacement, Boolean demandeAvance,
			Missionnaire missionnaire_fk) {
		super();
		//this.idMission = idMission;
		this.ordreRemboursement = ordreRemboursement;
		this.typeMission = typeMission;
		this.dateDemande = dateDemande;
		this.typeDestination = typeDestination;
		this.destination = destination;
		this.pays = pays;
		this.dateDepart = dateDepart;
		this.dateArrive = dateArrive;
		this.objetDeplacement = objetDeplacement;
		this.demandeAvance = demandeAvance;
		//this.transport = transport;
		//this.remboursement = remboursement;
		this.missionnaire_fk = missionnaire_fk;
	}

	public Long getIdMission() {
        return idMission;
    }

    public void setIdMission( Long idMission ) {
        this.idMission = idMission;
    }

    public Boolean getOrdreRemboursement() {
        return ordreRemboursement;
    }

    public void setOrdreRemboursement( Boolean ordreRemboursement ) {
        this.ordreRemboursement = ordreRemboursement;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande( Date dateDemande ) {
        this.dateDemande = dateDemande;
    }
    
    public String getTypeDestination() {
		return typeDestination;
	}

	public void setTypeDestination(String typeDestination) {
		this.typeDestination = typeDestination;
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

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive( Date dateArrive ) {
        this.dateArrive = dateArrive;
    }

    public String getObjetDeplacement() {
        return objetDeplacement;
    }

    public void setObjetDeplacement( String objetDeplacement ) {
        this.objetDeplacement = objetDeplacement;
    }

    public Boolean getDemandeAvance() {
        return demandeAvance;
    }

    public void setDemandeAvance( Boolean demandeAvance ) {
        this.demandeAvance = demandeAvance;
    }

    public List<Transport> getTransport() {
        return transport;
    }

    public void setTransport( List<Transport> transport ) {
        this.transport = transport;
    }

    public Remboursement getRemboursement() {
        return remboursement;
    }

    public void setRemboursement( Remboursement remboursement ) {
        this.remboursement = remboursement;
    }

    public Missionnaire getMissionnaire_fk() {
        return missionnaire_fk;
    }

    public void setMissionnaire_fk( Missionnaire missionnaire_fk ) {
        this.missionnaire_fk = missionnaire_fk;
    }

	public String getTypeMission() {
		return typeMission;
	}

	public void setTypeMission(String typeMission) {
		this.typeMission = typeMission;
	}

/*	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}*/
	
	
    
    

/*	public Boolean getMissionEtrangere() {
		return MissionEtrangere;
	}

	public void setMissionEtrangere(Boolean missionEtrangere) {
		MissionEtrangere = missionEtrangere;
	}*/
    
    
}
