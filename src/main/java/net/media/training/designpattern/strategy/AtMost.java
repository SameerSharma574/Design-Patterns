package net.media.training.designpattern.strategy;

public class AtMost implements StrategyItem<Integer> {

  Integer max;

  AtMost(Integer max) {
    this.max = max;
  }
  @Override
  public void check(Integer val) {
    if (val > max)
      throw new RuntimeException("at least check failed:" + val);
  }
}
