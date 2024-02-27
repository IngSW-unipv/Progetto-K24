package Index;

import TorneoController.CreaTorneoController;
import TorneoController.DisiscrizioneTorneoController;
import TorneoController.EliminaTorneoController;
import TorneoController.IscrizioneTorneoController;

public class IndexModel {

	 private CreaTorneoController creatorneocontroller;
	 private DisiscrizioneTorneoController disicrizionetorneocontroller;
	 private EliminaTorneoController eliminatorneocontroller;
	 private IscrizioneTorneoController iscrizionetorneocontroller;
	 
	 
	public void Eliminatorneocontroller() {

		
		
		eliminatorneocontroller=new EliminaTorneoController();
		
	}

	public void Disiscrivititorneocontroller() {

		
        disicrizionetorneocontroller=new DisiscrizioneTorneoController();
	}

	public void Iscrivititorneocontroller() {

		
        iscrizionetorneocontroller=new IscrizioneTorneoController();
	}

	public void Creatorneocontroller() {

		
		creatorneocontroller=new CreaTorneoController();
	}

}
