package com.polytechnique.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.polytechnique.Entités.Evenement;

public class JsonUtils {
    //Cette classe est créé du fait de la nécessité de garder une liste d'évènements dans un fichier

    // Objet Jackson configuré pour indenter joliment les fichiers JSON
    private static final ObjectMapper mapper = new ObjectMapper()
        .registerModule(new JavaTimeModule()) // pour gérer LocalDateTime
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // pour désactiver les timestamps

    /**
     * Sauvegarde une liste d'événements dans un fichier JSON.
     *
     * @param evenements    La liste d'événements à sauvegarder
     * @param cheminFichier Le chemin du fichier JSON de sortie
     * @throws IOException Si une erreur d'écriture survient
     */
    public static void sauvegarderEvenements(List<Evenement> evenements, String cheminFichier) throws IOException {
        mapper.writeValue(new File(cheminFichier), evenements);
    }

    /**
     * Charge une liste d'événements depuis un fichier JSON.
     *
     * @param cheminFichier Le chemin du fichier JSON à lire
     * @return La liste des événements désérialisés
     * @throws IOException Si une erreur de lecture survient
     */
    public static List<Evenement> chargerEvenements(String cheminFichier) throws IOException {
        return mapper.readValue(
                new File(cheminFichier),
                mapper.getTypeFactory().constructCollectionType(List.class, Evenement.class)
        );
    }
}
