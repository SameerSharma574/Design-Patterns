package net.media.training.designpattern.strategy;

public class AtLeast implements StrategyItem<Integer> {

  Integer min;

  AtLeast(Integer min) {
    this.min = min;
  }

  @Override
  public void check(Integer val) {
    if (val < min)
      throw new RuntimeException("at least check failed:" + val);
  }
}
