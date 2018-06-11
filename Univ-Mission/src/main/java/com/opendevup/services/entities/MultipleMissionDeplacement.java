package com.opendevup.services.entities;

import com.opendevup.entities.Deplacement;

public class MultipleMissionDeplacement {
	private Long idMission;
	private Deplacement deplacement;
	public MultipleMissionDeplacement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdMission() {
		return idMission;
	}
	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}
	public Deplacement getDeplacement() {
		return deplacement;
	}
	public void setDeplacement(Deplacement deplacement) {
		this.deplacement = deplacement;
	}
	

}
