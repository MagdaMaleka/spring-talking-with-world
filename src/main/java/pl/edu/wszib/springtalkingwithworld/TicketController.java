package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springtalkingwithworld.model.Bilet;
import pl.edu.wszib.springtalkingwithworld.model.BiletDTO;
import pl.edu.wszib.springtalkingwithworld.model.Osoba;
import pl.edu.wszib.springtalkingwithworld.model.OsobaDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/bilety")
public class TicketController {

    private Map<String, Bilet> mapa = new HashMap<>();

    @GetMapping("/{id")
    public ResponseEntity<BiletDTO> odbierz(@PathVariable String id){
        Bilet bilet = mapa.get(id);
        return ResponseEntity.ok(convert(bilet));
    }

    @PostMapping()
    public ResponseEntity dodaj (@RequestBody BiletDTO bilet){
        String id = String.valueOf(new Random().nextInt());
        mapa.put(id, convert(bilet));
        return ResponseEntity.ok(id);
    }

    private BiletDTO convert (Bilet bilet){
        BiletDTO biletDTO = new BiletDTO();
        biletDTO.date = bilet.date;
        biletDTO.osoba = convert(bilet.osoba);
        return biletDTO;
    }

    private OsobaDTO convert (Osoba osoba){
        OsobaDTO osobaDTO = new OsobaDTO();
        osobaDTO.imie = osoba.imie;
        osobaDTO.wiek = osoba.wiek;
        return osobaDTO;
    }

    private Bilet convert (BiletDTO biletDTO){
        Bilet bilet = new Bilet();
        bilet.date = biletDTO.date;
        bilet.osoba = convert(biletDTO.osoba);
        return bilet;
    }

    private Osoba convert (OsobaDTO osobaDTO){
        Osoba osoba = new Osoba();
        osoba.imie = osobaDTO.imie;
        osoba.wiek = osobaDTO.wiek;
        return osoba;
    }


}
