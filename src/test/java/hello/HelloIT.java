package hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HelloIT {

    @Autowired
    FunctionCatalog functionCatalog;

    @Test
    void hello() {
        var function = (Function<Message<HelloRequest>, HelloResponse>) functionCatalog.lookup("hello");
        var response = function.apply(new GenericMessage<>(new HelloRequest("John Doe")));
        assertEquals("Hello John Doe!", response.message());
    }
}