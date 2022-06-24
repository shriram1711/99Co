package co.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.Demo.entity.Property;
import co.Demo.entity.User;
import co.Demo.services.IListService;
import co.Demo.services.IPublicAPIService;
import co.Demo.services.IUserService;

@Controller
@RequestMapping("public-api")
public class PublicAPIController {

	@Autowired
	private IPublicAPIService service;

	@Autowired
	private IUserService userService;

	@Autowired
	private IListService listService;

	@GetMapping("/listings")
	public ResponseEntity<List<Property>> getPublicAPIListings(@RequestParam(required = false) Integer user,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size,
			@RequestParam(defaultValue = "createdAt") String sortBy) {
		List<Property> listings = service.getPublicAPIListings();
		return new ResponseEntity<List<Property>>(listings, HttpStatus.OK);
	}

	@PostMapping("/listings")
	public ResponseEntity<Property> createPublicAPIListings(@RequestBody Property list) {
		Property createdPublicAPIList = listService.createList(list);
		if (createdPublicAPIList == null) {
			return new ResponseEntity<Property>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Property>(createdPublicAPIList, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createPublicAPIUser(@RequestBody User user) {
		User createdPublicAPIUser = userService.createUser(user);
		return new ResponseEntity<User>(createdPublicAPIUser, HttpStatus.OK);
	}

}
