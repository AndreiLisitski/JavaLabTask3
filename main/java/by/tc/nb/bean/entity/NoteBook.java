package by.tc.nb.bean.entity;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {
	
	List<Note> notes = new ArrayList<Note>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public void cleanNoteBook() {
        notes.clear();
    }

    public List<Note> getNotes() {
        return notes;
    }

}
