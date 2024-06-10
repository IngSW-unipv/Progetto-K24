package Autenticazionecontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Index.IndexModel;
import Index.IndexView;

public class LogoutController {

	public LogoutController() {

	}

	
	public static void addListenersindex(IndexModel m, IndexView view) {

		ActionListener loguot = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				manageAction();

			}

			private void manageAction() {

				m.clear();
				view.dispose();
				m.createBigFrame();

			}

		};

		view.getLogoutButton().addActionListener(loguot);

	};

}
