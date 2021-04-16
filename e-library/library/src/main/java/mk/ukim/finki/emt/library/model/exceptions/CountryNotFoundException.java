package mk.ukim.finki.emt.library.model.exceptions;

import mk.ukim.finki.emt.library.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException() {
        super("Country not found exception");
    }
}
