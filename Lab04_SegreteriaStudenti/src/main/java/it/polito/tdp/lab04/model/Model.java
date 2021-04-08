package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	
	public Model () {
		corsoDao = new CorsoDAO();
		
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
	

}
