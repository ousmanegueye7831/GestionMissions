package com.opendevup.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opendevup.entities.EtatsMission;
import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;
import com.opendevup.metier.MissionMetier;
import com.opendevup.services.entities.MultipleMissionnaireMission;

@RestController
@CrossOrigin( "*" )
public class MissionRestService {
	@Autowired
	private MissionMetier missionMetier;

	@RequestMapping( value = "/Mission/list", method = RequestMethod.POST )	
	public List<Mission> listeMission(@RequestBody Missionnaire ms) {
		return missionMetier.listeMission(ms);
	}

    @RequestMapping( value = "/Mission/lists/{id}", method = RequestMethod.GET )    
	public List<Mission> listeMissionCourant(@PathVariable( "id" ) Long id) {
		return missionMetier.listeMissionCourant(id);
	}

    @RequestMapping( value = "/Mission/listValide/{id}", method = RequestMethod.GET )
    public List<Mission> listeMissionValider(@PathVariable( "id" )  Long id) {
		return missionMetier.listeMissionValider(id);
	}

    @RequestMapping( value = "/Mission/listRefuse/{id}", method = RequestMethod.GET )
	public List<Mission> listeMissionRefuser(@PathVariable( "id" ) Long id) {
		return missionMetier.listeMissionRefuser(id);
	}

	@RequestMapping( value = "/Mission/find/{id}", method = RequestMethod.GET)
	public Mission getMission(@PathVariable( "id" ) Long id) {
		return missionMetier.getMission(id);
	}
    
    @RequestMapping( value = "/Mission/save", method = RequestMethod.POST ) 
    public Mission saveMission(@RequestBody MultipleMissionnaireMission m) {
		return missionMetier.saveMission(m);
	}

	@RequestMapping( value = "/Mission/validate", method = RequestMethod.POST )
	public Boolean validerMission(@RequestBody EtatsMission e) {
		return missionMetier.validerMission(e);
	}

    @RequestMapping( value = "/Mission/delete/{id}", method = RequestMethod.DELETE )
	public Boolean deleteMission(@PathVariable( "id" ) Long id) {
		return missionMetier.deleteMission(id);
	}
    
    @RequestMapping( value = "/Mission/annuler/{id}", method = RequestMethod.PUT )
    public Boolean annulerMission( @PathVariable( "id" ) Long id) {
		return missionMetier.annulerMission(id);
	}

	@RequestMapping( value = "/Mission/update/{id}", method = RequestMethod.PUT )
	public Mission updateMission( @PathVariable( "id" ) Long id, @RequestBody Mission m ) {
		return missionMetier.updateMission( id, m);
	}

    @RequestMapping( value = "/Mission/valid/{id}", method = RequestMethod.GET )
	public List<Mission> chercherMissionValider(@PathVariable( "id" ) Long id) {
		return missionMetier.chercherMissionValider(id);
	}
    
    @RequestMapping( value = "/Mission/refuse/{id}", method = RequestMethod.GET )
    public List<Mission> chercherMissionRefuser(@PathVariable( "id") Long id) {
		return missionMetier.chercherMissionRefuser(id);
	}
/*    @RequestMapping( value = "/Mission/etat", method = RequestMethod.POST )
	public EtatsMission etatMission(@RequestBody EtatsMission e) {
		return missionMetier.etatMission(e);
	}*/
      
}
