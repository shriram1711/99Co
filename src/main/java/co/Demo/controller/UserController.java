package co.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.Demo.entity.User;
import co.Demo.services.IUserService;

@Controller
@RequestMapping("userService")
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) Long userId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "3") Integer size,
			@RequestParam(defaultValue = "createdAt") String sortBy) {
		List<User> users = service.getUsers(page, size, sortBy);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		User user = service.getUser(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = service.createUser(user);
		return new ResponseEntity<User>(createdUser, HttpStatus.OK);
	}

}
