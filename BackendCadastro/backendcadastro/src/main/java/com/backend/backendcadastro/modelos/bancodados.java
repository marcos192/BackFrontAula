/* CREATE DATABASE Animes01;
USE Animes01;

CREATE TABLE AUTOR 
(
	IdAutor  				int primary key NOT NULL AUTO_INCREMENT,
	nomeAutor             	varchar(50)		NOT NULL,
	idadeAutor    			varchar(3)		NOT NULL,
    anoNascimentoAutor		date			NOT NULL,
	nomePersona         	varchar(50)		NOT NULL,
	idadePersona      		varchar(3)		NOT NULL,
	sexoPersona       		varchar(20)		NOT NULL
);
        
 
INSERT INTO AUTOR (IdAutor, nomeAutor, idadeAutor, anoNascimentoAutor, nomePersona, idadePersona, sexoPersona)
value
(1, 'Masami',67, 19980304, 'Masami',66, 'M');  

 INSERT INTO AUTOR (IdAutor, nomeAutor, idadeAutor, anoNascimentoAutor, nomePersona, idadePersona,sexoPersona)
value
(2, 'Masami',67, 19980304, 'Masami',66, 'M');  */