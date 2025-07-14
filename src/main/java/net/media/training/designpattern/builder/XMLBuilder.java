package net.media.training.designpattern.builder;

import java.util.Stack;

public class XMLBuilder {
  private StringBuilder xml;
  private Stack<String> elementStack;
  private boolean openTag;

  public XMLBuilder() {
    xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    elementStack = new Stack<>();
    openTag = false;
  }

  public XMLBuilder startElement(String name) {
    closeOpenTagIfNeeded();
    xml.append("<").append(name);
    elementStack.push(name);
    openTag = true;
    return this;
  }

  public XMLBuilder addAttribute(String name, String value) {
    if (!openTag) {
      throw new IllegalStateException("Can't add attribute outside of an open tag.");
    }
    xml.append(" ").append(name).append("=\"").append(escape(value)).append("\"");
    return this;
  }

  public XMLBuilder addAttribute(String name, int value) {
    if (!openTag) {
      throw new IllegalStateException("Can't add attribute outside of an open tag.");
    }
    xml.append(" ").append(name).append("=\"").append(escape(String.valueOf(value))).append("\"");
    return this;
  }

  public XMLBuilder addText(String text) {
    closeOpenTagIfNeeded();
    xml.append(escape(text));
    return this;
  }

  public XMLBuilder endElement() {
    if (elementStack.isEmpty()) {
      throw new IllegalStateException("No open elements to close.");
    }

    String name = elementStack.pop();

    if (openTag) {
      xml.append("/>");
      openTag = false;
    } else {
      xml.append("</").append(name).append(">");
    }
    return this;
  }

  private void closeOpenTagIfNeeded() {
    if (openTag) {
      xml.append(">");
      openTag = false;
    }
  }

  public String build() {
    if (!elementStack.isEmpty()) {
      throw new IllegalStateException("Unclosed tags exist.");
    }
    return xml.toString();
  }

  private String escape(String s) {
    return s.replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\"", "&quot;")
        .replace("'", "&apos;");
  }
}