package com.zetalatakam.rest.noteservice.controller.v1.api;

import com.zetalatakam.rest.noteservice.model.Note;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RestController
public class NoteController {

    @GetMapping("/hello-word/{id}")
    public Note getNote(@PathVariable String id){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.of(2016, 8, 19);
        LocalDate localDate2 = LocalDate.of(2021, 8, 19);

        return new Note("malice á la plage","nelson01","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",false, Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()),Date.from(localDate2.atStartOfDay(defaultZoneId).toInstant()));
    }



}
