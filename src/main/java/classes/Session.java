package classes;

import java.util.Date;

public class Session {
    private Date dateDepart;
    private StringBuffer prescription;
    private String typeSession;
    private int nombreSeance;
    private boolean etat;
    private StringBuffer dossierMedical;
    private StringBuffer notes;

    public Session(Date dateDepart, StringBuffer prescription, int nombreSeance, String typeSession, boolean etat, StringBuffer dossierMedical, StringBuffer notes) {
        this.dateDepart = dateDepart;
        this.prescription = prescription;
        this.typeSession = typeSession;
        this.nombreSeance = nombreSeance;
        this.etat = etat;
        this.dossierMedical = dossierMedical;
        this.notes = notes;
    }

    public int getNombreSeance() {
        return nombreSeance;
    }

    public void setNombreSeance(int nombreSeance) {
        this.nombreSeance = nombreSeance;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public StringBuffer getPrescription() {
        return prescription;
    }

    public void setPrescription(StringBuffer prescription) {
        this.prescription = prescription;
    }

    public String getTypeSession() {
        return typeSession;
    }

    public void setTypeSession(String typeSession) {
        this.typeSession = typeSession;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public StringBuffer getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(StringBuffer dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public StringBuffer getNotes() {
        return notes;
    }

    public void setNotes(StringBuffer notes) {
        this.notes = notes;
    }
}