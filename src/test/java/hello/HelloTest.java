package hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.support.GenericMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HelloTest {

    @Test
    void hello() {
        var app = new HelloApplication();
        var function = app.hello();
        var response = function.apply(new HelloRequest("John Doe"));
        assertEquals("Hello John Doe!", response.message());
    }
}
