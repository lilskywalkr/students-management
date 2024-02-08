package dev.zpo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Students Management Application.
 * This class initializes and runs the Spring Boot application.
 *
 * <p>The application is configured using Spring Boot's autoconfiguration and component scanning features.
 * It starts the embedded Tomcat server and launches the application with all required configurations.
 *
 * @author Your Name
 * @version 1.0
 * @since 2024-02-08
 */
@SpringBootApplication
public class StudentsManagementApplication {

	/**
	 * Main method to start the Spring Boot application.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(StudentsManagementApplication.class, args);
	}
}

