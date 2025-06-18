package designpatterns.factory;

public class SMS extends Notification{
    @Override
    public void send() {
        System.out.println("Sending notification via SMS");
    }
}