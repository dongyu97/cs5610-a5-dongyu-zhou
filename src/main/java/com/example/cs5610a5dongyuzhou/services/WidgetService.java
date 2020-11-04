package com.example.cs5610a5dongyuzhou.services;

import com.example.cs5610a5dongyuzhou.models.Widget;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  private final Map<String, List<Widget>> widgetStore;
  private Integer currentId;

  public WidgetService() {
    this.widgetStore = new HashMap<>();
    this.currentId = 0;
  }

  public Widget createWidget(String tid, Widget widget) {
    if (!this.widgetStore.containsKey(tid)) {
      this.widgetStore.put(tid, new LinkedList<>());
    }
    this.widgetStore.get(tid).add(widget);
    widget.setId(this.currentId);
    this.currentId += 1;
    return widget;
  }


  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> widgetList= this.widgetStore.getOrDefault(tid, Collections.emptyList());
    Collections.sort(widgetList);
    return widgetList;
//    return this.widgetStore.getOrDefault(tid, Collections.emptyList());

  }

  public int updateWidget(String wid, Widget widget) {
    Widget oldWidget = this.findWidgetById(wid);
    String tid = this.getTidByWidget(oldWidget);
    if (tid == null) {
      return 0;
    } else {
      oldWidget.setName(widget.getName());
      oldWidget.setType(widget.getType());
      oldWidget.setWidgetOrder(widget.getWidgetOrder());
      oldWidget.setText(widget.getText());
      oldWidget.setSrc(widget.getSrc());
      oldWidget.setUrl(widget.getUrl());
      oldWidget.setHref(widget.getHref());
      oldWidget.setSize(widget.getSize());
      oldWidget.setWidth(widget.getWidth());
      oldWidget.setHeight(widget.getHeight());
      oldWidget.setCssClass(widget.getCssClass());
      oldWidget.setStyle(widget.getStyle());
      oldWidget.setValue(widget.getValue());
      return 1;
    }
  }

  public int deleteWidget(String wid) {
    Widget widget = this.findWidgetById(wid);
    if (widget == null) {
      return 0;
    } else {
      String tid = this.getTidByWidget(widget);
      List<Widget> widgetList= this.widgetStore.get(tid);
      this.widgetStore.get(tid).remove(widget);
      this.widgetStore.put(tid, widgetList.stream()
      .peek(w->{
        if (w.getWidgetOrder()>widget.getWidgetOrder()){
          int order=w.getWidgetOrder();
          w.setWidgetOrder(order-1);
        }
      })
      .collect(Collectors.toList()));
      return 1;
    }
  }

  private String getTidByWidget(Widget widget) {
    Entry<String, List<Widget>> entry = this.widgetStore.entrySet().stream()
        .filter(e -> e.getValue().stream()
            .anyMatch(w -> w.equals(widget)))
        .findFirst()
        .orElse(null);
    return entry == null ? null : entry.getKey();
  }

  public List<Widget> findAllWidgets() {
    return this.widgetStore.values().stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  public Widget findWidgetById(String wid) {
    return this.findAllWidgets().stream()
        .filter(w -> String.valueOf(w.getId()).equals(wid))
        .findFirst()
        .orElse(null);
  }
}
