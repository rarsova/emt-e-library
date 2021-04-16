package mk.ukim.finki.emt.library.service.serviceImpl;

import mk.ukim.finki.emt.library.model.Country;
import mk.ukim.finki.emt.library.repository.CountryRepository;
import mk.ukim.finki.emt.library.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        if(name==null || name.isEmpty() || continent==null || continent.isEmpty())
            throw new IllegalArgumentException();
        Country country = new Country(name, continent);
        countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
