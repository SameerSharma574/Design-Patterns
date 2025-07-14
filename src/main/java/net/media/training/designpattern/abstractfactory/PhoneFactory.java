package net.media.training.designpattern.abstractfactory;

public class PhoneFactory {
  public static Phone getPhone(String type) {
    if ("Android".equalsIgnoreCase(type)) {
      return new AndroidPhone();
    } else if("Iphone".equalsIgnoreCase(type)) {
      return new Iphone();
    } else {
      throw new IllegalArgumentException("Unsupported phone type: " + type);
    }
  }
}
