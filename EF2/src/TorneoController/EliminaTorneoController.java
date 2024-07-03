package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Index.IndexModel;
import Index.IndexView;
import TorneoModel.TorneoModel;
import TorneoView.EliminaTorneoView;


public class EliminaTorneoController {

	private EliminaTorneoView view;
	
	private TorneoModel model;

	public EliminaTorneoController(EliminaTorneoView view, TorneoModel model) {

		this.view = view;
		this.model = model;
		addListeners();
	}

	 public static void addListenersindex(IndexModel m,IndexView view) {
			
			
			ActionListener eliminatorneo=new ActionListener() {@Override
				
			public void actionPerformed(ActionEvent e) {
				
				manageAction();
				
			}
			
			private void manageAction() {
				
				
				m.eliminatorneoController();;
				
				
			}
			
			};
			
			view.getEliminaTorneo().addActionListener(eliminatorneo);
			
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
