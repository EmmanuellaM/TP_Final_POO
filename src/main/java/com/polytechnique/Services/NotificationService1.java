package com.polytechnique.Services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class NotificationService1 {

    //Méthode pour envoyer des notifications
    public void envoyerNotificationAsync(String message, int delaiSecondes) {
        CompletableFuture.runAsync(
            () -> System.out.println("Notification : " + message),
            CompletableFuture.delayedExecutor(delaiSecondes, TimeUnit.SECONDS)
        );
    }
}
