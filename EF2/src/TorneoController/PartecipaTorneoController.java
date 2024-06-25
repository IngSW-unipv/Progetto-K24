package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import Index.IndexModel;
import Index.IndexView;
import TorneoModel.TorneoModel;
import TorneoView.PartecipaTorneoView;
import Utente.UtenteAutenticato;

public class PartecipaTorneoController {

	private PartecipaTorneoView v;
	private TorneoModel model;

	public PartecipaTorneoController(PartecipaTorneoView v, TorneoModel model) {
		// TODO Auto-generated constructor stub
		this.v = v;
		this.model = model;
		addListeners();
		inserisciTornei();

	}

	public static void addListenersindex(IndexModel m, IndexView view) {

		ActionListener partecipatorneo = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				manageAction();

			}

			private void manageAction() {

				m.partecipaTorneocontroller();

			}

		};

		view.getPartecipaTorneo().addActionListener(partecipatorneo);

	}

	private void inserisciTornei() {

		v.getPanel().remove(v.getTorneo());
		v.setOptions(model.selezionalistatorneobypartecipante(model.getEmail())
				.toArray(v.getOptions()));
		v.setTorneo(new JComboBox<>(model.selezionalistatorneobypartecipante(model.getEmail())
				.toArray(v.getOptions())));
		v.getPanel().add(v.getTorneo());

	}

	private void addListeners() {
		v.getClassificaTorneo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == v.getClassificaTorneo()) {

					System.out.print(v.getOptions()[0]);
					v.setArrayList(new ArrayList<Integer>(model.classificaTorneo(v.getOptions()[0]).values()));
					System.out.print(v.getOptions()[0]);
					v.setKey(new ArrayList<String>(model.classificaTorneo(v.getOptions()[0]).keySet()));

					System.out.print(v.getArrayList());
					System.out.print(v.getKey());
					v.getTable().setValueAt(v.getArrayList().get(0), 0, 0);
					v.getTable().setValueAt(v.getKey().get(0), 0, 1);
					// da mettere quando ci sono più righe
					// v.getTable().setValueAt(v.getArrayList().get(0), 1, 0);
					// v.getTable().setValueAt(v.getKey().get(0), 1, 1);

				}

			}
		});

		v.getPartecipaTorneo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == v.getPartecipaTorneo()) {

					System.out.print(v.getOptions()[0]);
					model.partecipaToreno(v.getOptions()[0]);

				}

			}
		});

	}

}
