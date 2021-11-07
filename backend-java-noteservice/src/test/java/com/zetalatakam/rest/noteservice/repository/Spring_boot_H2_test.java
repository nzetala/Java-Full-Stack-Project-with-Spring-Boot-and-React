package com.zetalatakam.rest.noteservice.repository;

import com.zetalatakam.rest.noteservice.model.Note;
import com.zetalatakam.rest.noteservice.repositrory.NoteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Spring_boot_H2_test {

    @Autowired
    private NoteRepository noteRepository;

    @Test
    @DisplayName("Create Note Test ")
    void createNoteTest() {

        Note created = noteRepository.save(getNote());

        assertTrue(created != null);
    }
    @Test
    @DisplayName("Retrieve Notes by username Test ")
    void retrieveNoteByUsernameTest() {


        for (Note note:getNotes()
             ) {
            noteRepository.save(note);

        }
        List<Note> listOfRetrieved= noteRepository.findByUsername("valdez");
        for (Note note:listOfRetrieved
             ) {
            assertEquals("valdez" , note.getUsername());
        }
        assertEquals(2 , listOfRetrieved.size());


        listOfRetrieved= noteRepository.findByUsername("NonExistingUsername");
        for (Note note:listOfRetrieved
        ) {
            assertTrue(listOfRetrieved.isEmpty());
        }




    }

    private Note getNote() {

        Note note = new Note();
        note.setNoteName("dummy_name");
        note.setContentText("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
        note.setFavorite(false);
        note.setUsername("dummy_user");
        note.setCreatedDate(new Date());
        note.setLastUpdateDate(new Date());
        return note;
    }
    private List<Note> getNotes(){
        List<Note> notes=new ArrayList();
        notes.add(new Note( "Learn JPA", "Nelson02","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",false,  new Date(),new Date()));
        notes.add(new Note( "Learn JPA3", "valdez","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",true,  new Date(),new Date()));
        notes.add(new Note( "Learn JPA4", "Nelson02","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",true,  new Date(),new Date()));
        notes.add(new Note( "Learn JPA5", "valdez","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",false,  new Date(),new Date()));
        return notes;
    }
}