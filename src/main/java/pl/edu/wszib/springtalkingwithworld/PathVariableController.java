package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Calendar;

@Controller
@RequestMapping("/data")
public class PathVariableController {

    @GetMapping("/{rok}/{miesiac}/{dzien}")
    public ResponseEntity post (@PathVariable int rok,
                                @PathVariable int miesiac,
                                @PathVariable int dzien){
        Calendar calendar = Calendar.getInstance();
        calendar.set(rok, miesiac, dzien);
        ResponseEntity entity = new ResponseEntity(calendar.getTimeInMillis(), HttpStatus.OK);
        return entity;
    }

    @GetMapping("/{rok}/{miesiac}")
    public ResponseEntity post (@PathVariable int rok,
                                @PathVariable int miesiac){
        Calendar calendar = Calendar.getInstance();
        calendar.set(rok, miesiac, 1);
        ResponseEntity entity = new ResponseEntity(calendar.getTimeInMillis(), HttpStatus.OK);
        return entity;
    }

    @GetMapping("/{rok}")
    public ResponseEntity post (@PathVariable int rok){
        Calendar calendar = Calendar.getInstance();
        calendar.set(rok,1, 1);
        ResponseEntity entity = new ResponseEntity(calendar.getTimeInMillis(), HttpStatus.OK);
        return entity;
    }


}
