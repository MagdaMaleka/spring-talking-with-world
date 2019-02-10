package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.springtalkingwithworld.model.Klient;
import pl.edu.wszib.springtalkingwithworld.model.Restauracja;

@Controller
@RequestMapping("/restauracja")
public class RestauracjaController {

    Klient klient = new Klient();

    @GetMapping("/koszt")
    public ResponseEntity koszt (@RequestParam("klient") String imie,
                                 @RequestParam(value = "Osoba towarzyszaca", required = false) String osobaTowarzyszaca,
                                 @RequestParam (value = "Dziecko", required = false) String dziecko,
                                 @RequestParam(value = "Zwierze", required = false) String zwierze) {

        if (osobaTowarzyszaca != null){
            klient.osobaTowarzyszaca = true;
        }

        if (dziecko != null){
            klient.dziecko = true;
        }

        if(zwierze != null){
            klient.zwierze = true;
        }
        return ResponseEntity.ok(Restauracja.koszt(klient));

    }

}
