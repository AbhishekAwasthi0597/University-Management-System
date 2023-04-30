package com.geekster.University.Management.System.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int eventId;
    @NotBlank
    private String eventName;
    @NotBlank
    private String locationOfEvent;
    @NotNull
    @JsonFormat(shape =  JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate date;
     @NotNull
     @JsonFormat(shape =  JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
    private String startTime;
   @NotNull
   @JsonFormat(shape =  JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
    private  String endTime;


}
