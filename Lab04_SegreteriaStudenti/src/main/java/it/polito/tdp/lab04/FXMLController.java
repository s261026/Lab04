package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import it.polito.tdp.lab04.*;
import it.polito.tdp.lab04.DAO.CorsoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Corso corsoSelezionato;

	private Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<Corso> menuCorsi;

	@FXML
	private Button btnIscrittiCorso;

	@FXML
	private TextField txtMatricolaStudente;

	@FXML
	private CheckBox check;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCognome;

	@FXML
	private Button btnCorsi;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	void doCompletamentoAutomatico(ActionEvent event) {

		this.check.setDisable(true);

		String matricolaUtente = this.txtMatricolaStudente.getText();

		List<Corso> corsi = this.model.getTuttiICorsi();
		String nomeUtente = null;
		String cognomUtente = null;
		boolean trovato = false;

		for (Corso c : corsi) {
			List<Studente> studenti = this.model.studentiIscritti(c);
			for (Studente s : studenti) {
				if (matricolaUtente.equals(String.valueOf(s.getMatricola()))) {
					nomeUtente = s.getNome();
					cognomUtente = s.getCognome();
					trovato = true;
				}
			}
		}

		if (trovato == false || matricolaUtente.length() != 6)
			this.txtResult.setText("Errore: La matricola inserita non è presente nel database");

		this.txtNome.setText(nomeUtente);
		this.txtCognome.setText(cognomUtente);

	}

	@FXML
	void doIscrizione(ActionEvent event) {

	}

	@FXML
	void doReset(ActionEvent event) {
		
		this.txtMatricolaStudente.clear();
		this.txtNome.clear();
		this.txtCognome.clear();
		this.txtResult.clear();
		this.check.setDisable(false);
		this.menuCorsi.setValue(null);

	}

	@FXML
	void searchCorsi(ActionEvent event) {

		if (corsoSelezionato == null) {
			String matricolaUtente = this.txtMatricolaStudente.getText();
			boolean trovato = false;
			List<Corso> corsi = this.model.getTuttiICorsi();
			List<Corso> corsiPerUtente = null;
			String corsiUtente = "";

			for (Corso c : corsi) {
				List<Studente> studenti = this.model.studentiIscritti(c);
				for (Studente s : studenti) {
					if (matricolaUtente.equals(String.valueOf(s.getMatricola()))) {
						corsiPerUtente = this.model.corsiDelloStudente(s);
						trovato = true;
					}
				}
			}

			if (trovato == false || matricolaUtente.length() != 6)
				this.txtResult.setText("Errore: La matricola inserita non è presente nel database");
			else {
				for (Corso co : corsiPerUtente)
					corsiUtente += co.toString() + "\n";

				this.txtResult.setText(corsiUtente);
			}
		}

		else {
			
			String matricolaUtente = this.txtMatricolaStudente.getText();
			boolean trovato = false;
			List<Corso> corsi = this.model.getTuttiICorsi();
			List<Corso> corsiPerUtente = null;
			String corsiUtente = "";

			for (Corso c : corsi) {
				List<Studente> studenti = this.model.studentiIscritti(c);
				for (Studente s : studenti) {
					if (matricolaUtente.equals(String.valueOf(s.getMatricola()))) {
						corsiPerUtente = this.model.corsiDelloStudente(s);
						trovato = true;
					}
				}
			}

			if (trovato == false || matricolaUtente.length() != 6)
				this.txtResult.setText("Errore: La matricola inserita non è presente nel database");
			else {
				for (Corso co : corsiPerUtente) {
					if(co.equals(corsoSelezionato))
						this.txtResult.setText("Studente iscritto a questo corso");
					else
						this.txtResult.setText("Studente non iscritto a questo corso");
				}
			}
				
		}

	}

	@FXML
	void searchIscrittiCorso(ActionEvent event) {

		List<Studente> studenti = this.model.studentiIscritti(corsoSelezionato);

		if (studenti.size() == 0) {
			txtResult.appendText("il corso non ha iscritti");
			return;
		}

		for (Studente s : studenti) {
			txtResult.appendText(s.toString() + "\n");
		}

	}

	@FXML
	void tuttiCorsi(ActionEvent event) {

		// this.menuCorsi.setItems((ObservableList<Corso>) this.model.getTuttiICorsi());
		// this.menuCorsi.getValue();
		corsoSelezionato = this.menuCorsi.getValue();
		System.out.println(corsoSelezionato);
	}

	@FXML
	void initialize() {
		assert menuCorsi != null : "fx:id=\"menuCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnIscrittiCorso != null
				: "fx:id=\"btnIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtMatricolaStudente != null
				: "fx:id=\"txtMatricolaStudente\" was not injected: check your FXML file 'Scene.fxml'.";
		assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCorsi != null : "fx:id=\"btnCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

		ObservableList<Corso> data = FXCollections.observableArrayList();

		List<Corso> corsi = CorsoDAO.getTuttiICorsi();
		for (Corso c : corsi) {
			data.add(c);
		}
		menuCorsi.setItems(null);
		menuCorsi.setItems(data);
		menuCorsi.getItems().add(0, null);

	}

	public void setModel(Model model) {
		this.model = model;
		// this.menuCorsi.getItems().add(null);
		// this.menuCorsi.getItems().addAll(model.getTuttiICorsi());
	}
}
