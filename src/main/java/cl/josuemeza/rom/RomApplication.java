package cl.josuemeza.rom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RomApplication {

	public static void main(String[] args) {
		SpringApplication.run(RomApplication.class, args);
	}

}
