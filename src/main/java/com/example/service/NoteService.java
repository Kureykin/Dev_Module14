package com.example.service;

import com.example.dao.NoteDaoService;
import com.example.dao.NoteDaoServiceImp;
import com.example.Note;
import com.example.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements NoteCrudService {
    private NoteDaoService service = new NoteDaoServiceImp();
    private NoteRepository repo;



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
        return repo.getById(id);
    }
}
