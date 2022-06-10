package clientServeur.Licence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class LicenceApplication{

	public static void main(String[] args) {
		SpringApplication.run(LicenceApplication.class, args);
	}

}
