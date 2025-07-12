package net.media.training.designpattern.strategy;

public class NotEmpty implements StrategyItem<String> {
  @Override
  public void check(String val) {
    if (val == null || val.isEmpty())
      throw new RuntimeException("not empty check failed for value:" + val);
  }
}
