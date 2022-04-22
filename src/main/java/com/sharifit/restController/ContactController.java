package com.sharifit.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharifit.entity.Contact;
import com.sharifit.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")
	public ResponseEntity<List<Contact>> contacts(){
		 
		List<Contact> contacts = contactService.findAll();
		
		return new ResponseEntity<>(contacts,HttpStatus.OK);
	}
	
	@PostMapping("/contact")
	public ResponseEntity<String> upsert(@RequestBody Contact contact) {
		
		int result = contactService.upsert(contact);
		
		if(result>0) {
			return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>("FAILED",HttpStatus.EXPECTATION_FAILED);
	}
	
	@GetMapping("contact/{id}")
	public ResponseEntity<Contact> edit(@PathVariable("id") int id) {
	
		Contact contact = contactService.edit(id);
		
		if(contact == null) {
			new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contact,HttpStatus.FOUND);
	}
	
	@DeleteMapping("contact/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		
		int result = contactService.delete(id);
		
		if(result == 1) {
			return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}
	
		return new ResponseEntity<>("FAILED",HttpStatus.EXPECTATION_FAILED);
	}
	
	
	
	
}
