package Package;

import Package.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerSendSimpleEmail() {

		service.sendSimpleEmail("kunaev993@gmail.com",
				"Это сообщение без файла...",
				"Это сообщение без файла");

	}

@EventListener(ApplicationReadyEvent.class)
public void triggerMail() throws MessagingException {

	service.sendEmailWithAttachment("kunaev993@gmail.com",
			"Это сообщение с файлом...",
			"Это сообщение с файлом pdf, но можно вставлять любой файл",
			"C:/Users/User/IdeaProjects/mail/src/main/resources/ticket.pdf");

}
}