package net.media.training.designpattern.observer;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 10:16:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Robot extends MovableObserver{

    Robot(Sun sun) {
        super(sun);
    }

    public void notifySunRose() {
        feelingWarm = true;
    }

    public void notifySunSet() {
        feelingWarm = false;
        if (outdoors)
            feelingTired = true;
    }

    public void goOutdoors() {
        subject.registerObserver(this);
        outdoors = true;
    }

    public void goIndoors() {
        subject.removeObserver(this);
        outdoors = false;
    }

    @Override
    public void update(boolean isSunRise) {
        if (isSunRise) {
            notifySunRose();
        } else {
            notifySunSet();
        }
    }
}
