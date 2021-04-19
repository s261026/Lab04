package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	public Model () {
		corsoDao = new CorsoDAO();
		studenteDao = new StudenteDAO();
	}
	public void getCorso(Corso corso) {
	}
	public List<Corso> getTuttiICorsi() {
		return corsoDao.getTuttiICorsi();
	}
	public void getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
	}
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		return corsoDao.inscriviStudenteACorso(studente, corso);
	}
	public List <Studente> studentiIscritti (Corso corso){
		return corsoDao.studentiIscritti(corso);
	}
	
	public List <Corso> corsiDelloStudente(Studente studente){
		return studenteDao.corsiDelloStudente(studente);
	}

}
