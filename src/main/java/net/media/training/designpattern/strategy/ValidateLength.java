package net.media.training.designpattern.strategy;

public class ValidateLength implements StrategyItem<String> {

  int allowedLength;

  ValidateLength(int allowedLength) {
    this.allowedLength = allowedLength;
  }

  @Override
  public void check(String val) {
    if (val.length() > allowedLength)
      throw new RuntimeException("Invalid length:" + allowedLength);
  }
}
