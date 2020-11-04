package com.example.cs5610a5dongyuzhou.controllers;

import com.example.cs5610a5dongyuzhou.models.Widget;
import com.example.cs5610a5dongyuzhou.services.WidgetService;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class WidgetController extends BaseController {



  private final WidgetService widgetService;

  public WidgetController(WidgetService widgetService) {
    this.widgetService = widgetService;
  }

  @PostMapping("/topics/{tid}/widgets")
  public Widget createWidget(@PathVariable("tid") String tid, @RequestBody Widget widget) {
    return this.widgetService.createWidget(tid, widget);
  }

  @GetMapping("/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("tid") String tid) {
    return this.widgetService.findWidgetsForTopic(tid);
  }

  @PutMapping("/widgets/{wid}")
  public int updateWidget(@PathVariable("wid") String wid, @RequestBody Widget widget) {
    return this.widgetService.updateWidget(wid, widget);
  }

  @DeleteMapping("/widgets/{wid}")
  public int deleteWidgets(@PathVariable("wid") String wid) {
    return this.widgetService.deleteWidget(wid);
  }

  @GetMapping("/widgets")
  public List<Widget> findAllWidgets() {
    return this.widgetService.findAllWidgets();
  }

  @GetMapping("/widgets/{wid}")
  public Widget findWidgetById(@PathVariable("wid") String wid) {
    return this.widgetService.findWidgetById(wid);
  }


}
