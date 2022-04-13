package vtttp2022.ssf.MarchJSON.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuoteServiceTest {

    @Autowired
    private QuoteService quoteSvc;


    @Test
    void testGetQuotes() {
        int count = 2;

        Collection<String> result = quoteSvc.getQuotes(2);

        assertEquals(count, result.size(),"Request num quotes in params");

    }
}
