package GiochiPlaceholder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Index.IndexModel;
import Index.IndexView;

public class TetrisController {
	public static void addListenersindex(IndexModel m,IndexView view) {
		
		
		ActionListener tetris=new ActionListener() {@Override
			
		public void actionPerformed(ActionEvent e) {
			
			manageAction();
			
		}
		
		private void manageAction() {
			
			
			m.tetrisPlay();
			
			
		}
		
		};
		
		view.getTetrisButton().addActionListener(tetris);
		
	}

}
