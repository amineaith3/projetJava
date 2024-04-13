package classes;

import java.util.Date;

public class Bilan
{
    public int getIdBilan() {
        return idBilan;
    }

    public void setIdBilan(int idBilan) {
        this.idBilan = idBilan;
    }

    public String getFichierPath() {
        return fichierPath;
    }

    public void setFichierPath(String fichierPath) {
        this.fichierPath = fichierPath;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Bilan(int idBilan, String fichierPath, String notes) {
        this.idBilan = idBilan;
        this.fichierPath = fichierPath;
        this.notes = notes;
    }

    private int idBilan;
    private String fichierPath;
    private String notes;
}