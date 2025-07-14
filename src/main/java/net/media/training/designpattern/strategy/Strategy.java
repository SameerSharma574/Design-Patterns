package net.media.training.designpattern.strategy;

import java.util.List;

public class Strategy<T> implements StrategyItem<T>{
  List<StrategyItem<T>> stratItemList;

  @Override
  public void check(T val) {
    for(StrategyItem i : stratItemList){
      i.check(val);
    }
  }
}
