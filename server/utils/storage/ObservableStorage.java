package server.utils.storage;

import java.util.Observer;

public interface ObservableStorage{
  
  void addObserver(Observer observer);

  void notifyObservers();
}