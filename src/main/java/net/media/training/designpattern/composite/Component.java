package net.media.training.designpattern.composite;

public interface Component {
  void setParent(Directory parent);
  String getName();
  int getSize();
  Directory getParent();
  boolean fileExists(String name);
  boolean directoryExists(String name);
  void delete();
}
