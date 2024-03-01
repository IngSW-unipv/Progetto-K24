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
		 UtenteAutenticato.getInstance().setEmail( "test@example.com");
		 UtenteAutenticato.getInstance().setPassword("Password8!");
	}
	// Prima di testare eliminaAccount e cambiaUsername bisogna sempre essere sicuri
	// che sia nel database l'utente

	@Test
	public void testRegistrazioneCredenziali() {
		UtenteAutenticato.getInstance().setUsername("nuovoUtente");
		 UtenteAutenticato.getInstance().setEmail("nuovoUtente@example.com" );
		 UtenteAutenticato.getInstance().setPassword("nuovaPassword8!");

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
		String nomeTorneo = "Torneo di test";
		String nomeCreatore = "testtest";
		String gioco = "Gioco di test";
		Date dataInizio = new Date();
		Date dataFine = new Date();
		UtenteAutenticato.getInstance().creazioneTorneo(nomeTorneo, nomeCreatore, gioco, dataInizio, dataFine);

		assertTrue(UtenteAutenticato.getInstance().ricercaTorneo(nomeTorneo));
		var lista = UtenteAutenticato.getInstance().ricercaDatiTorneo(nomeTorneo);
		assertEquals(nomeTorneo, lista.get(0));
		assertEquals(nomeCreatore, lista.get(1));
		assertEquals(gioco, lista.get(2));
		assertEquals(dataInizio, lista.get(3));
		assertEquals(dataFine, lista.get(4));

	}

	@Test
	public void testIscrizioneTorneo() {
		String emailUtente = "test23@example.com";
		String nomeTorneo = "Torneo di test";
		utente.iscrizioneTorneo(emailUtente, nomeTorneo);

		assertTrue(UtenteAutenticato.getInstance().ricercaIscritto(nomeTorneo, emailUtente));
	}

	@Test
	public void testDisiscrizioneTorneo() {
		String emailUtente = "test@example.com";
		String nomeTorneo = "Torneo di test";
		UtenteAutenticato.getInstance().disiscrizioneTorneo(emailUtente, nomeTorneo);

		assertTrue(!(UtenteAutenticato.getInstance().ricercaIscritto(nomeTorneo, emailUtente)));
	}

	@Test
	public void testEliminaTorneo() {
		String nomeTorneo = "Torneo di test";
		String nomeUtente = "nuovoUtente";
		utente.eliminaTorneo(nomeTorneo, nomeUtente);

		assertTrue(!(UtenteAutenticato.getInstance().ricercaTorneo(nomeTorneo)));
	}

	
	
}