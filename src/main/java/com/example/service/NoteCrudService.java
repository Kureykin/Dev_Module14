package com.example.service;

import com.example.Note;

import java.util.List;

public interface NoteCrudService {
    public List<Note> listAll();
    public Note add(Note note);
    public void deleteById(long id);
    public void update(Note note);
    public Note getById(long id);
}
