package prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "prototype")
public class OfflineApp {
	public static void main(String[] args) {
		
		SpringApplication.run(OfflineApp.class, args);
	
		System.err.println("prototype up and running");
	}
}