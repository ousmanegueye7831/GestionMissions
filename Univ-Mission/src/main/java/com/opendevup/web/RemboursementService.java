package com.opendevup.web;

import java.util.List;

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
import com.opendevup.metier.DepenseMetier;
import com.opendevup.metier.DeplacementMetier;
import com.opendevup.metier.MissionMetier;
import com.opendevup.metier.RemboursementMetier;
import com.opendevup.services.entities.MultipleDeplacementDepense;

@RestController
@CrossOrigin( "*" )
public class RemboursementService {
	
	@Autowired
	private RemboursementMetier remboursementMetier;
	@Autowired
	private MissionMetier missionMetier;

	@RequestMapping( value = "/Remboursement/listMission/{id}", method = RequestMethod.GET )
	public List<Mission> chercherMissionARembourser(@PathVariable( "id" ) Long id) {
		return missionMetier.chercherMissionARembourser(id);
	}
	@RequestMapping( value = "/Remboursement/lists/{id}", method = RequestMethod.GET )    
	public List<Mission> listeMissionCourant(@PathVariable( "id" ) Long id) {
		return remboursementMetier.listeMissionCourant(id);
	}
	@RequestMapping( value = "/Remboursement/list", method = RequestMethod.POST )
	public MultipleDeplacementDepense listeRemb(@RequestBody Mission m) {
		return remboursementMetier.listeRemb(m);
	}
	@RequestMapping( value = "/Remboursement/valide", method = RequestMethod.POST )
	public Boolean validerRemboursement(@RequestBody EtatsMission e) {
		return remboursementMetier.validerRemboursement(e);
	}
	@RequestMapping( value = "/Remboursement/listMissionRemb", method = RequestMethod.POST )
	public List<Mission> listMissionRem(@RequestBody Missionnaire ms) {
		return remboursementMetier.listMissionRem(ms);
	}
	
	@RequestMapping( value = "/Remboursement/valid/{id}", method = RequestMethod.GET )
	public List<Mission> chercherRembValider(@PathVariable( "id" ) Long id) {
		return remboursementMetier.chercherRembValider(id);
	}
	
	@RequestMapping( value = "/Remboursement/refus/{id}", method = RequestMethod.GET )
	public List<Mission> chercherRembRefuser(@PathVariable( "id" ) Long id) {
		return remboursementMetier.chercherRembRefuser(id);
	}
	
	
	
	
	
	
 
}
