package Index;

import Minesweeper.MinesweeperController.MinesweeperController;
import Minesweeper.MinesweeperModel.MinesweeperModel;
import Minesweeper.MinesweeperView.MinesweeperView;
import TorneoController.CreaTorneoController;
import TorneoController.DisiscrizioneTorneoController;
import TorneoController.EliminaTorneoController;
import TorneoController.IscrizioneTorneoController;
import TorneoController.PartecipaTorneoController;
import TorneoModel.TorneoModel;
import TorneoView.CreaTorneoView;
import TorneoView.DisiscrizioneTorneoView;
import TorneoView.EliminaTorneoView;
import TorneoView.IscrizioneTorneoView;
import TorneoView.PartecipaTorneoView;
import Utente.UtenteAutenticato;

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
	 private PartecipaTorneoController partecipatorneoc;
	 private PartecipaTorneoView partecipatorneoview;
	 private MinesweeperModel modelm;
	 private MinesweeperView view;
	 
	 
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

	public void partecipaTorneocontroller() {

		partecipatorneoview = new PartecipaTorneoView();
		partecipatorneoc = new PartecipaTorneoController(partecipatorneoview, model);
	}
	 
	public void minesweeperPlay() {

		modelm=new MinesweeperModel();
		view=new MinesweeperView();
		
		MinesweeperController c=new MinesweeperController(modelm ,view );
		
	}
	
	public void clear() {
		UtenteAutenticato.getInstance().clear();
	}

}
