package com.opendevup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;
import com.opendevup.metier.MissionnaireMetier;

@RestController
@CrossOrigin( "*" )
public class MissionnaireRestService {
	@Autowired
	private MissionnaireMetier missionnaireMetier;
	
    @RequestMapping( value = "/Missionnaire/list", method = RequestMethod.GET )
	public List<Missionnaire> listeMissionnaires() {
		return missionnaireMetier.listeMissionnaires();
	}
    @RequestMapping( value = "/Missionnaire/find", method = RequestMethod.POST )
	public Missionnaire getMissionnaire( @RequestBody Missionnaire m) {
		return missionnaireMetier.getMissionnaire(m);
	}
	
    @RequestMapping( value = "/Missionnaire/save", method = RequestMethod.POST )
	public Missionnaire saveMissionnaire( @RequestBody Missionnaire m) {
		return missionnaireMetier.saveMissionnaire(m);
	}
	
    @RequestMapping( value = "/Missionnaire/delete/{id}", method = RequestMethod.DELETE )
	public Boolean deleteMissionnaire( @PathVariable( "id" ) Long id) {
		return missionnaireMetier.deleteMissionnaire(id);
	}
	
    @RequestMapping( value = "/Missionnaire/update/{id}", method = RequestMethod.PUT )
	public Missionnaire updateMissionnaire( @PathVariable( "id" ) Long id,  @RequestBody Missionnaire m) {
		return missionnaireMetier.updateMissionnaire(id, m);
	}
    
    @RequestMapping( value = "/Missionnaire/complete", method = RequestMethod.PUT )    
	public Missionnaire updateMissionnaire( @RequestBody Missionnaire m) {
		return missionnaireMetier.updateMissionnaire(m);
	}
    

}
