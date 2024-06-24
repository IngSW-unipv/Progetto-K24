drop schema if exists java;
create schema java;
use java;

CREATE TABLE utenti (
email VARCHAR(30) PRIMARY KEY,
username LONGTEXT,
pswrd LONGTEXT
);

CREATE TABLE giochi (
	nomegioco VARCHAR(20) PRIMARY KEY
);

CREATE TABLE tornei (
    nometorneo VARCHAR(20) PRIMARY KEY,
    creatore VARCHAR(30),
    datainizio DATETIME,
    datafine DATETIME,
    gioco varchar(20),
    FOREIGN KEY (gioco) REFERENCES giochi(nomegioco) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (creatore) REFERENCES utenti(email) ON UPDATE CASCADE ON DELETE CASCADE 
);

CREATE INDEX idx_email ON utenti(email);

CREATE TABLE partecipazioni (
    emailUtente VARCHAR(30),
    nometorneo VARCHAR(20),
    punteggio INT,
    PRIMARY KEY (emailUtente, nometorneo),
    FOREIGN KEY (emailUtente) REFERENCES utenti(email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (nometorneo) REFERENCES tornei(nometorneo) ON UPDATE CASCADE ON DELETE CASCADE  
);

CREATE TABLE preferenze (
	emailUtente VARCHAR(30),
    gioco VARCHAR(20),
    PRIMARY KEY (emailUtente, gioco),
    FOREIGN KEY (emailUtente) REFERENCES utenti(email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (gioco) REFERENCES giochi(nomegioco) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO giochi VALUES ('Minesweeper'), ('Snake'), ('SpaceInvaders'), ('Tetris'), ('Solitario');
INSERT INTO utenti VALUES
('luca@luca.luca', 'Brucone', '�.\'�Ǝh�\'eï�j��Kx��U�>�d~��'),
('LaMiaPswdèA@A.it', 'Gbqhciò', 'U��Ђd�y]9	q���ԕr�O�U��������'),
('passwordèD@icloud.com', 'UomoCrescenza', '?9��H川�B���W���NK���t]C');

INSERT INTO tornei VALUES
('TorneoDiProva', 'LaMiaPswdèA@A.it', '2021-12-22', '2021-12-24', 'Solitario');

select * from utenti;
select * from tornei;
select * from giochi;
select * from partecipazioni;
select * from preferenze;