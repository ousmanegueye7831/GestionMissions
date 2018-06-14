package com.opendevup.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.EtatsRepository;
import com.opendevup.dao.MissionRepository;
import com.opendevup.dao.MissionnaireRepository;
import com.opendevup.dao.NotificationRepository;
import com.opendevup.entities.EtatsMission;
import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;
import com.opendevup.services.entities.MultipleMissionnaireMission;
import com.opendevup.util.NotificationMessage;
import com.opendevup.web.CounterService;



@Service
public class MissionMetierImpl implements MissionMetier{
	@Autowired
	private MissionRepository missionRepository;
	@Autowired	
	private MissionnaireRepository missionnaireRepository;
	@Autowired
	private EtatsRepository etatsRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    private CounterService counterService = new CounterService();
    @Autowired
    private NotificationMessage notificationMessage;
    
	@Override
	public List<Mission> listeMission(Missionnaire ms) {
		List<EtatsMission> etats = new ArrayList<EtatsMission>();
		List<Mission> missionstemp = new ArrayList<Mission>();
	    List<Mission> missions = new ArrayList<Mission>();
	    EtatsMission etat = new EtatsMission();
		if(ms.getDepartement().equals("Multimedia")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatMissions(missionRepository.chercherMission(ms).get(i).getIdMission(), "en cours");
    				if(etat != null) {    		    				
    					etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
		if(ms.getDepartement().equals("MMI")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatMissions(missionRepository.chercherMission(ms).get(i).getIdMission(), "en cours");
    				if(etat != null) {    		    				
    					etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
		
		return missions;
	}

	@Override
	public List<Mission> listeMissionCourant( Long id) {
		 List<EtatsMission> etats = new ArrayList<EtatsMission>();
	     List<Mission> missions = new ArrayList<Mission>();

	     etats = etatsRepository.chercherMission( "en cours",
	     missionnaireRepository.findOne( id ).getTypeMissionnaire() );
	     for ( int i = 0; i < etats.size(); i++ )
	         missions.add( missionRepository.findOne( etats.get( i ).getIdmission() ) );
	      return missions;
	}
	
	@Override
	public List<Mission> listeMissionValider(Long id) {
		List<EtatsMission> etats = new ArrayList<EtatsMission>();
	    List<Mission> missions = new ArrayList<Mission>();

	    etats = etatsRepository.chercherMission( "validée",
	    missionnaireRepository.findOne( id ).getTypeMissionnaire() );
	    etats.addAll(etatsRepository.chercherMission( "valide",
	    	    missionnaireRepository.findOne( id ).getTypeMissionnaire() ));
	    
	    for ( int i = 0; i < etats.size(); i++ )
	         missions.add( missionRepository.findOne( etats.get( i ).getIdmission() ) );
	     return missions;
	}

	@Override
	public List<Mission> listeMissionRefuser( Long id) {
		List<EtatsMission> etats = new ArrayList<EtatsMission>();
	    List<Mission> missions = new ArrayList<Mission>();

	    etats = etatsRepository.chercherMission( "refusée",
	    missionnaireRepository.findOne( id ).getTypeMissionnaire() );
	    etats.addAll(etatsRepository.chercherMission( "refuse",
	    	    missionnaireRepository.findOne( id ).getTypeMissionnaire() ));
	    for ( int i = 0; i < etats.size(); i++ )
	         missions.add( missionRepository.findOne( etats.get( i ).getIdmission() ) );
	     return missions;
	}
	
	@Override
	public List<Mission> chercherMissionValider(Long id) {
        List<Mission> missions = new ArrayList<Mission>();
        //List<Mission> missions2 = new ArrayList<Mission>();
        List<EtatsMission> etats = new ArrayList<EtatsMission>();
        EtatsMission etat = new EtatsMission();
        Missionnaire ms = missionnaireRepository.findOne(id);
       // System.out.println("---------VVVVVVVVVVVVVVVVVVVVVVVV--------------------"+missionRepository.findOne(ms.getIdMissionnaire()).getIdMission());
        
        if(ms.getDepartement().equals("Multimedia")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatMissions(missionRepository.chercherMission(ms).get(i).getIdMission(), "valide");
    				if(etat != null) {    		    				
    					etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
        if(ms.getDepartement().equals("MMI")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatMissions(missionRepository.chercherMission(ms).get(i).getIdMission(), "valide");
    				if(etat != null) {    		    				
    					etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
        
        return missions;	
      }
	

	@Override
	public List<Mission> chercherMissionRefuser(Long id) {
		// TODO Auto-generated method stub
		List<Mission> missions = new ArrayList<Mission>();
        //List<Mission> missions2 = new ArrayList<Mission>();
        List<EtatsMission> etats = new ArrayList<EtatsMission>();
        EtatsMission etat = new EtatsMission();
        Missionnaire ms = missionnaireRepository.findOne(id);
      System.out.println("---------RRRRRRRRRRRRRRRRRRRR--------------------"+ms.getDepartement());
        
        if(ms.getDepartement().equals("Multimedia")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatMissions(missionRepository.chercherMission(ms).get(i).getIdMission(), "refuse");
    				if(etat != null) {    		    				
    					etats.add(etat);
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
        if(ms.getDepartement().equals("MMI")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etat= etatsRepository.chercherEtatMissions(missionRepository.chercherMission(ms).get(i).getIdMission(), "refuse");
    				//System.out.println("refuse refuse refuse "+etat.getIdmission() +"iddfagdegh"+ missionRepository.chercherMission(ms).get(i).getIdMission());
    				if(etat != null) {    		    				
    					etats.add(etat);
    					System.out.println("refuse refuse refuse "+etat.getIdmission());
    					missions.add( missionRepository.findOne( etat.getIdmission() ) );
    				}					
				
    		}			    					
		}
        
        return missions;
	}
	
	@Override
	public Mission getMission(Long id) {
		// TODO Auto-generated method stub
		return missionRepository.findOne( id );
	}
	
	

	@Override
	public Boolean validerMission(EtatsMission e) {
		EtatsMission etatmission=etatsRepository.chercherEtatMission(e.getIdmission(), e.getTypemissionnaire());
		etatsRepository.validerMission( e.getEtat(), e.getIdmission(), e.getTypemissionnaire() );
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println( e.getEtat() );
		System.out.println(e.getIdmission());
		System.out.println(e.getTypemissionnaire());
		
		System.out.println(etatmission.getTypeMission());
		String message ="Veuillez accepter ma demande de mission.";
        String reponse = "Votre demande est " + e.getEtat() + " de ma part.";
        Notification ntf = new Notification(
                missionnaireRepository.chercherMissionnaire( e.getTypemissionnaire() ).getNom(),
                missionnaireRepository.chercherMissionnaire( e.getTypemissionnaire() ).getPrenom(),
                reponse, "Il y'a environ 5 min" );
        ntf.setMissionnaire_fk( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk() );
        notificationRepository.save( ntf );

  /*      ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
                missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
                "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );*/
      /*Notification mail*/
/*		try {
			String to = missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getLogin();
			System.out.println(to);
			String msg = "Bonjour "+ missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom() + ",\n\n"+  reponse + "\n\n Cordialement? \n\n"+ missionnaireRepository.chercherMissionnaire( e.getTypemissionnaire() ).getPrenom() +" "+missionnaireRepository.chercherMissionnaire( e.getTypemissionnaire() ).getNom() +".";
			notificationMessage.sendMail( to, "Demande Mission", msg);
		} catch (MessagingException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}*/
 
	    switch ( e.getTypemissionnaire() ) {
	    case "GestionnaireSTGI":
	        if(missionRepository.findOne(e.getIdmission()).getTypeMission().equals("Mission Pédagogique")){
		           // etatsRepository.validerMission( "en cours", e.getIdmission(), "ResponsableMM" );
		        etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "ResponsableMM", etatmission.getTypeMission()));
		        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
		                    missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
		                    "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
		        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "ResponsableMM" ) );
		        notificationRepository.save( ntf );
/*				try {
					String to = missionnaireRepository.chercherMissionnaire( "ResponsableMM" ).getLogin();
					System.out.println("Resposss"+from);
					String msg = "Bonjour "+ missionnaireRepository.chercherMissionnaire( "ResponsableMM" ).getNom() + ",\n\n"+  message 
							+ "\n\n Cordialement \n\n"+ missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom()
							+" "+ missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom() +".";
					notificationMessage.sendMail(to, "Demande Mission", msg);
				} catch (MessagingException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}*/
		            break;
	        }
	        if(missionRepository.findOne(e.getIdmission()).getTypeMission().equals("Mission Recherche")){
		           // etatsRepository.validerMission( "en cours", e.getIdmission(), "ResponsableMM" );
		        etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "ResponsableFEMTO", etatmission.getTypeMission()));
		        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
		                    missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
		                    "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
		        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "ResponsableFEMTO" ) );
		        notificationRepository.save( ntf );
				try {
					String from = missionnaireRepository.chercherMissionnaire( "ResponsableMM" ).getLogin();
					System.out.println("Resposss"+from);
					String msg = "Bonjour "+ missionnaireRepository.chercherMissionnaire( "ResponsableMM" ).getNom() + ",\n\n"+  message 
							+ "\n\n Cordialement \n\n"+ missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom()
							+" "+ missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom() +".";
					notificationMessage.sendMail("gueye.ousmane7831@gmail.com", "Demande Mission", msg);
				} catch (MessagingException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
		            break;
	        }

	    case "ResponsableMM":
	          //  ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "DirecteurMM" ) );
	         etatsRepository.validerMission( "en cours", e.getIdmission(), "DirecteurSTGI");
	        // etatsRepository.updateTypeMission(etatmission.getTypeMission(), e.getIdmission(), "DirecteurSTGI");
	    	//etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "DirecteurSTGI"));
	        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
                    missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
                    "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
	        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "DirecteurSTGI") );
	        notificationRepository.save( ntf );
	            break;
	    case "DirecteurSTGI":
	            //ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "Directeur UFR" ) );
	    	//System.out.println(e.getTypeMission());
	    	if(!etatmission.getTypeMission().equals("HorsUE")) {
	    		if(e.getEtat().equals("validée"))
	    			etatsRepository.validerMission( "valide", e.getIdmission(), "DirecteurSTGI");
	    		if(e.getEtat().equals("refusée"))
	    			etatsRepository.validerMission( "refuse", e.getIdmission(), "DirecteurSTGI");
	            break;
	    	}
	        else {
	        	etatsRepository.validerMission( "en cours", e.getIdmission(), "PresidentUFC");
		        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
	                    missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
	                    "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
		        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "PresidentUFC") );
		        notificationRepository.save( ntf );
		            break;
			} 
	    case "PresidentUFC":
	    	if(e.getEtat().equals("validée"))
    			etatsRepository.validerMission( "valide", e.getIdmission(), "PresidentUFC");
    		if(e.getEtat().equals("refusée"))
    			etatsRepository.validerMission( "refuse", e.getIdmission(), "PresidentUFC");
	    	break;

