package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
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

    }

    @FXML
    void doIscrizione(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void searchCorsi(ActionEvent event) {

    }

    @FXML
    void searchIscrittiCorso(ActionEvent event) {

    }

    @FXML
    void tuttiCorsi(ActionEvent event) {
    	
    	
    	this.menuCorsi.setItems((ObservableList<Corso>) this.model.getTuttiICorsi());
    	this.menuCorsi.getValue();

    }

    @FXML
    void initialize() {
        assert menuCorsi != null : "fx:id=\"menuCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrittiCorso != null : "fx:id=\"btnIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricolaStudente != null : "fx:id=\"txtMatricolaStudente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCorsi != null : "fx:id=\"btnCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel (Model model) {
    	this.model=model;
    	this.menuCorsi.getItems().add(null);
    	this.menuCorsi.getItems().addAll(model.getTuttiICorsi());
    }
}
