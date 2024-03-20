package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import DataBase.TorneoDao;
import TorneoModel.TorneoModel;
import TorneoView.IscrizioneTorneoView;
import TorneoView.PartecipaTorneoView;

public class PartecipaTorneoController {

	private PartecipaTorneoView view;
	private TorneoModel model;

	public PartecipaTorneoController(PartecipaTorneoView view, TorneoModel model) {
		// TODO Auto-generated constructor stub
		this.view = view;
		this.model = model;
		addListeners();
		inserisciTornei();

	}

	private void inserisciTornei() {

		view.getPanel().remove(view.getTorneo());
		view.setOptions(TorneoDao.getInstance().selezionalistatorneobypartecipante(model.getEmail())
				.toArray(view.getOptions()));
		view.setTorneo(new JComboBox<>(TorneoDao.getInstance().selezionalistatorneobypartecipante(model.getEmail())
				.toArray(view.getOptions())));
		view.getPanel().add(view.getTorneo());
		// for(int
		// i=0;i<TorneoDao.getInstance().selezionalistatorneobypartecipante(model.getEmail()).size();i++)
		// view.getTorneo().addItem(TorneoDao.getInstance().selezionalistatorneobypartecipante(model.getEmail()).get(i));;
	}

	private void addListeners() {
		view.getClassificaTorneo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == view.getClassificaTorneo()) {

					// DefaultTableModel modelclassifica = (DefaultTableModel)
					// view.getTable().getModel();
					System.out.print(view.getOptions()[0]);
					List<Integer> arrayList = new ArrayList<Integer>(
							model.classificaTorneo(view.getOptions()[0]).values());
					List<String> key = new ArrayList<String>(model.classificaTorneo(view.getOptions()[0]).keySet());
					// modelclassifica.addRow();
					System.out.print(arrayList);
					// modelclassifica.addRow();
					view.getTable().setValueAt(arrayList.get(1), 0, 0);
					view.getTable().setValueAt(key.get(1), 0, 1);
					view.getTable().setValueAt(arrayList.get(0), 1, 0);
					view.getTable().setValueAt(key.get(0), 1, 1);

				}

			}
		});

		view.getPartecipaTorneo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == view.getPartecipaTorneo()) {

					System.out.print(view.getOptions()[0]);
					model.partecipaToreno(view.getOptions()[0]);

				}

			}
		});

	}

}
