package com.opendevup.metier;

import java.util.List;


import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;
import com.opendevup.services.entities.MultipleMissionnaireMission;

public interface NotificationMetier {
	public List<Notification> listeNotifications(  Missionnaire ms );
    public Notification saveNotification( MultipleMissionnaireMission m ); //save
	
}
