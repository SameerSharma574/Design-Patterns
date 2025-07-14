package net.media.training.designpattern.abstractfactory;

public class Iphone implements Phone {
  @Override
  public Case build() {
    MotherBoard motherBoard = new IphoneMotherBoard();
    motherBoard.attachBattery(new Battery());
    motherBoard.attachProcessor(new IphoneProcessor());

    Screen screen = new IphoneScreen();

    Case phoneCase = new IphoneCase();
    phoneCase.attachMotherBoard(motherBoard);
    phoneCase.attachScreen(screen);
    return phoneCase;
  }
}
