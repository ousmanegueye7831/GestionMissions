package com.opendevup.services.entities;

import java.util.List;

import com.opendevup.entities.Depense;
import com.opendevup.entities.Deplacement;

public class MultipleDeplacementDepense {
	private Long idMission;
	private List<Deplacement> deplacement;
	private List<Depense> depense;
	public MultipleDeplacementDepense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdMission() {
		return idMission;
	}
	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}
	public List<Deplacement> getDeplacement() {
		return deplacement;
	}
	public void setDeplacement(List<Deplacement> deplacement) {
		this.deplacement = deplacement;
	}
	public List<Depense> getDepense() {
		return depense;
	}
	public void setDepense(List<Depense> depense) {
		this.depense = depense;
	}

	

}
