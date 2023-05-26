package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class clientController extends  Application implements Initializable{
	  PreparedStatement pst;
	     int myIndex;
	     int Id;
	     Connection cn;
	   @FXML
	    private Button btnajout;

	    @FXML
	    private Button btndelete;

	    @FXML
	    private Button btnupdate;
	    @FXML
	    private TableColumn<client, String> id;


	    @FXML
	    private TableColumn<client, String> idemail;

	    @FXML
	    private TableColumn<client, String> idnom;

	    @FXML
	    private TableColumn<client, String>  idadrs;

	    @FXML
	    private TableView<client> table;

	    @FXML
	    private TextField txtN;

	    @FXML
	    private TextField txta;

	    @FXML
	    private TextField txte;

          @FXML
          void delete(ActionEvent event) {  
        	  myIndex = table.getSelectionModel().getSelectedIndex();
 		 
          Id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                       

          try 
          {
              pst = cn.prepareStatement("delete from facturation where id = ? ");
              pst.setInt(1, Id);
              pst.executeUpdate();
              
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("client");

  		
  		alert.setHeaderText("client ");
  		alert.setContentText("Deletedd!");

  		alert.showAndWait();
                    table();
          } 
          catch (SQLException ex)
          {
     	     System.out.println("Erreur de connexion");
          }
      }	
        

                 

             @FXML
             void update(ActionEvent event) {
     	    	String nom,adrs,email;
     	        
     	         myIndex = table.getSelectionModel().getSelectedIndex();
     			 
     	        Id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
     	           
     	            nom = txta.getText();
     	            adrs = txte.getText();
     	            email = txta.getText();
     	        try 
     	        {
     	            pst = cn.prepareStatement("update facturation set nom = ?,adrs = ? ,email = ? where id = ? ");
     	            pst.setString(1, nom);
     	            pst.setString(2, adrs);
     	            pst.setString(3, email);
     	             pst.setInt(4, Id);
     	            pst.executeUpdate();
     	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
     			alert.setTitle("client");

     			
     			alert.setHeaderText("Client");
     			alert.setContentText("Updateddd!");

     			alert.showAndWait();
     	                table();
     	        } 
     	        catch (SQLException ex)
     	        {
     	      	     System.out.println("Erreur de connexion");

     	        }
     	    }


	    @FXML
	    void ajout(ActionEvent event) {

	    

    	String nom,email,adrs;
    	nom=txtN.getText();
    	adrs=txta.getText();
    	email=txte.getText();
    	try {
			pst=cn.prepareStatement("insert into facturation (nom,adrs,email) values(?,?,?)");
    		pst.setString(1,nom);
    		pst.setString(2,adrs);
    		pst.setString(3,email);
    		pst.executeUpdate();
    		Alert alert=new Alert (Alert.AlertType.INFORMATION);
    		alert.setTitle("Test connection");
    		alert.setHeaderText("client reg");
    		alert.setContentText("ADD");
    		alert.showAndWait();
    		
            table();
            txtN.setText("");
            txta.setText("");
            txte.setText("");
            txtN.requestFocus();

    	} catch (SQLException ex)
    	{
    	     System.out.println("Erreur de connexion");

    	}}
    	 public void table()
         {
             ObservableList<client> client = FXCollections.observableArrayList();
          try 
          {
              pst = cn.prepareStatement("select id,nom,adrs,email from facturation");  
              ResultSet rs = pst.executeQuery();
         {
           while (rs.next())
           {
        	   client c = new client();
               c.setId(rs.getString("id"));
               c.setNom(rs.getString("nom"));
               c.setadrs(rs.getString("adrs"));
               c.setemail(rs.getString("email"));
               
               client.add(c);
          }
       } 
                   table.setItems(client);
                   id.setCellValueFactory(f -> f.getValue().idProperty());
                   idnom.setCellValueFactory(f -> f.getValue().nomProperty());
                   idadrs.setCellValueFactory(f -> f.getValue().adrsProperty());
                   idemail.setCellValueFactory(f -> f.getValue().emailProperty());
                   
         }
         
         catch (SQLException ex)
         {
    	     System.out.println("Erreur de connexion");

         }

                  table.setRowFactory( tv -> {
  		     TableRow<client> myRow = new TableRow<>();
  		     myRow.setOnMouseClicked (event -> 
  		     {
  		        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
  		        {
  		            myIndex =  table.getSelectionModel().getSelectedIndex();
  		 
  		           Id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
  		           txtN.setText(table.getItems().get(myIndex).getNom());
  		           txta.setText(table.getItems().get(myIndex).getadrs());
                   txte.setText(table.getItems().get(myIndex).getemail());
                             
                           
  		       }
  				     });
  				        return myRow;
  		                   });
  		    
  		    
  		      }
      
      


	
	
	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		table();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
