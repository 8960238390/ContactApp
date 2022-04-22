package com.sharifit.service;

import java.util.List;

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
		
		Contact contact = repo.getById(id);
		
		
		return contact;
	}

	@Override
	public int delete(int id) {
		
		repo.deleteById(id);
		return 1;
	}

}
