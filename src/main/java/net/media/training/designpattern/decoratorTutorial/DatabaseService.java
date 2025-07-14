package net.media.training.designpattern.decoratorTutorial;

public class DatabaseService {

    public String getMailFromUsername(String username) {
        return username + "@Mail";
    }

    public String getSlackHandleUsername(String username) {
        return username + "@Phone";
    }

    public String getFBNameFromUsername(String username) {
        return username + "@Facebook";
    }

}

