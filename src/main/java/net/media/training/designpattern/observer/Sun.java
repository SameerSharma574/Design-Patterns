package net.media.training.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 9:12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sun implements Subject{
    private boolean isUp;
    private List<Observer> observers;

    public Sun() {
        this.isUp = false;
        this.observers = new ArrayList<>();
    }

    public boolean isUp() {
        return isUp;
    }

    public void set() {
        isUp = false;
        notifyObservers(false);
    }

    public void rise() {
        isUp = true;
        notifyObservers(true);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(boolean isSunRise) {
        observers.forEach(observer -> observer.update(isSunRise));
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}