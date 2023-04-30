package com.geekster.University.Management.System.service;

import com.geekster.University.Management.System.dao.IEventRepo;
import com.geekster.University.Management.System.model.EventModel;
import jakarta.transaction.Transactional;
import org.hibernate.event.spi.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;
    public void eventAdd(EventModel em) {
        eventRepo.save(em);
    }

    public List<EventModel> findByDate(LocalDate date) {
       return  eventRepo.findByDate(date);
    }

    public void deleteStudent(int id) {
        eventRepo.deleteById(id);
    }
    @Transactional
    public void updateEvent(int id, EventModel eventModel) {
      if(eventRepo.existsById(id)){
          eventRepo.save(eventModel);
      }
    }
}
