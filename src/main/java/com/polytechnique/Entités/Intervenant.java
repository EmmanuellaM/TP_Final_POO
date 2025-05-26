package com.polytechnique.Entités;

public class Intervenant extends Participant {
    //Attributs 
    private String domaineIntervention;

    //Constructeurs
    public Intervenant() {}

    public Intervenant(String domaineIntervention) {
        this.domaineIntervention = domaineIntervention;
    }

    public Intervenant(String id, String nom, String email, String domaineIntervention) {
        super(id, nom, email);
        this.domaineIntervention = domaineIntervention;
    }

    //Getters
    public String getDomaineIntervention() {
        return domaineIntervention;
    }

    //Méthodes

    //Méthode pour recevoir une notification
    @Override
    public void recevoirNotification(String message) {
        System.out.println("Intervenant " + nom + " a reçu : " + message);
    }

}
