package com.polytechnique.Entités;

public interface NotificationService {
    //Attributs
    public static final String message = "";

    //Méthode pour envoyer un message à un participant
    void envoyerNotification(String message, Participant destinataire);
}
