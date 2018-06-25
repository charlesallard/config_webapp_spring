package com.projet.webapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.bdd.*;



@RestController
@RequestMapping("")
public class MyController {
	@Autowired
	private UserDAO userdao;


    /*@RequestMapping(method = RequestMethod.GET, produces = "application/json")
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
    
    @GetMapping(value = "usersJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> usersjson(){
    	return new ResponseEntity<String>("{\"id\":0, \"firstname\":null, \"lastname\":null, \"email\":null, \"password\":null }", HttpStatus.OK);
    }*/
    
    @GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> users(){
    	System.out.println("LISTUSER");
    	return userdao.getListUsers();
    }
    
    @PostMapping(value="user", consumes= MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user) {
    	userdao.addUser(user);
    }
    
    @DeleteMapping(value="user/{id}")
    public void delUser(@PathVariable("id") int id) {
    	userdao.deleteUser(id);
    }
    
    @PutMapping(value="usermodif/{id}", consumes= MediaType.APPLICATION_JSON_VALUE)
    public void changeUser(@PathVariable("id") int id, @RequestBody User user) {
    	userdao.updateUser(user, id);
    }
    
    
}