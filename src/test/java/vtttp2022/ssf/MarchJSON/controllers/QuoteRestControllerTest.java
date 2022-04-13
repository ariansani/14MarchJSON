package vtttp2022.ssf.MarchJSON.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.StringReader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;

@SpringBootTest
@AutoConfigureMockMvc
public class QuoteRestControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void shouldReturn200(){

        // Build the request
        RequestBuilder req = MockMvcRequestBuilders.get("/quote")
        .accept(MediaType.TEXT_HTML_VALUE);


        MvcResult result = null;
        try {
            
            result = mvc.perform(req).andReturn();

        } catch (Exception e) {
            //TODO: handle exception
            fail("cannot perform mvc invocation",e);
            return;
        }


        //Get response
        MockHttpServletResponse resp = result.getResponse();
        try {
            
            String payload = resp.getContentAsString();
            assertNotNull(payload);

        } catch (Exception e) {
            
            fail("cannot retrieve response payload",e);

            return;
        }
    }

    @Test
    public void shouldReturn10Quotes(){
        
        int count = 10;

        //construct request
        RequestBuilder req = MockMvcRequestBuilders.get("/quote")
            .accept(MediaType.APPLICATION_JSON)
            .queryParam("count", ""+count)
            .header("X-ID", "a header");

        //Make the request
        MvcResult result = null;
        try {
            result = mvc.perform(req).andReturn();
        } catch (Exception e) {
            //TODO: handle exception
            fail("cannot perform mvc invocation", e);
            return;
        }

        MockHttpServletResponse resp = result.getResponse();
        String payload;
        try {
            //JSON
            payload = resp.getContentAsString();
        } catch (Exception e) {
            //TODO: handle exception
            fail("cannot retrieve response payload", e);
            return;
        }

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonArray quotes = reader.readArray();
        
        assertEquals(count, quotes.size(),
        "Expect %s quotes, retrieved %s".formatted(count, quotes.size()));
        
    }
    

}
