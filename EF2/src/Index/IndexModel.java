package Index;

import Autenticazionemodel.GestioneAccountModel;
import Autenticazioneview.BigFrameController;
import Autenticazioneview.BigFrameModel;
import Autenticazioneview.BigFrameView;
import GestioneAccount.EliminaAccountController;
import GestioneAccount.EliminaAccountView;
import GestioneAccount.ModificaAccountView;
import GiochiPlaceholder.*;
import Minesweeper.MinesweeperController.MinesweeperController;
import Minesweeper.MinesweeperModel.MinesweeperModel;
import Minesweeper.MinesweeperView.MinesweeperView;
import SnakeController.SnakeController;
import SnakeModel.SnakeGame;
import SnakeView.SnakeView;
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
	 
	 // Relativi alla gestione account
	 public void modificaAccount() {
	    	GestioneAccount.ModificaAccountController n = new GestioneAccount.ModificaAccountController(new GestioneAccountModel(),new ModificaAccountView());
	 }
	 
	 public void eliminaAccount(IndexView lastView) {
			new EliminaAccountController(new GestioneAccountModel(),new EliminaAccountView(), lastView);		
	 }
	 
	 // Relativi ai tornei
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

	 public void creaTorneocontroller() {
 
		
		creatorneoview=new CreaTorneoView();
		creatorneocontroller=new CreaTorneoController(creatorneoview,model);
	 }

	 public void partecipaTorneocontroller() {

		partecipatorneoview = new PartecipaTorneoView();
		partecipatorneoc = new PartecipaTorneoController(partecipatorneoview, model);
	 }
	 
	 // Relativi ai giochi
	 public void minesweeperPlay() {

		modelm=new MinesweeperModel();
		view=new MinesweeperView();
		
		MinesweeperController c=new MinesweeperController(modelm ,view );
		
	 }
	
	 public void snakePlay() {

		SnakeGame model = new SnakeGame();
		SnakeView view = new SnakeView(model);

		  new SnakeController();

	 }
	
	 //Serie di metodi placeholder
	 public void spaceInvadersPlay() {
		new SpaceInvadersPlaceholder();
	 }
	
	 public void tetrisPlay() {
		new TetrisPlaceholder();
	 }
	
	 public void solitarioPlay() {
		new SolitarioPlaceholder();
	 }
	
	 // Relativi alle preferenze
	 // Mancano alcune cose erronamente messe nel controller
	 public void insertPreferiti(GiochiEnum gioco) {
		 UtenteAutenticato.getInstance().insertPreferiti(gioco);
	 }
	 
	 public void deletePreferiti(GiochiEnum gioco) {
		 UtenteAutenticato.getInstance().deletePreferiti(gioco);

	 }
	 
	 // Altro
	public void createBigFrame() {
		new BigFrameController(new BigFrameView(), new BigFrameModel());		
	}
	
	 public void clear() {
		UtenteAutenticato.getInstance().clear();
	 }



}
