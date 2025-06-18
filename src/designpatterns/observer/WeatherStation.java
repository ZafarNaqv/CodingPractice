package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Subject{
    private final List<Observer> observerslist = new ArrayList<>();
    double temperature;
    double humidity;
    public WeatherStation() {
        Random random = new Random();
        humidity = random.nextDouble(-8.0,44.5);
        int scalingFactor = random.nextInt(1,5);
        temperature = humidity/scalingFactor;
        
    }
    
    public void setTemperature(double newTemp) {
        this.temperature = newTemp;
        notifyObservers();
    }
    @Override
    public void registerObserver(Observer observer) {
        observerslist.add(observer);
    }
    
    @Override
    public void registerObserver(List<Observer> mlist) {
        observerslist.addAll(mlist);
    }
    
    @Override
    public void deregisterObserver(Observer observer) {
        observerslist.remove(observer);
    }
    
    @Override
    public void notifyObservers() {
        observerslist.forEach((observer) -> {
            observer.displayTemperature(temperature);
        });
    }
    
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Observer fahrenheitObserver = new FahreiheitDisplay();
        Observer celciusObserver = new CelciusDisplay();
        List<Observer> observerslist = List.of(fahrenheitObserver,celciusObserver);
        weatherStation.registerObserver(observerslist);
        weatherStation.notifyObservers();
        weatherStation.setTemperature(35.0);
    }
}