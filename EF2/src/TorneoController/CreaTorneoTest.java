package TorneoController;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import TorneoView.CreaTorneoView;

public class CreaTorneoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
    
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		CreaTorneoView view =new CreaTorneoView();
		view.setVisible(false);
		view.setNomeText(new JTextField("Torneo1"));
		view.setNomeText(new JTextField("Torneo2"));
		view.setNomeText(new JTextField("Torneo3"));
		
		CreaTorneoController c=new CreaTorneoController();
		
		assertTrue(c.isIstrue());
	}

}
