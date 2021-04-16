package mk.ukim.finki.emt.library.web.rest;

import mk.ukim.finki.emt.library.model.Book;
import mk.ukim.finki.emt.library.model.dto.BookDto;
import mk.ukim.finki.emt.library.model.enumerations.Category;
import mk.ukim.finki.emt.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookRestController {

    private final BookService bookService;


    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    //read

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @GetMapping("/categories")
    public List<Category> listOfCategories() {
        return Arrays.asList(Category.values());
    }

    //create
    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    //update
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.edit(id,bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        this.bookService.deleteById(id);
        if(bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/markAsTaken/{id}")
    public ResponseEntity<Book> marksAsTaken(@PathVariable Long id){
        return bookService.markAsTaken(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
