package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Index.IndexModel;
import Index.IndexView;
import TorneoModel.TorneoModel;
import TorneoView.DisiscrizioneTorneoView;


public class DisiscrizioneTorneoController {

	private DisiscrizioneTorneoView view;
	
	private TorneoModel model;

	public DisiscrizioneTorneoController(DisiscrizioneTorneoView view, TorneoModel model) {

		this.view = view;
		this.model = model;
		addListeners();
		
	}
	 public static void addListenersindex(IndexModel m,IndexView view) {
			
			
			ActionListener disiscrivititorneo=new ActionListener() {@Override
				
			public void actionPerformed(ActionEvent e) {
				
				manageAction();
				
			}
			
			private void manageAction() {
				
				
				m.disiscrivitiTorneocontroller();
				
				
			}
			
			};
			
			view.getDisiscrivitiTorneo().addActionListener(disiscrivititorneo);
			
		}

	private void addListeners() {
		view.getDisiscrizioneTorneo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == view.getDisiscrizioneTorneo()) {

					
					model.disiscrizioneTorneo(model.getEmail(), view.getNomeText().getText());

				}

			}
		});
	}
}
