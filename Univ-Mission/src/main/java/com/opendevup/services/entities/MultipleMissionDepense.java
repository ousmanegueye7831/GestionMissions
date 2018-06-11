package com.opendevup.services.entities;

import com.opendevup.entities.Depense;


public class MultipleMissionDepense {
	private Long idMission;
	private Depense depense;
	public MultipleMissionDepense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdMission() {
		return idMission;
	}
	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}
	public Depense getDepense() {
		return depense;
	}
	public void setDepense(Depense depense) {
		this.depense = depense;
	}
	

}
