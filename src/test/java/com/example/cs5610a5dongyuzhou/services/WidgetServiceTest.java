package com.example.cs5610a5dongyuzhou.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.cs5610a5dongyuzhou.models.Widget;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WidgetServiceTest {

  private Widget widget1;
  private Widget widget2;
  private Widget widget3;

  private WidgetService widgetService;

  @BeforeEach
  void setUp() {
    widget1 = new Widget("widget1", "type", 0, "text1",
        "src", "url", "href", 100, 20, 60, "cssClass",
        "style", "value");
    widget2 = new Widget("widget2", "type", 0, "text1",
        "src", "url", "href", 100, 20, 60, "cssClass",
        "style", "value");
    widget3 = new Widget("widget3", "type", 0, "text1",
        "src", "url", "href", 100, 20, 60, "cssClass",
        "style", "value");
    widgetService = new WidgetService();
  }

  @Test
  void createWidget() {
    Widget widget = this.widgetService.createWidget("1", widget1);
    assertEquals(widget1, widget);
    assertEquals(0, widget.getId());
    assertEquals(1, this.widgetService.findAllWidgets().size());
    widget = this.widgetService.findAllWidgets().get(0);
    assertEquals(0, widget.getId());
    assertEquals(widget1, widget);
    widget = this.widgetService.createWidget("1", widget2);
    assertEquals(1, widget.getId());
    assertEquals(widget2, widget);
    assertEquals(2, this.widgetService.findAllWidgets().size());
  }

  @Test
  void findWidgetsForTopic() {
    this.widgetService.createWidget("1", widget1);
    this.widgetService.createWidget("1", widget2);
    this.widgetService.createWidget("2", widget3);
    List<Widget> expectedList1 = Arrays.asList(widget1, widget2);
    List<Widget> expectedList2 = Collections.singletonList(widget3);
    assertEquals(expectedList1, this.widgetService.findWidgetsForTopic("1"));
    assertEquals(expectedList2, this.widgetService.findWidgetsForTopic("2"));
  }

  @Test
  void updateWidget() {
    Widget widget4 = new Widget("widget4", "type", 0, "text1",
        "src", "url", "href", 100, 20, 60, "cssClass",
        "style", "value");
    widget4.setId(4);
    this.widgetService.createWidget("1", widget1);
    Widget newWidget1 = new Widget("widget1", "type", 0, "newText",
        "src", "url", "href", 100, 20, 60, "cssClass",
        "style", "value");
    int res = this.widgetService.updateWidget("0", newWidget1);
    assertEquals(1, res);
    res = this.widgetService.updateWidget("4", widget4);
    assertEquals(0, res);
  }

  @Test
  void deleteWidget() {
    this.widgetService.createWidget("1", widget1);
    int res = this.widgetService.deleteWidget("0");
    assertEquals(1, res);
    assertEquals(0, this.widgetService.findAllWidgets().size());
    res = this.widgetService.deleteWidget("0");
    assertEquals(0, res);
  }

  @Test
  void findAllWidgets() {
    this.widgetService.createWidget("1", widget1);
    assertEquals(1, this.widgetService.findAllWidgets().size());
    this.widgetService.createWidget("1", widget2);
    assertEquals(2, this.widgetService.findAllWidgets().size());
  }

  @Test
  void findWidgetById() {
    Widget widget = this.widgetService.createWidget("1", widget1);
    Widget newWidget = this.widgetService.findWidgetById("0");
    assertEquals(widget, newWidget);
  }
}