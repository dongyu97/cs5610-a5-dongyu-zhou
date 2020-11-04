package com.example.cs5610a5dongyuzhou.models;

import java.util.Comparator;
import java.util.Objects;

public class Widget implements Comparable<Widget> {

  private String name;
  private Integer id;
  private String type;
  private Integer widgetOrder;
  private String text;
  private String src;
  private String url;
  private String href;
  private Integer size;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String style;
  private String value;

  public Widget(String name, String type, Integer widgetOrder, String text, String src,
      String url, String href, Integer size, Integer width, Integer height, String cssClass,
      String style, String value) {
    this.name = name;
    this.type = type;
    this.widgetOrder = widgetOrder;
    this.text = text;
    this.src = src;
    this.url = url;
    this.href = href;
    this.size = size;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(Integer widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public int compareTo(Widget w) {
    if (this.widgetOrder > w.getWidgetOrder()) {
      return 1;
    } else {
      return -1;
    }
  }
  public void changeOrderUP(Widget w){
    int temp = this.id;
    this.id = w.id;
    w.id = temp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Widget widget = (Widget) o;
    return Objects.equals(name, widget.name) &&
        Objects.equals(id, widget.id) &&
        Objects.equals(type, widget.type) &&
        Objects.equals(widgetOrder, widget.widgetOrder) &&
        Objects.equals(text, widget.text) &&
        Objects.equals(src, widget.src) &&
        Objects.equals(url, widget.url) &&
        Objects.equals(href, widget.href) &&
        Objects.equals(size, widget.size) &&
        Objects.equals(width, widget.width) &&
        Objects.equals(height, widget.height) &&
        Objects.equals(cssClass, widget.cssClass) &&
        Objects.equals(style, widget.style) &&
        Objects.equals(value, widget.value);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(name, id, type, widgetOrder, text, src, url, href, size, width, height, cssClass,
            style,
            value);
  }
}
