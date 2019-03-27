package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private TextArea txtTime;
    
    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML
    void doInsert(ActionEvent event) {
    	txtResult.clear(); //ogni volta mi cancella quello che c'è nel box e quindi poi mi stampa in ordine il contenuto dell'elenco
       
    	long time=System.nanoTime();
        
        String st=txtParola.getText();
        
    	 if(st.trim().isEmpty()) {//in questo modo non mi inserisce se lascio vuoto lo spazio e nemmeno se faccio lo spazio e lascio vuoto lo spazio.
    		 	txtResult.appendText("Parola inserita non valida! Inserire nuovamente\n");
    		 	txtTime.appendText(Long.toString(System.nanoTime()-time)+"\n");
    		return;}
    		 
    	elenco.addParola(st.trim());
   
    	
    	for(int i=0; i<elenco.getElenco().size(); i++) {
    		txtResult.appendText(elenco.getElenco().get(i).trim()+"\n");
    	}
    	
    	txtTime.appendText(Long.toString(System.nanoTime()-time)+"\n");
	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	long time=System.nanoTime();
    	
    	elenco.reset();
    	txtResult.clear();
    	txtTime.clear();
    	
    	txtTime.appendText(Long.toString(System.nanoTime()-time)+"\n");
    }
    

    @FXML
    void doDelete(ActionEvent event) {
    	long time=System.nanoTime();
    	String st=txtResult.getSelectedText();
    	
    	elenco.delete(st);
    	
    	//txtResult.appendText("Parola cancellata: "+st+"\n");
    	txtTime.appendText(Long.toString(System.nanoTime()-time)+"\n");

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";
        
        elenco = new Parole() ;
        
    }
}
