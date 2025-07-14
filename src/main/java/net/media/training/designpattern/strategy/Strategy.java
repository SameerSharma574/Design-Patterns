package net.media.training.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class Strategy<T> implements StrategyItem<T>{
  List<StrategyItem<T>> stratItemList;

  Strategy() {
    stratItemList = new ArrayList<>();
  }

  @Override
  public void check(T val) {
    for(StrategyItem i : stratItemList){
      i.check(val);
    }
  }

  public void addStrategyItem (StrategyItem strategyItem) {
    stratItemList.add(strategyItem);
  }

  public void empty () {
    stratItemList.clear();
  }
}
