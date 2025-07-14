package net.media.training.designpattern.observer;

public interface Subject {
  void registerObserver(Observer observer);
  void notifyObservers(boolean isSunRise);
  void removeObserver(Observer observer);
}
