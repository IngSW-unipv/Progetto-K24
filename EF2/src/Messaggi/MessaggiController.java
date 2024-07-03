package Messaggi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Index.IndexModel;
import Index.IndexView;
import TorneoModel.TorneoModel;

public class MessaggiController {

	public static void addListenersindex(IndexModel model,IndexView view) {
		view.getMessaggiButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.messaggiView();
				
			}
		});
	}
}
