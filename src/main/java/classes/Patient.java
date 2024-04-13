package classes;

import java.util.Date;

public class Patient {
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String sexe;
    private String carteIdentiteNationale;
    private String profession;
    private String mutuelle;
    private String telephone;
    private String adresse;
    private String pathologie;
    private String prescripteur;
    private String prescription;
    private Date dateDePrescription;
    private String indicationMedicale;
    private double resteAPayer;
    private Date prochainRendezVous;
    private String intitules;

    public Patient(String nom, String prenom, Date dateDeNaissance, String sexe, String carteIdentiteNationale, String profession, String mutuelle, String telephone, String adresse, String pathologie, String prescripteur, String prescription, Date dateDePrescription, String indicationMedicale, double resteAPayer, Date prochainRendezVous, String intitules) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.carteIdentiteNationale = carteIdentiteNationale;
        this.profession = profession;
        this.mutuelle = mutuelle;
        this.telephone = telephone;
        this.adresse = adresse;
        this.pathologie = pathologie;
        this.prescripteur = prescripteur;
        this.prescription = prescription;
        this.dateDePrescription = dateDePrescription;
        this.indicationMedicale = indicationMedicale;
        this.resteAPayer = resteAPayer;
        this.prochainRendezVous = prochainRendezVous;
        this.intitules = intitules;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCarteIdentiteNationale() {
        return carteIdentiteNationale;
    }

    public void setCarteIdentiteNationale(String carteIdentiteNationale) {
        this.carteIdentiteNationale = carteIdentiteNationale;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(String mutuelle) {
        this.mutuelle = mutuelle;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPathologie() {
        return pathologie;
    }

    public void setPathologie(String pathologie) {
        this.pathologie = pathologie;
    }

    public String getPrescripteur() {
        return prescripteur;
    }

    public void setPrescripteur(String prescripteur) {
        this.prescripteur = prescripteur;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Date getDateDePrescription() {
        return dateDePrescription;
    }

    public void setDateDePrescription(Date dateDePrescription) {
        this.dateDePrescription = dateDePrescription;
    }

    public String getIndicationMedicale() {
        return indicationMedicale;
    }

    public void setIndicationMedicale(String indicationMedicale) {
        this.indicationMedicale = indicationMedicale;
    }

    public double getResteAPayer() {
        return resteAPayer;
    }

    public void setResteAPayer(double resteAPayer) {
        this.resteAPayer = resteAPayer;
    }

    public Date getProchainRendezVous() {
        return prochainRendezVous;
    }

    public void setProchainRendezVous(Date prochainRendezVous) {
        this.prochainRendezVous = prochainRendezVous;
    }

    public String getIntitules() {
        return intitules;
    }

    public void setIntitules(String intitules) {
        this.intitules = intitules;
    }
}
