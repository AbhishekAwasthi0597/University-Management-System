package com.geekster.University.Management.System.controller;

import com.geekster.University.Management.System.model.EventModel;
import com.geekster.University.Management.System.model.StudentModel;
import com.geekster.University.Management.System.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;
    @PostMapping("/event")
    public String addEvent(@Valid @RequestBody EventModel em){
        eventService.eventAdd(em);
        return "Event has been added";
    }
      @GetMapping("/getEvent/{date}")
    public List<EventModel> getEventByDate(@PathVariable String date){
        LocalDate localDate=LocalDate.parse(date);
        return eventService.findByDate(localDate);
    }
    @DeleteMapping("/event")
    public  void deleteEvent(@RequestParam int id){
        eventService.deleteStudent(id);
    }
    @PutMapping("/event/{id}")
    public void updateEvent(@PathVariable int id,@RequestBody EventModel eventModel){
          eventService.updateEvent(id,eventModel);
    }
}
