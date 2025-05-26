package com.polytechnique.Observer;

public interface EvenementObservable {
    
    void ajouterObservateur(ParticipantObserver observer);
    void supprimerObservateur(ParticipantObserver observer);
    void notifierObservateurs(String message);
}
