package com.polytechnique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.polytechnique.Entités.Concert;
import com.polytechnique.Entités.Conference;
import com.polytechnique.Entités.Evenement;
import com.polytechnique.Entités.Intervenant;
import com.polytechnique.Entités.NotificationService;
import com.polytechnique.Exceptions.TestException;
import com.polytechnique.Services.NotificationService1;
import com.polytechnique.*;
import com.polytechnique.utils.*;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    

    public static void main(String[] args) throws IOException {
        //launch();

        // Conference conf = new Conference("C1", "Conférence IA", LocalDateTime.now().plusDays(10), "Paris", 100, "IA", null);

        // Intervenant p1 = new Intervenant("P1", "Lili", "lili@mail.com", "Informatique");
        // Intervenant p2 = new Intervenant("P2", "Alex", "alex@mail.com", "Robotique");

        // conf.ajouterObservateur(p1);
        // conf.ajouterObservateur(p2);

        // conf.modifier("Lyon", LocalDateTime.now().plusDays(12));
        // conf.annuler(); 

        
        //Pour tester les exceptions

        // TestException.testerCapaciteMax();
        // TestException.testerEvenementDejaExistant();


        //Pour tester la sérialisation JSON

        // List<Evenement> evenements = new ArrayList<>();
        // evenements.add(new Concert("E1", "Concert Rock", LocalDateTime.now(), "Paris", 100, "Queen", "Rock"));
        // evenements.add(new Conference("C1", "Conf Java", LocalDateTime.now(), "Dakar", 50, "Java", new ArrayList<>()));

        // String chemin = "evenements.json";

        // JsonUtils.sauvegarderEvenements(evenements, chemin);
        // System.out.println(" Sauvegarde terminée.");

        // List<Evenement> charges = JsonUtils.chargerEvenements(chemin);
        // System.out.println(" Chargement terminé. Événements chargés :");
        // for (Evenement e : charges) {
        //    System.out.println("- " + e.getNom() + " (" + e.getClass().getSimpleName() + ")");
        // }


        //Pour tester l'envoi de notifications en différé avec CompletableFuture

        // NotificationService1 notificationService1 = new NotificationService1();
        // notificationService1.envoyerNotificationAsync("Le concert commence bientôt !", 3);

        // System.out.println("Application continue pendant l'attente de la notification...");

    }

}