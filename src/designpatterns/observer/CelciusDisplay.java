package designpatterns.observer;

public class CelciusDisplay implements Observer {
    @Override
    public void displayTemperature(double celsius) {
        System.out.printf("Celcius: %.02f \n", celsius);
    }
}