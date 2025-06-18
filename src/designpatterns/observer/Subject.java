package designpatterns.observer;

import java.util.List;

public interface Subject {
    void registerObserver(Observer observer);
    void registerObserver(List<Observer> observerlist);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}