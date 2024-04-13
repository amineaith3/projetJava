package classes;

import java.util.Date;

public class Session {
    private Date dateDepart;
    private String prescription;
    private String typeSession;
    private boolean etat;
    private String dossierMedical;
    private String notes;

    public Session(Date dateDepart, String prescription, String typeSession, boolean etat, String dossierMedical, String notes) {
        this.dateDepart = dateDepart;
        this.prescription = prescription;
        this.typeSession = typeSession;
        this.etat = etat;
        this.dossierMedical = dossierMedical;
        this.notes = notes;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
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

    public String getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(String dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}