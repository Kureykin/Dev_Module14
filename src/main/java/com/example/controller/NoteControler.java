package com.example.controller;

import com.example.Note;
import com.example.service.NoteCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/notes")
public class NoteControler {
    @Autowired
    private NoteCrudService noteService;

    @GetMapping("/newNote")
    public ModelAndView createPage() {
        ModelAndView result = new ModelAndView("note/create");
        return result;
    }
    @PostMapping("/newNote")
    public ModelAndView createNote(@ModelAttribute Note note) {
        List<Note> noteList = noteService.listAll();
        noteService.add(new Note(note.getTitle(), note.getContent()));

        var model = new ModelMap("notes", noteList);
        return new ModelAndView("redirect:/notes/", model);
    }

    @GetMapping("/")
    public ModelAndView getNoteList() {
        List<Note> noteList = noteService.listAll();
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("notes", noteList);
        return result;
    }

    @PostMapping("/note")
    public ModelAndView deleteNote(@ModelAttribute(name = "id") long id) {
        List<Note> noteList = noteService.listAll();
        noteService.deleteById(id);

        ModelMap model = new ModelMap("notes", noteList);
        return new ModelAndView("redirect:/notes/", model);
    }

    @GetMapping("/note")
    public ModelAndView getEditPage(@RequestParam(name = "id") long id) {
        List<Note> noteList = noteService.listAll();
        ModelAndView result = new ModelAndView("note/edit");

        for(Note note:noteList){
            if(note.getId() == id) {
                result.addObject("note", note);
                break;
            }
        }
        return result;
    }

    @PostMapping("/updatedNote")
    public ModelAndView editNote(@ModelAttribute Note newNote) {
        List<Note> noteList = noteService.listAll();
        noteService.update(newNote);

        ModelMap model = new ModelMap("notes", noteList);
        return new ModelAndView("redirect:/notes/", model);
    }
}
