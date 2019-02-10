package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/my")
public class MyController {

    //@RequestMapping(method = RequestMethod.GET) (to samo co poniżej) w metodzie getJson trzeba usunąć method = ...
    @GetMapping
    public ResponseEntity get() {
        ResponseEntity entity = new  ResponseEntity("Hello world", HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getJson() {
        // lub MimeType.valueOf("application/json");
        String json = "{\n" +
                "  \"imie\" : \"Adam\",\n" +
                "  \"szkola\" : {\n" +
                "    \"nazwa\" : \"SP11\",\n" +
                "    \"adres\" : \"Smiechowo 22\"\n" +
                "  },\n" +
                "  \"oceny\" : [5, 5, 2]\n" +
                "}";
        ResponseEntity entity = new  ResponseEntity(json, HttpStatus.OK);
        return entity;
    }


}
