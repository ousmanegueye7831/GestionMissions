package com.opendevup.metier;

import java.util.List;


import com.opendevup.entities.EtatsMission;
import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;
import com.opendevup.services.entities.MultipleMissionnaireMission;

public interface MissionMetier {
	public List<Mission> listeMission( Missionnaire ms );  //lister
    public List<Mission> listeMissionCourant( Long id ) ;
    public List<Mission> listeMissionValider( Long id ) ;
    public List<Mission> listeMissionRefuser( Long id ) ;
    public Mission getMission( Long id );
    public Mission saveMission(MultipleMissionnaireMission m);
    public Boolean validerMission(EtatsMission e ); //validate
    public Boolean deleteMission( Long id );  //delete
    public Mission updateMission(  Long id, Mission m );   //update
    public List<Mission> chercherMissionValider( Long id );  //chercher
    public List<Mission> chercherMissionRefuser( Long id);
    public Boolean annulerMission( Long id);
    public List<Mission> chercherMissionARembourser( Long id ); 
   // public EtatsMission etatMission(EtatsMission m);
    


}
