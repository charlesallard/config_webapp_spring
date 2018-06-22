package webapp;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class MyController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> foo2() {
        return new ResponseEntity<String>("{}", HttpStatus.OK);
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ResponseEntity<String> foo() {
        return new ResponseEntity<String>("Appli de mes ghjghujrftyèr", HttpStatus.OK);
    }
    
    @GetMapping(value = "/images/search/{annee}/{month}/{day}")
    public ResponseEntity<String> affiche(@PathVariable("annee") String annee, @PathVariable("month") String month, @PathVariable("day") String day, @RequestParam("sort") String sort){
    	//return new ResponseEntity<String>( , HttpStatus.OK);
    	LocalDate loc = LocalDate.of(Integer.parseInt(annee), Integer.parseInt(month), Integer.parseInt(day));
    	return new ResponseEntity<String>("Liste des images du " + loc.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")) + " trié par " + sort, HttpStatus.OK);
    }
    
    @GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> users(){
    	return new ResponseEntity<String>("{\"id\":0, \"firstname\":null, \"lastname\":null, \"email\":null, \"password\":null }", HttpStatus.OK);
    }
}