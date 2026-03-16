package com.sneha.Address_Book.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sneha.Address_Book.entities.AddressBook;
import com.sneha.Address_Book.entities.Contact;
import com.sneha.Address_Book.repositories.AddressBookRepository;
import com.sneha.Address_Book.repositories.ContactRepository;

@Service
public class AddressBookService {

  private static final String DEFAULT_ADDRESS_BOOK_NAME = "Default";

  @Autowired
  private ContactRepository contactRepository;
  @Autowired
  private AddressBookRepository addressBookRepository;

  public Contact geContact(Long id) {
    return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
  }

  public AddressBook getAddressBook(Long id) {
    return addressBookRepository.findById(id).orElseThrow(() -> new RuntimeException("AddressBook not found"));
  }

  public List<AddressBook> getAllAddressBooks(){
    return addressBookRepository.findAll();
  }

  public List<Contact> getContactsByAddressBook(Long addressBookId){
    AddressBook addressBook = getAddressBook(addressBookId);
    return addressBook.getContacts();
  }

  public List<Contact> getAllContact() {
    return contactRepository.findAll();
  }

  public Contact saveContact(Contact contact) {
    AddressBook addressBook = getOrCreateDefaultAddressBook();
    addressBook.getContacts().add(contact);
    addressBookRepository.save(addressBook);
    return contact;
  }

  public AddressBook addContact(Long addressBookId, Contact contact) {
    AddressBook addressBook = addressBookRepository.findById(addressBookId)
        .orElseThrow(() -> new RuntimeException("Address Book not found"));
    addressBook.getContacts().add(contact);

    return addressBookRepository.save(addressBook);
  }

  private AddressBook getOrCreateDefaultAddressBook() {
    return addressBookRepository.findByName(DEFAULT_ADDRESS_BOOK_NAME)
        .orElseGet(() -> addressBookRepository.save(
            new AddressBook(null, DEFAULT_ADDRESS_BOOK_NAME, new ArrayList<>())));
  }
}
