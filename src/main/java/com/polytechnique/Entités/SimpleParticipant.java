package com.polytechnique.Entités;

public class SimpleParticipant extends Participant {
    //Cette classe est juste créée pour être une sous-classe utilitaire, pour les tests

    //Constructeurs
    public SimpleParticipant(String id, String nom, String email) {
        super(id, nom, email);
    }

    //Méthode pour recevoir une notification
    @Override
    public void recevoirNotification(String message) {
        System.out.println(" Notification reçue par " + getNom() + " (" + getEmail() + ") : " + message);
    }
}
