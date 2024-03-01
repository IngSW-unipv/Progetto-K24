package Test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import DataBase.UtenteDao;
import Utente.UtenteAutenticato;

public class UtenteAutenticatoTest {

	private UtenteAutenticato utente;

	@Before
	public void setUp() {
		 UtenteAutenticato.getInstance().setUsername("testtest");
		 UtenteAutenticato.getInstance().setEmail( "test33@example.com");
		 char [] passwrod ={'P','a','s','s','w','o','r','d','8','!'};
		 UtenteAutenticato.getInstance().setPassword(passwrod);
	}
	// Prima di testare eliminaAccount e cambiaUsername bisogna sempre essere sicuri
	// che sia nel database l'utente

	@Test
	public void testRegistrazioneCredenziali() {
		UtenteAutenticato.getInstance().setUsername("nuovoUtente1");
		 UtenteAutenticato.getInstance().setEmail("nuovoUtente@example.com" );
		 char [] passwrod ={'n','e','w','P','a','s','s','w','o','r','d','8','!'};
		 UtenteAutenticato.getInstance().setPassword(passwrod);

		try {
			UtenteAutenticato.getInstance().registrazioneCredenziali(UtenteAutenticato.getInstance());

			assertTrue(UtenteAutenticato.getInstance().ricercaUtente(UtenteAutenticato.getInstance().getEmail()));
		} catch (SQLException e) {
			fail("Eccezione SQL durante la registrazione del nuovo utente: " + e.getMessage());
		}
	}   

	@Test
	public void testCambiaUsername() {
		String nuovoNome = "nuovoNome";
		UtenteAutenticato.getInstance().cambiaUsername(nuovoNome);
		// Qui ci vuole un metodo che vada a leggere nel database il nome di un utente a
		// partire dalla sua mail
		// assertEquals(nuovoNome, SingletonGestione.getInstance().getUtentedao().);
	}

	@Test
	public void testEliminaAccount() {

		UtenteAutenticato.getInstance().eliminaAccount();

		assertTrue(!(UtenteAutenticato.getInstance().ricercaUtente(UtenteAutenticato.getInstance().getEmail())));
	}

	@Test
	public void testCreazioneTorneo() {
		String nomeTorneo = "Torneoditest4";
		String nomeCreatore = "testtest";
		String gioco = "Giocoditest";
		Date dataInizio = new Date();
		dataInizio.setDate(12);
		Date dataFine = new Date();
		dataFine.setDate(23);
		UtenteAutenticato.getInstance().creazioneTorneo(nomeTorneo, nomeCreatore, gioco, dataInizio, dataFine);

		assertTrue(!(UtenteAutenticato.getInstance().ricercaTorneo(nomeTorneo)));
		
	}

	@Test
	public void testIscrizioneTorneo() {
		String emailUtente = "test35@example.com"; 
		String nomeTorneo = "Torneoditest4";
		UtenteAutenticato.getInstance().iscrizioneTorneo(emailUtente, nomeTorneo);

		assertTrue(UtenteAutenticato.getInstance().ricercaIscritto(nomeTorneo, emailUtente));
	}

	@Test
	public void testDisiscrizioneTorneo() {
		String emailUtente = "test@example.com";
		String nomeTorneo = "Torneoditest4";
		UtenteAutenticato.getInstance().disiscrizioneTorneo(emailUtente, nomeTorneo);

		assertTrue(!(UtenteAutenticato.getInstance().ricercaIscritto(nomeTorneo, emailUtente)));
	}

	@Test
	public void testEliminaTorneo() {
		String nomeTorneo = "Torneoditest4";
		String nomeUtente = "nuovoUtente"; 
		UtenteAutenticato.getInstance().eliminaTorneo(nomeTorneo, nomeUtente);

		assertTrue((UtenteAutenticato.getInstance().ricercaTorneo(nomeTorneo)));
	}

	
	
}