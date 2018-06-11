package com.opendevup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opendevup.entities.Message;
import com.opendevup.entities.Mission;
import com.opendevup.metier.MessageMetier;
import com.opendevup.services.entities.MultipleMessageMission;

@RestController
@CrossOrigin( "*" )
public class MessageRestImpl {
    public static Long a         = 0L;
	@Autowired
	private MessageMetier messageMetier;
	

	
	@RequestMapping( value = "/Message/save", method = RequestMethod.POST )
	public boolean saveMessage(@RequestBody MultipleMessageMission m) {
		a=m.getIdMission();
		return messageMetier.saveMessage(m);
	}

}
