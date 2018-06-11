package com.opendevup.metier;

import java.util.List;

import com.opendevup.entities.Mission;
import com.opendevup.services.entities.MultipleDeplacementDepense;

public interface RemboursementMetier {
	
	public List<Mission> listeMissionCourant( Long id);
	public MultipleDeplacementDepense listeRemb(Mission m);
	
}
