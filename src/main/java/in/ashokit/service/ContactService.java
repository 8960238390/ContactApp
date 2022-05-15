package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Contact;

public interface ContactService {

	List<Contact> findAll();
	int upsert(Contact contact);
	Contact edit(int id);
	int delete(int id);
}
