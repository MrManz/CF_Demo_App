package App;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    private static final String template = "Goodbye, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/Data")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Universe") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}