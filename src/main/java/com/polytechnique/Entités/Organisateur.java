package com.polytechnique.Entités;

import java.util.List;

public class Organisateur extends Participant {
    //Attributs
    private List<Evenement> evenementsOrganises;

    //Constructeurs
    public Organisateur() {}

    public Organisateur(String id, String nom, String email, List<Evenement> evenementsOrganises) {
        super();
        this.evenementsOrganises = evenementsOrganises;
    }

    public Organisateur(List<Evenement> evenementsOrganises) {
        this.evenementsOrganises = evenementsOrganises;
    }

    //Méthodes

    //Méthode pour ajouter un évènement
    public void ajouterEvenement(Evenement evenement) {
        evenementsOrganises.add(evenement);
    }

    //Liste pour que chaque organisateur sache ce qu'il gère
    public List<Evenement> getEvenementsOrganises() {
        return evenementsOrganises;
    }

    //Méthode pour recevoir une notification
    @Override
    public void recevoirNotification(String message) {
        System.out.println("Organisateur " + nom + " a reçu : " + message);
    }
}
