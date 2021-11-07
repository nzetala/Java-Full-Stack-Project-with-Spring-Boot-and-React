package com.zetalatakam.rest.noteservice.controller.v1.api;

import com.zetalatakam.rest.noteservice.model.Note;
import com.zetalatakam.rest.noteservice.repositrory.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
//TODO Set the url which can access to this Controller
//@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/users/{username}")
    public List<Note> getNotes(@PathVariable String username){
        return noteRepository.findByUsername(username);
    }
    @GetMapping("/users/{username}/notes/{id}")
    public Note getNote(@PathVariable String username, @PathVariable long id){
        return noteRepository.findById(id).get();
    }

    @DeleteMapping("/users/{username}/notes/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable String username, @PathVariable long id) {

        noteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable String username, @PathVariable long id,
                                           @RequestBody Note note) {
        //TODO test this next line
        note.setUsername(username);
        Note updatedNote = noteRepository.save(note);
        return new ResponseEntity<Note>(updatedNote, HttpStatus.OK);
    }

    @PostMapping("/users/{username}")
    public ResponseEntity<Note> createNote(@PathVariable String username,
                                           @RequestBody Note note) {
        note.setUsername(username);
        Note createdNote = noteRepository.save(note);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdNote.getNoteId()).toUri();

        return  ResponseEntity.created(uri).build();
    }

}
