package net.media.training.designpattern.observer;

public abstract class MovableObserver implements Observer{
  protected boolean outdoors;
  protected boolean feelingWarm;
  protected boolean feelingTired;
  protected Subject subject;

  MovableObserver(Subject subject) {
    this.subject = subject;
  }

  public abstract void goIndoors();
  public abstract void goOutdoors();
  public abstract void update(boolean isSunRise);

  public boolean isOutdoors() {
    return outdoors;
  }

  public boolean isFeelingWarm() {
    return feelingWarm;
  }

  public boolean isFeelingTired() {
    return feelingTired;
  }

  public void setOutdoors(boolean outdoors) {
    this.outdoors = outdoors;
  }

  public void setFeelingWarm(boolean feelingWarm) {
    this.feelingWarm = feelingWarm;
  }

  public void setFeelingTired(boolean feelingTired) {
    this.feelingTired = feelingTired;
  }
}
