package it.polito.tdp.lab04.model;

public class Studente {
	
	private String nome;
	private String cognome;
	private int matricola;
	private String cds;
	
	public Studente(String nome, String cognome, int matricola, String cds) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.cds = cds;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getCds() {
		return cds;
	}
	public void setCds(String cds) {
		this.cds = cds;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cds == null) ? 0 : cds.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + matricola;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (cds == null) {
			if (other.cds != null)
				return false;
		} else if (!cds.equals(other.cds))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (matricola != other.matricola)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Studente [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", cds=" + cds + "]";
	}
	
	

}
