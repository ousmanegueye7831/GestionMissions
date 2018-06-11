package com.opendevup.metier;


import com.opendevup.entities.Message;
import com.opendevup.entities.Mission;
import com.opendevup.services.entities.MultipleMessageMission;

public interface MessageMetier {
	public boolean saveMessage( MultipleMessageMission m );

}