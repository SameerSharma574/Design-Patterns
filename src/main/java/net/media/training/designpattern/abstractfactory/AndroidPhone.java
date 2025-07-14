package net.media.training.designpattern.abstractfactory;

public class AndroidPhone implements Phone {
  @Override
  public Case build() {
    MotherBoard motherBoard;
    motherBoard = new AndroidMotherBoard();
    motherBoard.attachBattery(new Battery());
    motherBoard.attachProcessor(new AndroidProcessor());

    Screen screen = new AndroidScreen();

    Case phoneCase = new AndroidCase();
    phoneCase.attachMotherBoard(motherBoard);
    phoneCase.attachScreen(screen);
    return phoneCase;
  }
}
