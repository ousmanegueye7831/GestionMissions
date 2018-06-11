package com.opendevup.services.entities;

import java.util.ArrayList;
import java.util.List;

import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;

public class MultipleMissionnaireNotifications {

    private int                idMultipleMissionnaireNotifications;

    private List<Notification> notifications = new ArrayList<Notification>();

    private Missionnaire       missionnaire;

    public MultipleMissionnaireNotifications() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MultipleMissionnaireNotifications( List<Notification> notifications,
            Missionnaire missionnaire ) {
        super();
        this.notifications = notifications;
        this.missionnaire = missionnaire;
    }

    public int getIdMultipleMissionnaireNotifications() {
        return idMultipleMissionnaireNotifications;
    }

    public void setIdMultipleMissionnaireNotifications( int idMultipleMissionnaireNotifications ) {
        this.idMultipleMissionnaireNotifications = idMultipleMissionnaireNotifications;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications( List<Notification> notifications ) {
        this.notifications = notifications;
    }

    public Missionnaire getMissionnaire() {
        return missionnaire;
    }

    public void setMissionnaire( Missionnaire missionnaire ) {
        this.missionnaire = missionnaire;
    }

}
