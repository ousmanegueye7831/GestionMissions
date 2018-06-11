package com.opendevup.services.entities;

import com.opendevup.entities.Message;
import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;

public class MultipleMessageMission {

    private int     idMultipleMessageMissionnaire;

   // private Missionnaire missionnaire;

    private Message message;
    
    private Long idMission;

    public MultipleMessageMission() {
        super();
        // TODO Auto-generated constructor stub
    }



    public MultipleMessageMission(int idMultipleMessageMissionnaire, Missionnaire missionnaire, Message message,
			Long idMission) {
		super();
		this.idMultipleMessageMissionnaire = idMultipleMessageMissionnaire;
		//this.missionnaire = missionnaire;
		this.message = message;
		this.idMission = idMission;
	}



	public int getIdMultipleMessageMissionnaire() {
        return idMultipleMessageMissionnaire;
    }

    public void setIdMultipleMessageMissionnaire( int idMultipleMessageMissionnaire ) {
        this.idMultipleMessageMissionnaire = idMultipleMessageMissionnaire;
    }

   



	public Long getIdMission() {
		return idMission;
	}



	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}



	public Message getMessage() {
        return message;
    }

    public void setMessage( Message message ) {
        this.message = message;
    }

}
