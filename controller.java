package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class controller extends  Application implements Initializable{
	   @FXML
	    private Button Client;
          
	    @FXML
	    private Button Facture;

	    @FXML
	    private Button Fournisseur;

	    @FXML
	    private Button Produit;
	    
	    @FXML
	    private AnchorPane ap;

	    @FXML
	    private BorderPane bp;

	    @FXML
	    private VBox vbox;
	     
        private Parent fxml;
	     @FXML
	     void Client(ActionEvent event) {
	    	 TranslateTransition t=new TranslateTransition(Duration.seconds(1),vbox);
		      t.setToX(5);
		      t.play();
		      t.setOnFinished(e->{
		      try{
		    	  fxml=FXMLLoader.load(getClass().getResource("Client.fxml"));
		    	  vbox.getChildren().removeAll();
		    	  vbox.getChildren().setAll(fxml);
		      }catch (Exception e1) {
		    	  e1.printStackTrace();
		      }
		      });
	     }

	     @FXML
	     void Facture(ActionEvent event) {
	    	 TranslateTransition t=new TranslateTransition(Duration.seconds(1),vbox);
		      t.setToX(5);
		      t.play();

                   
	     }

	     @FXML
	     void Fournisseur(ActionEvent event) {
	    	 TranslateTransition t=new TranslateTransition(Duration.seconds(1),vbox);
		      t.setToX(5);
		      t.play();


	     }

	    
		@FXML
	     void Produit(ActionEvent event) {
			 TranslateTransition t=new TranslateTransition(Duration.seconds(1),vbox);
		      t.setToX(5);
		      t.play();


	     }
		

	    
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TranslateTransition t=new TranslateTransition(Duration.seconds(1),vbox);
		      t.setToX(vbox.getLayoutX()*5.5);
		      t.play();
		      
		  
	}   
	       

}
