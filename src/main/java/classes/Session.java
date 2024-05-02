package classes;

import java.sql.Date;

public class Session {

    private int idPrescription;
    private int idPatient;
    private int idPrescripteur;
    private Date dateDepart;
    private String typeSession;
    private int nbrSeance;
    private String stat;
    private StringBuffer dossierMedical;
    private StringBuffer Notes;

    public int getIdPrescription() {
        return idPrescription;
    }

    public void setIdPrescription(int idPrescription) {
        this.idPrescription = idPrescription;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdPrescripteur() {
        return idPrescripteur;
    }

    public void setIdPrescripteur(int idPrescripteur) {
        this.idPrescripteur = idPrescripteur;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getTypeSession() {
        return typeSession;
    }

    public void setTypeSession(String typeSession) {
        this.typeSession = typeSession;
    }

    public int getNbrSeance() {
        return nbrSeance;
    }

    public void setNbrSeance(int nbrSeance) {
        this.nbrSeance = nbrSeance;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public StringBuffer getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(StringBuffer dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public StringBuffer getNotes() {
        return Notes;
    }

    public void setNotes(StringBuffer notes) {
        Notes = notes;
    }

    public Session(int idPrescription, int idPatient, int idPrescripteur, Date dateDepart, String typeSession, int nbrSeance, String stat, StringBuffer dossierMedical, StringBuffer notes) {
        this.idPrescription = idPrescription;
        this.idPatient = idPatient;
        this.idPrescripteur = idPrescripteur;
        this.dateDepart = dateDepart;
        this.typeSession = typeSession;
        this.nbrSeance = nbrSeance;
        this.stat = stat;
        this.dossierMedical = dossierMedical;
        Notes = notes;
    }
}