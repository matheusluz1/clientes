import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.matheusluz1.clientes.config;"})
public class ClientesApplication {

	//forca o reconhecimento do component scan de security
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}
}