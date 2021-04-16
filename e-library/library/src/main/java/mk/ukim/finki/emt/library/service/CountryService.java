package mk.ukim.finki.emt.library.service;

import mk.ukim.finki.emt.library.model.Country;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(String name, String continent);

    void deleteById(Long id);
}
