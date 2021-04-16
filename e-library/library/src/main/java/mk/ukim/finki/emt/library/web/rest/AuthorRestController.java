package mk.ukim.finki.emt.library.web.rest;

import mk.ukim.finki.emt.library.model.Author;
import mk.ukim.finki.emt.library.model.dto.AuthorDto;
import mk.ukim.finki.emt.library.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //read
    @GetMapping
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        return this.authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //create

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestBody AuthorDto authorDto){
        return this.authorService.save(authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        this.authorService.deleteById(id);
        if(this.authorService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
