package com.opendevup.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.DepenseRepository;
import com.opendevup.dao.MissionRepository;
import com.opendevup.entities.Depense;
import com.opendevup.services.entities.MultipleMissionDepense;

@Service
public class DepenseMetierImpl implements DepenseMetier {
	
	@Autowired
	private DepenseRepository depenseRepository;
	@Autowired
	private MissionRepository missionRepository;
	@Override
	public Boolean saveDepense(MultipleMissionDepense depense) {
		// TODO Auto-generated method stub
		
		depense.getDepense().setMission_fk(missionRepository.findOne(depense.getIdMission()));
		depenseRepository.save(depense.getDepense());
		return true;
	}

}
