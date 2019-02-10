package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/suma")
    public ResponseEntity suma (@RequestParam("liczby") int[] liczby){
        return ResponseEntity.ok(Arrays.stream(liczby).sum());
    }

    @GetMapping("/srednia")
    public ResponseEntity srednia (@RequestParam("liczby") int[] liczby){
        return ResponseEntity.ok(Arrays.stream(liczby).average());
    }

    @GetMapping("/mnozenie")
    public ResponseEntity mnozenie (@RequestParam("liczby") int[] liczby){
/*        int a = 1;
        for (int i = 0; i < liczby.length ; i++) {
            a *= liczby[i];
        }
        return ResponseEntity.ok(a);*/
        return ResponseEntity.ok(Arrays.stream(liczby).reduce((x,y) -> x*y));
    }

    @GetMapping("/dzielenie")
    public ResponseEntity dzielenie (@RequestParam("liczby") int[] liczby){

        return ResponseEntity.ok(Arrays.stream(liczby).filter(i -> i != 0).reduce((x,y) -> x/y));
    }
}
