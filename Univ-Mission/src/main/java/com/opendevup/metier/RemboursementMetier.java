package com.opendevup.metier;

import java.util.List;

import com.opendevup.entities.EtatsMission;
import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;
import com.opendevup.services.entities.MultipleDeplacementDepense;

public interface RemboursementMetier {
	
	public List<Mission> listeMissionCourant( Long id);
	public MultipleDeplacementDepense listeRemb(Mission m);
	public Boolean validerRemboursement(EtatsMission e);
	public List<Mission> listMissionRem( Missionnaire ms);
	public List<Mission> chercherRembValider(Long id);
	public List<Mission> chercherRembRefuser(Long id);
	
}
