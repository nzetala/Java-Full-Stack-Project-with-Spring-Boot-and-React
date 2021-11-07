package com.zetalatakam.rest.noteservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long noteId;
    private String noteName;
    private String username;
    private boolean isFavorite;
    private Date createdDate;
    private Date lastUpdateDate;

    public Note() {
    }

    public Note(Long noteId, String noteName, String username, boolean isFavorite, Date createdDate, Date lastUpdateDate) {
        this.noteId = noteId;
        this.noteName = noteName;
        this.username = username;
        this.isFavorite = isFavorite;
        this.createdDate = createdDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getNoteId() {
        return noteId;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", noteName='" + noteName + '\'' +
                ", username='" + username + '\'' +
                ", isFavorite=" + isFavorite +
                ", createdDate=" + createdDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Note other = (Note) obj;
        if (noteId != other.noteId)
            return false;
        return true;
    }
}
