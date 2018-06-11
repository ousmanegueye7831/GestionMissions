package com.opendevup.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.DeplacementRepository;
import com.opendevup.dao.EtatsRepository;
import com.opendevup.dao.MissionRepository;
import com.opendevup.entities.Deplacement;
import com.opendevup.services.entities.MultipleMissionDeplacement;

@Service
public class DeplacementMetierImpl implements DeplacementMetier {
	@Autowired
	private DeplacementRepository deplacementRepository;
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private EtatsRepository etatsRepository;
	
	@Override
	public Boolean saveDeplacement(MultipleMissionDeplacement deplacement) {
		// TODO Auto-generated method stub
		deplacement.getDeplacement().setMission_fk(missionRepository.findOne(deplacement.getIdMission()));
		deplacementRepository.save(deplacement.getDeplacement());
		System.out.println(deplacement.getIdMission());
		etatsRepository.updateEtatRemboursement("en cours", deplacement.getIdMission(), "GestionnaireSTGI");
		return true;
	}

}
