package mk.ukim.finki.emt.library.repository;

import mk.ukim.finki.emt.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select availableCopies from Book where id = :id")
    int getAvailableCopiesById(Long id);
}
