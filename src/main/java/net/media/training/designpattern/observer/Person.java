package net.media.training.designpattern.observer;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 9:35:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person extends MovableObserver{

    Person(Sun sun) {
        super(sun);
    }
    public void goOutdoors() {
        subject.registerObserver(this);
        outdoors = true;
    }

    public void goIndoors() {
        subject.removeObserver(this);
        outdoors = false;
    }

    public void notifySunRose() {
        if (outdoors)
            feelingWarm = true;
    }

    public void notifySunSet() {
        feelingWarm = false;
        if (outdoors)
            feelingTired = true;
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
