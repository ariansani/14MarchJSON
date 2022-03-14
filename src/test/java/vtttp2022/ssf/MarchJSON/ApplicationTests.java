package vtttp2022.ssf.MarchJSON;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import vtttp2022.ssf.MarchJSON.controllers.QuoteRestController;
import vtttp2022.ssf.MarchJSON.services.QuoteService;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private QuoteService quoteSvc;

	@Autowired
	private QuoteRestController quoteRestCtrl;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	Assertions.assertNotNull(quoteSvc);
	}

	@Test
	public void quoteRestCtrlShouldNotBeNull(){
		
		Assertions.assertNotNull(quoteRestCtrl);
		
		// MockHttpServletRequestBuilder req = new MockHttpServletRequestBuilder();
		// mockMvc.perform(requestBuilder);
	}

	@Test
	public void getQuotesShouldBeEqual(){
	int count = 4;
	Collection<String> result = quoteSvc.getQuotes(count);
	Assertions.assertEquals(count,result.size(),"getQuotes does not return the expected count");
	}


}
