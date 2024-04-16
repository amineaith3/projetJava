package classes;

import java.util.Date;

public class Fiche
{

    private String fichierPath;
    private String notes;
    public Fiche( String fichierPath, String notes) {
        this.fichierPath = fichierPath;
        this.notes = notes;
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


}