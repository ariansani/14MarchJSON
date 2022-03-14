package vtttp2022.ssf.MarchJSON.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import vtttp2022.ssf.MarchJSON.services.QuoteService;

@Controller
@RequestMapping(path="/quote" ,produces=MediaType.TEXT_HTML_VALUE)
public class QuoteController {
    
    @Autowired
    private QuoteService quoteSvc;

    @GetMapping
    public String getQuote(Model model){
        model.addAttribute("quote",quoteSvc.getQuote());
        return "quote";
    }

}
