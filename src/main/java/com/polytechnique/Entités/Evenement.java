package com.polytechnique.Entités;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.polytechnique.Exceptions.CapaciteMaxAtteinteException;
import com.polytechnique.Observer.EvenementObservable;
import com.polytechnique.Observer.ParticipantObserver;

//Annotations pour gérer correctement le polymorphisme Json
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,        // on utilise le nom de la classe comme identifiant
    include = JsonTypeInfo.As.PROPERTY, // injecté comme propriété JSON
    property = "type"                  // nom de la propriété dans le JSON
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Concert.class, name = "concert"),
    @JsonSubTypes.Type(value = Conference.class, name = "conference")
    // Ajoute d'autres sous-types ici si nécessaire
})

public abstract class Evenement implements EvenementObservable {
    //Attrubuts
    protected String id;
    protected String nom;
    protected LocalDateTime date;
    protected String lieu;
    protected int capaciteMax;

    protected List<ParticipantObserver> observateurs = new ArrayList<>();
    protected List<ParticipantObserver> participants = new ArrayList<>();

    //Constructeurs
    public Evenement(String id, String nom, LocalDateTime date, String lieu, int capaciteMax) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
    }

    public Evenement() {}

    //Methodes

    //Méthode pour ajouter un observateur
    @Override
    public void ajouterObservateur(ParticipantObserver observer) {
        observateurs.add(observer);
    }

    //Méthode pour supprimer un observateur
    @Override
    public void supprimerObservateur(ParticipantObserver observer) {
        observateurs.remove(observer);
    }

    //Méthode pour notifier un observateur
    @Override
    public void notifierObservateurs(String message) {
        for (ParticipantObserver observer : observateurs) {
            observer.update(message);
        }
    }

    //Méthode pour annuler un évènement
    public void annuler() {
        notifierObservateurs("L'événement '" + nom + "' est annulé !");
    }

    //Méthode pour modifier un évènement
    public void modifier(String nouveauLieu, LocalDateTime nouvelleDate) {
        this.lieu = nouveauLieu;
        this.date = nouvelleDate;
        notifierObservateurs("L'événement '" + nom + "' a été modifié.");
    }

    //Méthode pour ajouter un participant en utilisant "CapaciteMaxAtteinteException"
    public void ajouterParticipant(ParticipantObserver participant) throws CapaciteMaxAtteinteException {
        if (participants.size() >= capaciteMax) {
            throw new CapaciteMaxAtteinteException("La capacité maximale de l'événement est atteinte.");
        }
        participants.add(participant);
    ajouterObservateur(participant);
    }

    //Méthode pour récupérer l'id d'un évènement 
    public String getId() {
        return this.id;
    }

    //Méthode pour récupérer le nom d'un évènement
    public String getNom() {
        return this.nom;
    }

    //Méthode pour récupérer la date d'un évènement
    public LocalDateTime getDate() {
        return this.date;
    }

    //Méthode pour récupérer le lieu d'un évènement
    public String getLieu() {
        return this.lieu;
    }

    //Méthode pour récupérer la capacité maximale d'un évènement
    public int getCapaciteMax() {
        return this.capaciteMax;
    }

    //Méthode abstraite pour ajouter les détails d'un évènement
    public abstract void afficherDetails();

}
