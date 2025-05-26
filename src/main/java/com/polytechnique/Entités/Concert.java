package com.polytechnique.Entités;

import java.time.LocalDateTime;

public class Concert extends Evenement {
    //Attributs
    private String artiste;
    private String genreMusical;

    //Constructeurs
    public Concert() {}

    public Concert(String id, String nom, LocalDateTime date, String lieu, int capaciteMax, String artiste, String genreMusical) {
        super(id, nom, date, lieu, capaciteMax);
        this.artiste = artiste;
        this.genreMusical = genreMusical;
    }

    public Concert(String artiste, String genreMusical) {
        this.artiste = artiste;
        this.genreMusical = genreMusical;
    }

    //Méthodes

    //Méthode pour récupérer l'artiste qui va prester à un concert
    public String getArtiste() {
        return this.artiste;
    }

    //Méthode pour récupérer le genre musical d'un concert
    public String getGenreMusical() {
        return this.genreMusical;
    }

    //Méthode pour afficher les détails d'un concert
    @Override
    public void afficherDetails() {
        System.out.println("Concert : " + nom);
        System.out.println(" - Artiste : " + artiste);
        System.out.println("Genre : " + genreMusical);
        System.out.println("Lieu : " + lieu);
        System.out.println("Date : " + date);
    }
}
