package net.media.training.designpattern.strategy;

import java.util.List;

public class Strategy<T> implements StrategyItem<T>{
  List<StrategyItem<T>> stratItemList;

  @Override
  public void check(T val) {
    boolean answer;
    for(StrategyItem i : stratItemList){
      answer = answer || i.check();
    }
    return answer;
  }
}
