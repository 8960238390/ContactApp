package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repo;

	@Override
	public List<Contact> findAll() {
		
		List<Contact> contacts = repo.findAll();
		List<Contact> newContacts = new ArrayList<>();
		
		for(Contact contact : contacts)
		{
			if(contact.getActive_sw().equalsIgnoreCase("Y")) {
				newContacts.add(contact);
			}
		}
		return newContacts;
	}

	@Override
	public int upsert(Contact contact) {

		if (contact.getId() == 0) {
			contact.setActive_sw("Y");
		}

		Contact save = repo.save(contact);
		
		
		
		if (save == null) {
			return 0;
		} else {
			return 1;
		}

	}

	@Override
	public Contact edit(int id) {

		Optional<Contact> result = repo.findById(id);
		Contact contact;

		if (result.isPresent()) {
			contact = result.get();
		} else {
			contact = null;
		}

		return contact;
	}

	@Override
	public int delete(int id) {

		// repo.deleteById(id);

		Contact contact = edit(id);

		contact.setActive_sw("N");

		int count = upsert(contact);

		return count;
	}

}
