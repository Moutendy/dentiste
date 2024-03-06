package api.dentiste.apidentiste.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dentiste.apidentiste.dto.UserDto;
import api.dentiste.apidentiste.service.UserI;

@RestController
@RequestMapping("api/user/")
public class UserController {
	protected UserI userI;
	
	public UserController(UserI userI) {
		this.userI = userI;		
	}
	
	
	@PostMapping(value="adduser" ,consumes = "application/json")
	ResponseEntity<String> addUser(@RequestBody UserDto user) {
		   try {
			   userI.addUser(user);
	           return new ResponseEntity<>("user add successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	           return new ResponseEntity<>("Failed to add consultation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@GetMapping(value="adduser/{id}" ,consumes = "application/json")
	ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
		   try {
           return new ResponseEntity<>(userI.getUser(id), HttpStatus.CREATED);
	        } catch (Exception e) {
	       return new ResponseEntity<>(userI.getUser(id), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	}
	
	@GetMapping(value="showuser" ,consumes = "application/json")
	ResponseEntity<List<UserDto>> showUser() {
	   try {
		   return new ResponseEntity<>(userI.showUser(), HttpStatus.CREATED);
		} catch (Exception e) {
		   return new ResponseEntity<>(userI.showUser(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="searchuser/{userName}" ,consumes = "application/json")
	ResponseEntity<List<UserDto>> searchUser(@PathVariable("userName")String userName) {
	   try {
	       return new ResponseEntity<>(userI.searchUser(userName), HttpStatus.CREATED);
		} catch (Exception e) {
		   return new ResponseEntity<>(userI.searchUser(userName), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}
