package com.example;

import com.example.service.NoteCrudService;
import com.example.service.NoteService;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.controller.*;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Flyway flyway = Flyway.configure()
				.dataSource("jdbc:h2:file:./src/main/resources/db/notesdb", "SA", null)
				.locations("filesystem:src/main/resources/migration").load();

		flyway.migrate();

		ConfigurableApplicationContext config = SpringApplication.run(DemoApplication.class, args);

		Note note = new Note("Test", "Arthur");
		NoteCrudService service = config.getBean(NoteService.class);


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
