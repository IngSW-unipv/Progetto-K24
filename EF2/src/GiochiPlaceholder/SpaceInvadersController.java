package GiochiPlaceholder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Index.IndexModel;
import Index.IndexView;

public class SpaceInvadersController {
	public static void addListenersindex(IndexModel m,IndexView view) {
		
		
		ActionListener spaceinvaders=new ActionListener() {@Override
			
		public void actionPerformed(ActionEvent e) {
			
			manageAction();
			
		}
		
		private void manageAction() {
			
			
			m.spaceInvadersPlay();
			
			
		}
		
		};
		
		view.getSpaceInvadersButton().addActionListener(spaceinvaders);
		
	}

}
