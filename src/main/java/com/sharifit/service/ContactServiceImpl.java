package com.sharifit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharifit.entity.Contact;
import com.sharifit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repo;
	
	@Override
	public List<Contact> findAll() {
		
		List<Contact> contacts = repo.findAll();
		return contacts;
	}

	@Override
	public int upsert(Contact contact) {
		
		
		Contact save = repo.save(contact);
		
		if(save==null) {
			return 0;
		}else {
			return 1;
		}
		
	}

	@Override
	public Contact edit(int id) {
		
		Optional<Contact> result = repo.findById(id);
		Contact contact;
		
		if(result.isPresent()) {
			contact = result.get();
		}
		else {
			contact = null;
		}
		
		
		return contact;
	}

	@Override
	public int delete(int id) {
		
		repo.deleteById(id);
		return 1;
	}

}
