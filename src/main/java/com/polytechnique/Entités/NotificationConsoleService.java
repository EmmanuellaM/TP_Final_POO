package com.polytechnique.Entités;

public class NotificationConsoleService implements NotificationService {
    //L'intérêt de cette classe est d'implémenter "NotificationService" en appelant la méthode "RecevoirNotification" qui est dans "Participant"
    @Override
    public void envoyerNotification(String message, Participant destinataire) {
        destinataire.recevoirNotification(message);
    }
}
