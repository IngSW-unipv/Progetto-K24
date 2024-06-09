package Messaggi;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Messaggio {
	private String messaggio;
	private String sender;
	private String receiver;
	private LocalDateTime ora;
	
	// Costruttore per creare messaggio da piattaforma
	public Messaggio(String receiver, String messaggio) {
		this.receiver = receiver;
		this.messaggio = messaggio;
		this.ora = LocalDateTime.now();
	}
	
	// Costruttore per creare messaggio letto da DB
	public Messaggio(String sender, String messaggio, String ora) {
		this.sender = sender;
		this.messaggio = messaggio;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.ora = LocalDateTime.parse(ora, formatter);
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public LocalDateTime getOra() {
		return ora;
	}

	public void setOra(LocalDateTime ora) {
		this.ora = ora;
	}
	
}
