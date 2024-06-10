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

	private PartecipaTorneoView view;
	private TorneoModel model;

	public PartecipaTorneoController(PartecipaTorneoView view, TorneoModel model) {
		// TODO Auto-generated constructor stub
		this.view = view;
		this.model = model;
		addListeners();
		inserisciTornei();

	}

	 public static void addListenersindex(IndexModel m,IndexView view) {
			
			
			ActionListener partecipatorneo=new ActionListener() {@Override
				
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

		view.getPanel().remove(view.getTorneo());
		view.setOptions(UtenteAutenticato.getInstance().selezionalistatorneobypartecipante(model.getEmail())
				.toArray(view.getOptions()));
		view.setTorneo(new JComboBox<>(UtenteAutenticato.getInstance().selezionalistatorneobypartecipante(model.getEmail())
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
					view.setArrayList( new ArrayList<Integer>(
			        model.classificaTorneo(view.getOptions()[0]).values()));
					view.setKey(new ArrayList<String>(model.classificaTorneo(view.getOptions()[0]).keySet()));
					// modelclassifica.addRow();
					System.out.print(view.getArrayList());
					// modelclassifica.addRow();
					view.getTable().setValueAt(view.getArrayList().get(1), 0, 0);
					view.getTable().setValueAt(view.getKey().get(1), 0, 1);
					view.getTable().setValueAt(view.getArrayList().get(0), 1, 0);
					view.getTable().setValueAt(view.getKey().get(0), 1, 1);

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
