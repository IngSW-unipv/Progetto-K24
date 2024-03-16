package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TorneoModel.TorneoModel;

import TorneoView.EliminaTorneoView;
import Utente.UtenteAutenticato;

public class EliminaTorneoController {

	private EliminaTorneoView view;
	
	private TorneoModel model;

	public EliminaTorneoController(EliminaTorneoView view, TorneoModel model) {

		this.view = view;
		this.model = model;
		addListeners();
	}

	private void addListeners() {
		view.getEliminaTorneo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (e.getSource() == view.getEliminaTorneo()) {

					model.eliminaTorneo(view.getNomeText().getText(), model.getUsername());
				}

			}
		});

	}
}
