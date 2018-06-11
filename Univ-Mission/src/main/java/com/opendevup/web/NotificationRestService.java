package com.opendevup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;
import com.opendevup.metier.NotificationMetier;
import com.opendevup.services.entities.MultipleMissionnaireMission;

@RestController
@CrossOrigin( "*" )
public class NotificationRestService {
	
	@Autowired
	private NotificationMetier notificationMetier;
    @RequestMapping( value = "/Notifications", method = RequestMethod.POST )	
	public List<Notification> listeNotifications(@RequestBody Missionnaire ms) {
		return notificationMetier.listeNotifications(ms);
	}

    @RequestMapping( value = "/Mission/create", method = RequestMethod.POST )
	public Notification saveNotification(@RequestBody MultipleMissionnaireMission m) {
		return notificationMetier.saveNotification(m);
	}
	
}
