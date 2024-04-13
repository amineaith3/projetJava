package classes;

import java.util.Date;

public class Patient {
    private String cin;
    private String prenom;
    private String nom;
    private StringBuffer tel;
    private boolean sexe;
    private Date dateNaissance;
    private StringBuffer address;
    private StringBuffer note;
    private StringBuffer mutuelle;

    public Patient(String cin, String prenom, String nom, StringBuffer tel, boolean sexe, Date dateNaissance, StringBuffer address, StringBuffer note, StringBuffer mutuelle) {
        this.cin = cin;
        this.prenom = prenom;
        this.nom = nom;
        this.tel = tel;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.address = address;
        this.note = note;
        this.mutuelle = mutuelle;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public StringBuffer getTel() {
        return tel;
    }

    public void setTel(StringBuffer tel) {
        this.tel = tel;
    }

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public StringBuffer getAddress() {
        return address;
    }

    public void setAddress(StringBuffer address) {
        this.address = address;
    }

    public StringBuffer getNote() {
        return note;
    }

    public void setNote(StringBuffer note) {
        this.note = note;
    }

    public StringBuffer getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(StringBuffer mutuelle) {
        this.mutuelle = mutuelle;
    }
}
