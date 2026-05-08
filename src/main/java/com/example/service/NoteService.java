package com.example.service;

import com.example.dao.NoteDaoService;
import com.example.dao.NoteDaoServiceImp;
import com.example.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements NoteCrudService {
    NoteDaoService service = new NoteDaoServiceImp();


    @Override
    public List<Note> listAll() {
        return service.listAll();
    }

    @Override
    public Note add(Note note) {
        return service.add(note);
    }

    @Override
    public void deleteById(long id) {
        service.deleteById(id);
    }

    @Override
    public void update(Note note) {
        service.update(note);
    }

    @Override
    public Note getById(long id) {
        return service.getById(id);
    }
}
