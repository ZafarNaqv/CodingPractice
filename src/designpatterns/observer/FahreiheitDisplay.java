package designpatterns.observer;

public class FahreiheitDisplay implements Observer {
    @Override
    public void displayTemperature(double celsius) {
        double fahreiheit = celsius * 1.8 + 32;
        System.out.printf("Display temperature in fahreiheit: %.02f\n" ,  fahreiheit);
    }
}