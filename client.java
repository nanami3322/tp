package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class client {
	private final StringProperty id;
    private final StringProperty nom;
    private final StringProperty adrs;
    private final StringProperty  email;
    
    public client()
    {
        id = new SimpleStringProperty(this, "id");
        nom = new SimpleStringProperty(this, "nom");
        adrs = new SimpleStringProperty(this, "adrs");
        email = new SimpleStringProperty(this, "email");
    }
 
    public StringProperty idProperty() { return id; }
    public String getId() { return id.get(); }
    public void setId(String newId) { id.set(newId); }
 
    public StringProperty nomProperty() { return nom; }
    public String getNom() { return nom.get(); }
    public void setNom(String newNom) { nom.set(newNom); }
 
    public StringProperty adrsProperty() { return adrs; }
    public String getadrs() { return adrs.get(); }
    public void setadrs(String newadrs) { adrs.set(newadrs); }
    
    public StringProperty emailProperty() { return email; }
    public String getemail() { return email.get(); }
    public void setemail(String newemail) { email.set(newemail); }
}

