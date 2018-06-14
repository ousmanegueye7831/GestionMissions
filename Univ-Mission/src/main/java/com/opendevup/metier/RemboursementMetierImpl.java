package com.opendevup.metier;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.DepenseRepository;
import com.opendevup.dao.DeplacementRepository;
import com.opendevup.dao.EtatsRepository;
import com.opendevup.dao.MissionRepository;
import com.opendevup.dao.MissionnaireRepository;
import com.opendevup.entities.Depense;
import com.opendevup.entities.Deplacement;
import com.opendevup.entities.EtatsMission;
import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;
import com.opendevup.services.entities.MultipleDeplacementDepense;

@Service
public class RemboursementMetierImpl implements RemboursementMetier{
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private DepenseRepository depenseRepository;
	@Autowired
	private DeplacementRepository deplacementRepository;
	@Autowired
	private EtatsRepository etatsRepository;
	@Autowired
	private MissionnaireRepository missionnaireRepository;
	@Override
	public List<Mission> listeMissionCourant( Long id) {
		 List<EtatsMission> etats = new ArrayList<EtatsMission>();
	     List<Mission> missions = new ArrayList<Mission>();
	     System.out.println("test"+ id);
	     etats = etatsRepository.chercherMissionARemb( "en cours",
	     missionnaireRepository.findOne( id ).getTypeMissionnaire() );
	   
	     for ( int i = 0; i < etats.size(); i++ )
	         missions.add( missionRepository.findOne( etats.get( i ).getIdmission() ) );
	      return missions;
	}
	@Override
	public MultipleDeplacementDepense listeRemb(Mission m) {
		// TODO Auto-generated method stub
		MultipleDeplacementDepense dd= new MultipleDeplacementDepense();
		List<Deplacement> deplacement= new ArrayList<Deplacement>();
		List<Depense> depense= new ArrayList<Depense>();
		for(int i=0; i<deplacementRepository.chercherDeplacement(m).size(); i++) {
			deplacement.add(deplacementRepository.findOne(deplacementRepository.chercherDeplacement(m).get(i).getIdDeplacement()));
		}
		for(int i=0; i<depenseRepository.chercherDepense(m).size(); i++) {
			depense.add(depenseRepository.findOne(depenseRepository.chercherDepense(m).get(i).getIdDepense()));
		}
		dd.setIdMission(m.getIdMission());
		dd.setDeplacement(deplacement);
		dd.setDepense(depense);
		
		return dd;
	}
	@Override
	public Boolean validerRemboursement(EtatsMission e) {
		EtatsMission etatmission=etatsRepository.chercherEtatMission(e.getIdmission(), e.getTypemissionnaire());
		etatsRepository.validerRemb( e.getEtatRemboursement(), e.getIdmission(), e.getTypemissionnaire() );
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println( e.getEtatRemboursement());
		System.out.println(e.getIdmission());
		System.out.println(e.getTypemissionnaire());
		switch (e.getTypemissionnaire()) {
		case "GestionnaireSTGI":
			if(missionRepository.findOne(e.getIdmission()).getTypeMission().equals("Mission Pédagogique")) {
				etatsRepository.updateEtatRemboursement("en cours", e.getIdmission(), "ResponsableMM");
				break;
			}
			
			if(missionRepository.findOne(e.getIdmission()).getTypeMission().equals("Mission Recherche")) {
				etatsRepository.updateEtatRemboursement("en cours", e.getIdmission(), "ResponsableFEMTO");
				break;
			}
		case "ResponsableMM":
			etatsRepository.updateEtatRemboursement("en cours", e.getIdmission(), "DirecteurSTGI");
		case "DirecteurSTGI":
			if(e.getEtatRemboursement().equals("validée"))
				etatsRepository.updateEtatRemboursement("valide", e.getIdmission(), "DirecteurSTGI");
			if(e.getEtatRemboursement().equals("refusée"))
				etatsRepository.updateEtatRemboursement("refuse", e.getIdmission(), "DirecteurSTGI");
			break;
		case "GestionnaireIUT":
			if(missionRepository.findOne(e.getIdmission()).getTypeMission().equals("Mission Pédagogique")) {
				etatsRepository.updateEtatRemboursement("en cours", e.getIdmission(), "ResponsableMMI");
				break;
			}
			
			if(missionRepository.findOne(e.getIdmission()).getTypeMission().equals("Mission Recherche")) {
				etatsRepository.updateEtatRemboursement("en cours", e.getIdmission(), "ResponsableFEMTO");
				break;
			}
		case "GestionnaireFEMTO":
			etatsRepository.updateEtatRemboursement("en cours", e.getIdmission(), "ResponsableFEMTO");

		case "ResponsableFEMTO":
			if(missionRepository.findOne(e.getIdmission()).getMissionnaire_fk().getDepartement().equals("Multimedia"))
				etatsRepository.updateEtatRemboursement("en cours", e.getIdmission(), "DirecteurSTGI");
			if(missionRepository.findOne(e.getIdmission()).getMissionnaire_fk().getDepartement().equals("MMI"))
				etatsRepository.updateEtatRemboursement("en cours", e.getIdmission(), "DirecteurIUT");
				break;
		}
	
	
		
	
  
        return true;
	}
	@Override
	public List<Mission> listMissionRem(Missionnaire ms) {
		// TODO Auto-generated method stub
		List<EtatsMission> etats = new ArrayList<EtatsMission>();
		List<Mission> missionstemp = new ArrayList<Mission>();
	    List<Mission> missions = new ArrayList<Mission>();
	    EtatsMission etat = new EtatsMission();
		if(ms.getDepartement().equals("Multimedia")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatRemb(missionRepository.chercherMission(ms).get(i).getIdMission(), "en cours");
    				if(etat != null) {    		    				
    					//etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
		if(ms.getDepartement().equals("MMI")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatRemb(missionRepository.chercherMission(ms).get(i).getIdMission(), "en cours");
    				if(etat != null) {    		    				
    					//etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
		return missions;
	}
	@Override
	public List<Mission> chercherRembValider(Long id) {
		// TODO Auto-generated method stub
		List<Mission> missions = new ArrayList<Mission>();
        //List<Mission> missions2 = new ArrayList<Mission>();
        List<EtatsMission> etats = new ArrayList<EtatsMission>();
        EtatsMission etat = new EtatsMission();
        Missionnaire ms = missionnaireRepository.findOne(id);
       // System.out.println("---------VVVVVVVVVVVVVVVVVVVVVVVV--------------------"+missionRepository.findOne(ms.getIdMissionnaire()).getIdMission());
        
        if(ms.getDepartement().equals("Multimedia")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatRemb(missionRepository.chercherMission(ms).get(i).getIdMission(), "valide");
    				if(etat != null) {    		    				
    					//etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
        if(ms.getDepartement().equals("MMI")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatRemb(missionRepository.chercherMission(ms).get(i).getIdMission(), "valide");
    				if(etat != null) {    		    				
    					//etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
        
        return missions;	
	}
	@Override
	public List<Mission> chercherRembRefuser(Long id) {
		// TODO Auto-generated method stub
		List<Mission> missions = new ArrayList<Mission>();
        //List<Mission> missions2 = new ArrayList<Mission>();
        List<EtatsMission> etats = new ArrayList<EtatsMission>();
        EtatsMission etat = new EtatsMission();
        Missionnaire ms = missionnaireRepository.findOne(id);
       // System.out.println("---------VVVVVVVVVVVVVVVVVVVVVVVV--------------------"+missionRepository.findOne(ms.getIdMissionnaire()).getIdMission());
        
        if(ms.getDepartement().equals("Multimedia")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatRemb(missionRepository.chercherMission(ms).get(i).getIdMission(), "refuse");
    				if(etat != null) {    		    				
    					//etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
        if(ms.getDepartement().equals("MMI")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatRemb(missionRepository.chercherMission(ms).get(i).getIdMission(), "refuse");
    				if(etat != null) {    		    				
    					//etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
        
        return missions;
	}
	
	


}
