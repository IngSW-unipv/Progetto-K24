package Index;

import Torneo.TorneoModel;
import TorneoController.CreaTorneoController;
import TorneoController.DisiscrizioneTorneoController;
import TorneoController.EliminaTorneoController;
import TorneoController.IscrizioneTorneoController;
import TorneoView.CreaTorneoView;
import TorneoView.DisiscrizioneTorneoView;
import TorneoView.EliminaTorneoView;
import TorneoView.IscrizioneTorneoView;

public class IndexModel {

	 private CreaTorneoController creatorneocontroller;
	 private DisiscrizioneTorneoController disicrizionetorneocontroller;
	 private EliminaTorneoController eliminatorneocontroller;
	 private IscrizioneTorneoController iscrizionetorneocontroller;
	 private EliminaTorneoView eliminaview;
	 private DisiscrizioneTorneoView disiscrizione;
	 private IscrizioneTorneoView iscrizioneview;
	 private CreaTorneoView creatorneoview;
	 private TorneoModel model=new TorneoModel();
	 
	 
	public void eliminatorneoController() {

		eliminaview=new EliminaTorneoView();
		
		eliminatorneocontroller=new EliminaTorneoController(eliminaview,model);
		
	}

	public void disiscrivitiTorneocontroller() {

		disiscrizione=new DisiscrizioneTorneoView();
		
        disicrizionetorneocontroller=new DisiscrizioneTorneoController(disiscrizione,model);
	}

	public void iscrivitiTorneocontroller() {

		iscrizioneview=new IscrizioneTorneoView();
        iscrizionetorneocontroller=new IscrizioneTorneoController(iscrizioneview,model);
	}

	public void creaTorneoontroller() {

		
		creatorneoview=new CreaTorneoView();
		creatorneocontroller=new CreaTorneoController(creatorneoview,model);
	}

}
