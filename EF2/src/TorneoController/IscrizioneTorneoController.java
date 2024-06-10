package TorneoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Index.IndexModel;
import Index.IndexView;
import TorneoModel.TorneoModel;
import TorneoView.IscrizioneTorneoView;


public class IscrizioneTorneoController {

	private IscrizioneTorneoView view;
	private TorneoModel model;

	public IscrizioneTorneoController(IscrizioneTorneoView view, TorneoModel model) {
		this.view = view;
		this.model = model;
		addListeners();
	}

	public static void addListenersindex(IndexModel m, IndexView view) {

		ActionListener Iscrizionetorneo = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				manageAction();

			}

			private void manageAction() {

				m.iscrivitiTorneocontroller();

			}

		};

		view.getIscrivitiTorneo().addActionListener(Iscrizionetorneo);

	}

	private void addListeners() {
		view.getIscrivitiTorneo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == view.getIscrivitiTorneo()) {

					model.iscrizioneTorneo(model.getEmail(), view.getNomeText().getText());
					view.dispose();
				}

			}
		});
	}
}
