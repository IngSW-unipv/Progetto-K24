
package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Utente.SingletonGestione;
import Utente.UtenteAutenticato;

public class UtenteAutenticatoTest {

    private UtenteAutenticato utente;

    @Before
    public void setUp() {
        utente = new UtenteAutenticato("test", "test@example.com", "password");
    }
    //Prima di testare eliminaAccount e cambiaUsername bisogna sempre essere sicuri che sia nel database l'utente 

    @Test
    public void testRegistrazioneCredenziali() {
        UtenteAutenticato nuovoUtente = new UtenteAutenticato("nuovoUtente", "nuovoUtente@example.com", "nuovaPassword");
        try {
            utente.registrazioneCredenziali(nuovoUtente, nuovoUtente.getUsername(), nuovoUtente.getEmail(), nuovoUtente.getPassword().toString());
            
            assertTrue(utente.ricercaUtente(nuovoUtente.getEmail()));
        } catch (SQLException e) {
            fail("Eccezione SQL durante la registrazione del nuovo utente: " + e.getMessage());
        }
    }
    
    @Test
    public void testCambiaUsername() {
        String nuovoNome = "nuovoNome";
        utente.cambiaUsername(nuovoNome);
        //Qui ci vuole un metodo che vada a leggere nel database il nome di un utente a partire dalla sua mail
       // assertEquals(nuovoNome, SingletonGestione.getInstance().getUtentedao().);
    }
    
    @Test
    public void testEliminaAccount() {
         
        utente.eliminaAccount();
        
        assertTrue(!(utente.ricercaUtente(utente.getEmail()))); 
    }

    @Test
    public void testCreazioneTorneo() {
        String nomeTorneo = "Torneo di test";
        String nomeCreatore = "test";
        String gioco = "Gioco di test";
        Date dataInizio = new Date();
        Date dataFine = new Date();
        utente.creazioneTorneo(nomeTorneo, nomeCreatore, gioco, dataInizio, dataFine);
       
        assertTrue(utente.ricercaTorneo(nomeTorneo)); 
        var lista =utente.ricercaDatiTorneo(nomeTorneo);
        assertEquals(nomeTorneo, lista.get(0));
        assertEquals(nomeCreatore, lista.get(1));
        assertEquals(gioco, lista.get(2));
        assertEquals(dataInizio, lista.get(3));
        assertEquals(dataFine, lista.get(4));
          
        
    }

    @Test
    public void testIscrizioneTorneo() {
        String emailUtente = "test@example.com";
        String nomeTorneo = "Torneo di test";
        utente.iscrizioneTorneo(emailUtente, nomeTorneo);
       
        assertTrue(utente.ricercaIscritto(nomeTorneo, emailUtente)); 
    }

    @Test
    public void testDisiscrizioneTorneo() {
        String emailUtente = "test@example.com";
        String nomeTorneo = "Torneo di test";
        utente.disiscrizioneTorneo(emailUtente, nomeTorneo);
        
        assertTrue(!(utente.ricercaIscritto(nomeTorneo, emailUtente))); 
        }

    @Test
    public void testEliminaTorneo() {
        String nomeTorneo = "Torneo di test";
        String nomeUtente = "test";
        utente.eliminaTorneo(nomeTorneo, nomeUtente);
        
        assertTrue(!(utente.ricercaTorneo(nomeTorneo))); 
    }

    @Test
    public void testVisualizzaLista() {
        // In questo test, possiamo controllare solo che il metodo non lanci eccezioni
        // Potresti aggiungere ulteriori controlli se il metodo ha un output specifico da verificare
        utente.visualizzaLista();
        assertTrue(true);
    }
}