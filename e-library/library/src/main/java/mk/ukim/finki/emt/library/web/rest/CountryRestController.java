package mk.ukim.finki.emt.library.web.rest;

import mk.ukim.finki.emt.library.model.Country;
import mk.ukim.finki.emt.library.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    //read

    @GetMapping
    public List<Country> findAll(){
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        return this.countryService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //create
    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestParam String name, @RequestParam String continent){
        return this.countryService.save(name,continent)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        countryService.deleteById(id);
        if(countryService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
