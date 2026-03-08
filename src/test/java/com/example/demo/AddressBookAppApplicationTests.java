package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Contact;
import com.example.demo.repository.AddressBookRepository;

@SpringBootTest
class AddressBookAppApplicationTests {

	@Test
    public void shouldRetrieveContactsFromDatabase() {
        AddressBookRepository repo = new AddressBookRepository();
        assertTrue(repo.retrieveContacts() >= 0);
    }
	
	@Test
	public void testContactUpdated() {
	    AddressBookRepository repo = new AddressBookRepository();
	    
	    int result = repo.updateContactByFirstName(
	            "a",
	            "lastname",
	            "address",
	            "city",
	            "state",
	            "zip",
	            "9999999999",
	            "mail@gmail.com"
	    );

	    assertEquals(1, result);

	    Contact dbContact = repo.retrieveContactByFirstName("a");

	    assertEquals("a", dbContact.getFirstName());
	    assertEquals("lastname", dbContact.getLastName());
	    assertEquals("address", dbContact.getAddress());
	    assertEquals("city", dbContact.getCity());
	    assertEquals("state", dbContact.getState());
	    assertEquals("zip", dbContact.getZip());
	    assertEquals("9999999999", dbContact.getPhoneNumber());
	    assertEquals("mail@gmail.com", dbContact.getEmail());
	}

}
