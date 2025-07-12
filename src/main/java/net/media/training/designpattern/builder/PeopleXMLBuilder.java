package net.media.training.designpattern.builder;

public class PeopleXMLBuilder {
  StringBuilder builder;

  PeopleXMLBuilder() {
    builder = new StringBuilder();
    builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
  }

  public PeopleXMLBuilder add(String inputString) {
    builder.append(inputString);
    return this;
  }

  public PeopleXMLBuilder add(int c) {
    builder.append(c);
    return this;
  }

  public PeopleXMLBuilder add(Person person) {
    builder.append("<Person id=\"")
        .append(person.getId())
        .append("\" name=\"")
        .append(person.getName())
        .append("\">");

    builder.append("<Address><City>")
        .append(person.getCity())
        .append("</City><Country>")
        .append(person.getCountry())
        .append("</Country></Address>");

    builder.append("</Person>");
    return this;
  }

  public String build() {
    return builder.toString();
  }
}
