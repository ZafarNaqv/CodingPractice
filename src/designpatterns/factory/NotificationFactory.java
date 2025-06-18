package designpatterns.factory;

import java.util.Optional;

import static designpatterns.factory.NotificationType.PUSH;
import static designpatterns.factory.NotificationType.SMS;

public class NotificationFactory {
    /*public static Optional<Notification> getNotification(String type) {
        if(type.equalsIgnoreCase("Email")) {
            return Optional.of(new Email());
        }else if(type.equalsIgnoreCase("SMS")) {
            return Optional.of(new SMS());
        }else if(type.equalsIgnoreCase("Push")) {
            return Optional.of(new Push());
        }
        return Optional.empty();
    }*/
    
    public static Optional<Notification> getNotification(NotificationType type) {
        return switch (type) {
            case EMAIL -> Optional.of(new Email());
            case SMS -> Optional.of(new SMS());
            case PUSH -> Optional.of(new Push());
        };
    }
    
    
    public static void main(String[] args) {
        Optional<Notification> someNotification = NotificationFactory.getNotification(SMS);
        Optional<Notification> anotherNotification = NotificationFactory.getNotification(PUSH);
        someNotification.ifPresent(Notification::send);
        anotherNotification.ifPresent(Notification::send);
        
    }
}