package GiochiPlaceholder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Index.IndexModel;
import Index.IndexView;

public class SolitarioController {
	public static void addListenersindex(IndexModel m,IndexView view) {
		
		
		ActionListener solitario=new ActionListener() {@Override
			
		public void actionPerformed(ActionEvent e) {
			
			manageAction();
			
		}
		
		private void manageAction() {
			
			
			m.solitarioPlay();
			
			
		}
		
		};
		
		view.getSolitarioButton().addActionListener(solitario);
		
	}

}
