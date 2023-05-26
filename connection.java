
package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;

public class connection extends Application  {

	     private static Connection cn;
	     static {
	     try {
	     //Étape 1 : Charger le driver de la base de données cible

	     Class.forName("com.mysql.cj.jdbc.Driver");
	     //Étape 2 : Authentification auprès de la base de données et sélectionner le
	     //schéma

	     cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facturation","root","");
	      }
	     catch (ClassNotFoundException ex) {
	     System.out.println("Impossible de charger le driver");
	      }
	     catch (SQLException ex) {
	     System.out.println("Erreur de connexion");
	      }
	      }
	     public static Connection getCn() {
	     return cn;
	      }
		@Override
		public void start(Stage arg0) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
}