	    case "GestionnaireIUT":
	    	if(missionRepository.findOne(e.getIdmission()).getTypeMission().equals("Mission Pédagogique")){
		           // etatsRepository.validerMission( "en cours", e.getIdmission(), "ResponsableMM" );
		        etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "ResponsableMMI", etatmission.getTypeMission()));
		        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
		                    missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
		                    "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
		        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "ResponsableMMI" ) );
		        notificationRepository.save( ntf );
		            break;
	        }
	        if(missionRepository.findOne(e.getIdmission()).getTypeMission().equals("Mission Recherche")){
		           // etatsRepository.validerMission( "en cours", e.getIdmission(), "ResponsableMM" );
		        etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "ResponsableFEMTO", etatmission.getTypeMission()));
		        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
		                    missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
		                    "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
		        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "ResponsableFEMTO" ) );
		        notificationRepository.save( ntf );
		            break;
	        }
	    case "ResponsableMMI":
	           // ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "DirecteurMMI" ) );
	    	etatsRepository.validerMission( "en cours", e.getIdmission(), "DirecteurIUT" );
	    	//etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "DirecteurIUT"));
	        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
	                 missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
	                 "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
	        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "DirecteurUIT" ) );
	            break;
	    case "DirecteurIUT":
	    	if(!etatmission.getTypeMission().equals("HorsUE")) {
	    		if(e.getEtat().equals("validée"))
	    			etatsRepository.validerMission( "valide", e.getIdmission(), "DirecteurIUT");
	    		if(e.getEtat().equals("refusée"))
	    			etatsRepository.validerMission( "refuse", e.getIdmission(), "DirecteurIUT");
	    	//etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "ResponsableMM"));
	            break;
	    	}
	        else {
	        	etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "PresidentUFC", etatmission.getTypeMission()));
		        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
	                    missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
	                    "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
		        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "PresidentUFC") );
		        notificationRepository.save( ntf );
		            break;
			} 
	    case "GestionnaireFEMTO":
	        
	           // etatsRepository.validerMission( "en cours", e.getIdmission(), "ResponsableMM" );
	        etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "ResponsableFEMTO", etatmission.getTypeMission()));
	        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
	                    missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
	                    "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
	        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "ResponsableFEMTO" ) );
	        notificationRepository.save( ntf );
	            break;
	            
	    case "ResponsableFEMTO":
	    	if(missionRepository.findOne(e.getIdmission()).getMissionnaire_fk().getDepartement().equals("Multimedia")) {
	    		etatsRepository.validerMission( "en cours", e.getIdmission(), "DirecteurSTGI");
		        // etatsRepository.updateTypeMission(etatmission.getTypeMission(), e.getIdmission(), "DirecteurSTGI");
		    	//etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "DirecteurSTGI"));
		        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
	                    missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
	                    "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
		        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "DirecteurSTGI") );
		        notificationRepository.save( ntf );
	    	}
	    	//etatsRepository.validerMission("valide", e.getIdmission(), "ResponsableFEMTO ");
	    	if(missionRepository.findOne(e.getIdmission()).getMissionnaire_fk().getDepartement().equals("MMI")) {
	    		etatsRepository.validerMission( "en cours", e.getIdmission(), "DirecteurIUT");
		        // etatsRepository.updateTypeMission(etatmission.getTypeMission(), e.getIdmission(), "DirecteurSTGI");
		    	//etatsRepository.save(new EtatsMission(e.getIdmission(), "en cours", "DirecteurSTGI"));
		        ntf = new Notification( missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getNom(),
	                    missionRepository.findOne( e.getIdmission() ).getMissionnaire_fk().getPrenom(),
	                    "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 5 min" );
		        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "DirecteurIUT") );
		        notificationRepository.save( ntf );
	    	}
	    	break;
	            
	     }
  
        return true;
	}

	@Override
	public Boolean deleteMission(Long id) {
		// TODO Auto-generated method stub
		missionRepository.delete( id );
		return true;
	}

	@Override
	public Mission updateMission( Long id, Mission m) {
		// TODO Auto-generated method stub
		m.setIdMission( id );
		m.setMissionnaire_fk(missionRepository.findOne(id).getMissionnaire_fk());
		m.setDateDemande(new Date());
		return missionRepository.save( m );
	}
	
	


	@Override
	public Mission saveMission(MultipleMissionnaireMission m) {
		// TODO Auto-generated method stub
		
/*
        m.getMission().setMissionnaire_fk( m.getMissionnaire() );

        m.getNotification().setNom( m.getMissionnaire().getNom() );
        m.getNotification().setPrenom( m.getMissionnaire().getPrenom() );
        m.getNotification().setMessage( "veuillez Accepter ma demande de mission, Cordialement." );
        m.getNotification().setDateDemande( "Il y'a environ 5 min." );
        m.getNotification().setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "GestionnaireSTGI" ) );

        notificationRepository.save( m.getNotification() );*/

/*        Notification ntf = new Notification( m.getMissionnaire().getNom(),
               m.getMissionnaire().getPrenom(),
                "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 2 sec" );
        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "GestionnaireSTGI" ));
        notificationRepository.save( ntf );*/
        
        
		m.getMission().setMissionnaire_fk( m.getMissionnaire() );
		m.getMission().setDateDemande(new Date());
		Mission mission= missionRepository.save(m.getMission());
		String message = "Veuillez, accepter ma demande de mission SVP.";
			if(m.getMissionnaire().getDepartement().equals("Multimedia")){
				try {
					//String from = missionnaireRepository.chercherMissionnaire( "GestionnaireSTGI" ).getLogin();
					//System.out.println(from);
					String msg = "Bonjour "+ missionnaireRepository.chercherMissionnaire( "GestionnaireSTGI" ).getNom() + ",\n\n"+  message + "\n\n Cordialement \n\n"+ m.getMissionnaire().getPrenom() +" "+ m.getMissionnaire().getNom() +".";
					notificationMessage.sendMail("ousmanegueye7831@gmail.com", "Demande Mission", msg);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				etatsRepository.save(new EtatsMission(mission.getIdMission(), "en cours", "GestionnaireSTGI", mission.getTypeDestination()));
		        etatsRepository.save( new EtatsMission(mission.getIdMission(), "", "DirecteurSTGI", mission.getTypeDestination() ) );
		        System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"+m.getMission().getTypeDestination().equals("HorsUE"));
		        if (m.getMission().getTypeDestination().equals("HorsUE"))
		        	etatsRepository.save( new EtatsMission(mission.getIdMission(), "", "PresidentUFC", mission.getTypeDestination() ) );
				Notification ntf = new Notification( m.getMissionnaire().getNom(),
			               m.getMissionnaire().getPrenom(),
			                "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 2 sec" );
			        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "GestionnaireSTGI" ));
			        notificationRepository.save( ntf );
			}
	        if(m.getMissionnaire().getDepartement().equals("MMI")){
				etatsRepository.save(new EtatsMission(mission.getIdMission(), "en cours", "GestionnaireIUT", mission.getTypeDestination()));
				etatsRepository.save( new EtatsMission(mission.getIdMission(), "", "DirecteurIUT", mission.getTypeDestination()) );
				Notification ntf = new Notification( m.getMissionnaire().getNom(),
			               m.getMissionnaire().getPrenom(),
			                "veuillez Accepter ma demande de mission, Cordialement.", "Il y'a environ 2 sec" );
			        ntf.setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "GestionnaireIUT" ));
			        notificationRepository.save( ntf );
			}

	
		


		
		return mission;
	}

	@Override
	public Boolean annulerMission(Long id) {
		// TODO Auto-generated method stub
		EtatsMission etat = new EtatsMission();
				
			etat= etatsRepository.chercherEtatMissions(id, "en cours");
			if(etat != null)     		    				
				etatsRepository.AnnulerMission("annuler", etat.getIdEtats());
		return true;
	}

	@Override
	public List<Mission> chercherMissionARembourser(Long id) {
		// TODO Auto-generated method stub
		List<Mission> missions = new ArrayList<Mission>();
		EtatsMission etatV = new EtatsMission();
		EtatsMission etatR = new EtatsMission();
		Missionnaire ms = missionnaireRepository.findOne(id);
		if(ms.getDepartement().equals("Multimedia")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etatV= etatsRepository.chercherEtatMissions(missionRepository.chercherMission(ms).get(i).getIdMission(), "validée", "GestionnaireSTGI");
    				etatR= etatsRepository.chercherEtatMissions(missionRepository.chercherMission(ms).get(i).getIdMission(), "refusée", "GestionnaireSTGI");
    				
    				if (etatV!= null) {
    					System.out.println("dfdgddff"+ etatV.getEtatRemboursement());
	    				if(missionRepository.chercherMission(ms).get(i).getOrdreRemboursement() && etatV.getEtatRemboursement()==null ) {    		    				
	    					//etats.add(etat);
	    					missions.add( missionRepository.findOne( etatV.getIdmission() ) );
	    				
	    				}
    				}
    				if (etatR !=null) {
    					if(missionRepository.chercherMission(ms).get(i).getOrdreRemboursement() && etatR.getEtatRemboursement()==null ) {    		    				
	    					//etats.add(etat);
	    					missions.add( missionRepository.findOne( etatR.getIdmission() ) );
	    				
	    				
    				}					
				
    				}
	    				
    		}			    					
		}
	
		if(ms.getDepartement().equals("MMI")) {

    		for(int i=0; i<missionRepository.chercherMission(ms).size(); i++) {
				
    				etatV= etatsRepository.chercherEtatMissions(missionRepository.chercherMission(ms).get(i).getIdMission(), "validée", "GestionnaireIUT");
    				etatR= etatsRepository.chercherEtatMissions(missionRepository.chercherMission(ms).get(i).getIdMission(), "refusée", "GestionnaireIUT");
    				
    				if (etatV!= null) {
    					System.out.println("dfdgddff"+ etatV.getEtatRemboursement());
	    				if(missionRepository.chercherMission(ms).get(i).getOrdreRemboursement() && etatV.getEtatRemboursement()==null ) {    		    				
	    					//etats.add(etat);
	    					missions.add( missionRepository.findOne( etatV.getIdmission() ) );
	    				
	    				}
    				}
    				if (etatR !=null) {
    					if(missionRepository.chercherMission(ms).get(i).getOrdreRemboursement() && etatR.getEtatRemboursement()==null ) {    		    				
	    					//etats.add(etat);
	    					missions.add( missionRepository.findOne( etatR.getIdmission() ) );
	    				
	    				
    				}					
				
    				}
	    				
    		}			    					
		}
		return missions;
	}






}
