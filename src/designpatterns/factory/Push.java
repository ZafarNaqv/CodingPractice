package designpatterns.factory;

public class Push extends Notification{
    @Override
    public void send() {
        System.out.println("Sending out Push Notifications");
    }
}