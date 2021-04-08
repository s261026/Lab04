package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				
				Corso c = new Corso (rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				corsi.add(c);
				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}

			conn.close();
			rs.close();
			st.close();
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
		
		String sql = "SELECT c.nome "
				+ "FROM corso "
				+ "WHERE c.codins = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodins()); 
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				corso = new Corso (rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				
			}

			conn.close();
			
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
			
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public void getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
			String sql ="SELECT s.matricola, s.nome, s.cognome, s.cds "
					+ "FROM studente s, iscrizione i "
					+ "WHERE s.matricola = i.matricola AND i.codins=?";
			List <Studente> result = new LinkedList <Studente>();
			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, corso.getCodins());
				ResultSet rs = st.executeQuery();
				while(rs.next()){
					Studente s = new Studente( rs.getString("nome"), rs.getString("cognome"),rs.getInt("matricola"), rs.getString("CDS"));
					result.add(s);
				}
				conn.close();
				rs.close();
				st.close();
				
			}catch (SQLException ee) {
				throw new RuntimeException(ee);
			}
						
		}
	

		 // dal dao prendo i dati dal db
		public boolean esisteCorso(Corso corso) {
			String sql="SELECT * FROM corso WHERE codins=?";
			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, corso.getCodins());
				ResultSet rs = st.executeQuery(); //4 righe sempre da copiare
				if(rs.next())
				{
					conn.close();
					rs.close();
					st.close();
					
					return true;
					
				}
				else
				{
					conn.close();
					rs.close();
					st.close();
					//altre 3 righe fisse sempre da mettere --> se ho più return devo mettere le close ogni volta che ho un return
					return false;
				}
				
			}catch (SQLException ee) {
				throw new RuntimeException(ee);
			
			}
		
		}


	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

}
