package classes;

import java.util.Date;

public class Prescripteur
{
    private String codeDoc;
    private String nom;
    private String prenom;
    private String adress;
    private String email;
    private String notes;

    public String getAdress() {
        return adress;
    }

    public String getCodeDoc() {
        return codeDoc;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getNotes() {
        return notes;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCodeDoc(String codeDoc) {
        this.codeDoc = codeDoc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Prescripteur(String codeDoc,String nom,String prenom,String adress,String email,String notes)
    {
        this.adress
    }
}
