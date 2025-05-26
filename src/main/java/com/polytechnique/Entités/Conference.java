package com.polytechnique.Entités;

import java.time.LocalDateTime;
import java.util.List;

public class Conference extends Evenement {
    //Attributs
    private String theme;
    private List<Intervenant> intervenants;

    //Constructeurs
    public Conference() {}

    public Conference(String id, String nom, LocalDateTime date, String lieu, int capaciteMax, String theme, List<Intervenant> intervenants) {
        super(id, nom, date, lieu, capaciteMax);
        this.theme = theme;
        this.intervenants = intervenants;
    }

    public Conference(String theme, List<Intervenant> intervenants) {
        this.theme = theme;
        this.intervenants = intervenants;
    }

    //Méthodes

    //Méthode pour récupérer le thèm d'une conférence
    public String getTheme() {
        return this.theme;
    }

    //Méthode pour récupérer la liste des intervenants
    public List<Intervenant> getIntervenants() {
        return this.intervenants;
    }

    //Méthode pour afficher les détails de la conférence
    @Override
    public void afficherDetails() {
        System.out.println("Conférence : " + nom);
        System.out.println("Thème : " + theme);
        System.out.println("Lieu : " + lieu);
        System.out.println("Date : " + date);
        System.out.println("Nombre d'intervenants : " + intervenants.size());
        for (Intervenant i : intervenants) {
            System.out.println("- " + i.nom + " (" + i.getDomaineIntervention() + ")");
        }
    }
}
