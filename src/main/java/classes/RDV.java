package classes;

import java.util.Date;

public class RDV {
    private Patient patient;
    private String etat;
    private Session session;
    private String note;
    private String motif;
    private Date dateRdv;

    public Patient getPatient() {
        return patient;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setClient(Patient patient) {
        this.patient = patient;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public Date getDureeRdv() {
        return dureeRdv;
    }

    public void setDureeRdv(Date dureeRdv) {
        this.dureeRdv = dureeRdv;
    }

    private Date dureeRdv;

    public RDV(Patient patient, String etat, String note, Session session, String motif,Date dateRdv, Date dureeRdv) {
        this.patient = patient;
        this.etat = etat;
        this.note = note;
        this.dateRdv = dateRdv;
        this.dureeRdv = dureeRdv;
        this.motif = motif;
        this.session = session;
    }

}
