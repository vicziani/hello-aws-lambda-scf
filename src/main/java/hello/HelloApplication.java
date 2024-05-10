package hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
@Slf4j
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@Bean
	public Function<HelloRequest, HelloResponse> hello() {
		return (request) -> {
			var name = request.name();
			log.debug("Name: %s".formatted(name));
			return new HelloResponse("Hello %s!".formatted(name));
		};
	}
}
