package twoClassesDISolution;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("One")
public class GreetingOne implements Greeting{
    @Override
    public String getGreeting() {
        return "Hello World";
    }
}

