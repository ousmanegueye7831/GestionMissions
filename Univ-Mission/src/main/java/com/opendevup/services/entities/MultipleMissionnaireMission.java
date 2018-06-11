package com.opendevup.services.entities;

import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;

public class MultipleMissionnaireMission {

    private int          idMultipleMissionnaireMission;

    private Mission      mission;

    private Missionnaire missionnaire;

    private Notification notification;

    public MultipleMissionnaireMission() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getIdMultipleMissionnaireMission() {
        return idMultipleMissionnaireMission;
    }

    public void setIdMultipleMissionnaireMission( int idMultipleMissionnaireMission ) {
        this.idMultipleMissionnaireMission = idMultipleMissionnaireMission;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission( Mission mission ) {
        this.mission = mission;
    }

    public Missionnaire getMissionnaire() {
        return missionnaire;
    }

    public void setMissionnaire( Missionnaire missionnaire ) {
        this.missionnaire = missionnaire;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification( Notification notification ) {
        this.notification = notification;
    }

}
