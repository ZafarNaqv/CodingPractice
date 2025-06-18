package designpatterns.factory;

public class Email extends Notification{
    @Override
    public void send() {
        System.out.println("Sending out emails");
    }
}