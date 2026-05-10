package com.example.service;

import com.example.Note;
import com.example.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteService implements NoteCrudService {
    @Autowired
    private NoteRepository repo;

    public NoteService(NoteRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Note> listAll() {
        return repo.findAll();
    }

    @Override
    public Note add(Note note) {
        return repo.save(note);
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Note note){
        repo.save(note);
    }

    @Override
    public Note getById(long id) {
        return repo.findById(id).get();
    }
}
