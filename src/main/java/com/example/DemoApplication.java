package com.example;

import com.example.service.NoteCrudService;
import com.example.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.controller.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Note note = new Note("Test", "Arthur");
		NoteCrudService service = new NoteService();

		note = service.add(note);
		var tmp = service.add(new Note("Test2", "test"));

		System.out.println(service.listAll());

		//service.deleteById(tmp.getId());

		System.out.println(service.getById(note.getId()));

		note.contentUpdate("Updated");
		note.titleUpdate("Updated test");
		service.update(note);

		System.out.println(service.getById(note.getId()));
		System.out.println(service.listAll());
	}

}
