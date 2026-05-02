package com.example.dao;

import com.example.demo.Note;

import java.util.List;

public interface NoteDaoService {
    public List<Note> listAll();
    public Note add(Note note);
    public void deleteById(long id);
    public void update(Note note);
    public Note getById(long id);
}
