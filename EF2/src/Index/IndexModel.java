package Index;

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
	 
	 
	 
	public void Eliminatorneocontroller() {

		eliminaview=new EliminaTorneoView();
		
		eliminatorneocontroller=new EliminaTorneoController(eliminaview);
		
	}

	public void Disiscrivititorneocontroller() {

		disiscrizione=new DisiscrizioneTorneoView();
		
        disicrizionetorneocontroller=new DisiscrizioneTorneoController(disiscrizione);
	}

	public void Iscrivititorneocontroller() {

		iscrizioneview=new IscrizioneTorneoView();
        iscrizionetorneocontroller=new IscrizioneTorneoController(iscrizioneview);
	}

	public void Creatorneocontroller() {

		
		creatorneoview=new CreaTorneoView();
		creatorneocontroller=new CreaTorneoController(creatorneoview);
	}

}
