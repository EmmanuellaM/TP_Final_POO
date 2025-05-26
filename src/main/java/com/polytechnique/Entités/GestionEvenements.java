package com.polytechnique.Entités;

import java.util.HashMap;
import java.util.Map;

import com.polytechnique.Exceptions.EvenementDejaExistantException;

public class GestionEvenements {
    //Attributs
    private static GestionEvenements instance = null;
    private Map<String, Evenement> evenements;

    //Constructeurs 
    private GestionEvenements() {
        evenements = new HashMap<>();
    }  
    
    //Méthodes

    //Méthode statique publique qui fournit l’accès à l’unique instance : Si elle n’existe pas encore, on la crée; sinon, on la retourne directement. C’est le cœur du pattern Singleton
    public static GestionEvenements getInstance() {
        if (instance == null) {
            instance = new GestionEvenements();
        }
        return instance;
    }

    //Méthode pour ajouter un évènement à la map en utilisant son id et en utilisant la classe "EvenementDejaExistantException"
    public void ajouterEvenement(Evenement evenement) throws EvenementDejaExistantException {
        if (evenements.containsKey(evenement.getId())) {
            throw new EvenementDejaExistantException("Un événement avec cet ID existe déjà.");
        }
        evenements.put(evenement.id, evenement);
        System.out.println("Événement '" + evenement.nom + "' ajouté.");
    }

    //Méthode pour supprimer un évènement de la map en utilisant son id
    public void supprimerEvenement(String id) {
        Evenement e = evenements.remove(id);
        if (e != null) {
            System.out.println("Événement '" + e.nom + "' supprimé.");
        } else {
            System.out.println("Aucun événement trouvé avec l'ID : " + id);
        }
    }

    //Méthode pour rechercher un évènement dans la map en utilisant son id
    public Evenement rechercherEvenement(String id) {
        return evenements.get(id);
    }

    //Méthode pour retourner toute la map des évènements
    public Map<String, Evenement> getTousLesEvenements() {
        return evenements;
    }
}
