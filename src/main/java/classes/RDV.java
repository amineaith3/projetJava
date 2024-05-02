package classes;

import java.sql.Timestamp;

public class RDV {
    private String etat;
    private int idSession;
    private String note;
    private String motif;
    private Timestamp dateRdv;


    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int session) {
        this.idSession = session;
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

    public Timestamp getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(Timestamp dateRdv) {
        this.dateRdv = dateRdv;
    }

    public Timestamp getDureeRdv() {
        return dureeRdv;
    }

    public void setDureeRdv(Timestamp dureeRdv) {
        this.dureeRdv = dureeRdv;
    }

    private Timestamp dureeRdv;

    public RDV(int session, String etat, String note,String motif,Timestamp dateRdv) {
        this.etat = etat;
        this.note = note;
        this.dateRdv = dateRdv;
        this.motif = motif;
        this.idSession = session;
    }

}
