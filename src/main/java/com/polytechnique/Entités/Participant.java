package com.polytechnique.Entités;

import com.polytechnique.Observer.ParticipantObserver;

public abstract class Participant implements ParticipantObserver {
    //Attributs
    protected String id;
    protected String nom;
    protected String email;

    //Constructeurs
    public Participant() {}

    public Participant(String id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    //Méthodes

    //Méthode qui retourne le nom
    public String getNom() {
        return nom;
    }

    //Méthode qui retourne l'Id
    public String getId() {
        return id;
    }

    //Méthode qui retourne l'email
    public String getEmail() {
        return email;
    }

    //Méthode pour recevoir une notification
    public abstract void recevoirNotification(String message);

    //Implémentation de la méthode update de ParticipantObservable
    @Override
    public void update(String message) {
        System.out.println("[" + nom + "] Notification : " + message);
    }
}
