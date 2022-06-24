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
import org.springframework.web.server.ResponseStatusException;

import co.Demo.entity.Property;
import co.Demo.services.IListService;

@Controller
@RequestMapping("listService")
public class ListController {

	@Autowired
	private IListService service;

	@GetMapping("/listings")
	public ResponseEntity<List<Property>> getList(@RequestParam(required = false) Long userId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size,
			@RequestParam(defaultValue = "createdAt") String sortBy) {
		List<Property> lists = service.getLists(page, size, sortBy);
		return new ResponseEntity<List<Property>>(lists, HttpStatus.OK);
	}

	@PostMapping("/listings")
	public ResponseEntity<Property> createList(@RequestBody Property list) {
		Property createdList = service.createList(list);
		if(createdList == null) {
			return new ResponseEntity<Property>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Property>(createdList, HttpStatus.OK);

	}
}
