package de.dirent.tapestry.piday;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.tapestry5.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.dirent.tapestry.piday.services.Pi;

@SpringBootApplication
@RestController
public class TapestryPidayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TapestryPidayApplication.class, args);
    }

    @Inject
    private Pi pi;

    @GetMapping( path = "/pi", produces = "text/plain" )
    public String pi() {
        return pi.get();
    }

    @GetMapping( path = "/pi/search", produces = "application/json" )
    public String search() {
        return search(null);
    }

    @GetMapping( path = "/pi/search/{digits}", produces = "application/json" )
    public String search( @PathVariable( "digits" ) String digits ) {
        JSONObject result = new JSONObject();
        result.put( "index", pi.search(digits) );
        result.put( "search", digits );
        return result.toCompactString();
    }

}
