package classes;

import java.util.Date;

public class Prescripteur
{
    private String nom;
    private String prenom;
    private StringBuffer adress;
    private StringBuffer email;
    private StringBuffer notes;

    public StringBuffer getAdress() {
        return adress;
    }


    public StringBuffer getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public StringBuffer getNotes() {
        return notes;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setAdress(StringBuffer adress) {
        this.adress = adress;
    }



    public void setEmail(StringBuffer email) {
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNotes(StringBuffer notes) {
        this.notes = notes;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Prescripteur(String nom,String prenom,StringBuffer adress,StringBuffer email,StringBuffer notes)
    {
        this.prenom = prenom;
        this.nom = nom;
        this.email =email;
        this.notes = notes;
        this.adress=adress;

    }
}
