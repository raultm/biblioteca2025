package es.acaex.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import es.acaex.biblioteca.services.PopulateDataService;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Autowired
	PopulateDataService populateDataService;

	@EventListener(ApplicationReadyEvent.class)
	public void runOnStartUp() {
		populateDataService.execute();
	}

}
