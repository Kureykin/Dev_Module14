package com.example.dao;

import com.example.Database;
import com.example.Note;

import java.util.List;
import java.util.NoSuchElementException;

public class NoteDaoServiceImp implements NoteDaoService{



    @Override
    public List<Note> listAll() {
        return Database.getInstance().getList();
    }

    @Override
    public Note add(Note note) {
        List<Note> noteList = Database.getInstance().getList();

        note.generateId();
        noteList.add(note);

        return note;
    }

    @Override
    public void deleteById(long id) {
        List<Note> noteList = Database.getInstance().getList();

        try {
            noteList.removeIf(note -> note.getId() == id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Note note) {
        List<Note> noteList = Database.getInstance().getList();

        try {
            for(Note listedNote: noteList){
                if(listedNote.getId() == note.getId()) {
                    listedNote.titleUpdate(note.getTitle());
                    listedNote.contentUpdate(note.getContent());
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Note getById(long id) {
        List<Note> noteList = Database.getInstance().getList();

        try {
            for(Note note: noteList) {
                if(note.getId() == id) {
                    return noteList.get(noteList.indexOf(note));
                }
            }

            throw new NoSuchElementException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
