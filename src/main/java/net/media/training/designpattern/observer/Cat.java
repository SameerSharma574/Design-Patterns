package net.media.training.designpattern.observer;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 10:13:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cat extends MovableObserver{

    Cat(Sun sun) {
        super(sun);
    }

    public void goOutdoors() {
        subject.registerObserver(this);
        outdoors = true;
    }

    @Override
    public void update(boolean isSunRise) {
        if (isSunRise) {
            notifySunRose();
        } else {
            notifySunSet();
        }
    }

    public void goIndoors() {
        subject.removeObserver(this);
        outdoors = false;
    }

    public void notifySunRose() {
        feelingWarm = true;
    }

    public void notifySunSet() {
        feelingWarm = false;
        if (outdoors)
            feelingTired = true;
    }
}
