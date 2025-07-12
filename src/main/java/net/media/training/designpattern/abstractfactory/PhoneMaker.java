package net.media.training.designpattern.abstractfactory;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 6:34:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneMaker {

    public Case buildPhone(String phoneType) {
        MotherBoard motherBoard;
        if (phoneType.equals("Android")) {
            motherBoard = new AndroidMotherBoard();
            motherBoard.attachBattery(new Battery());
            motherBoard.attachProcessor(new AndroidProcessor());
        } else {
            motherBoard = new IphoneMotherBoard();
            motherBoard.attachBattery(new Battery());
            motherBoard.attachProcessor(new IphoneProcessor());
        }

        Screen screen;
        if (phoneType.equals("Android")) {
            screen = new AndroidScreen();
        } else {
            screen = new IphoneScreen();
        }

        Case phoneCase;
        if (phoneType.equals("Android")) {
            phoneCase = new AndroidCase();
        } else {
            phoneCase = new IphoneCase();
        }
        phoneCase.attachMotherBoard(motherBoard);
        phoneCase.attachScreen(screen);
        return phoneCase;
    }
}
