package com.sharifit.service;

import java.util.List;

import com.sharifit.entity.Contact;

public interface ContactService {

	List<Contact> findAll();
	int upsert(Contact contact);
	Contact edit(int id);
	int delete(int id);
}
