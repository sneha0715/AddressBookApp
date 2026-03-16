package com.sneha.Address_Book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sneha.Address_Book.entities.AddressBook;
import com.sneha.Address_Book.entities.Contact;
import com.sneha.Address_Book.services.AddressBookService;

@RestController
public class AddressBookController {
  
  @Autowired
  private AddressBookService service;

  @GetMapping("/contacts")
  public List<Contact> getContacts(){
    return service.getAllContact();
  }


  @PostMapping("/contacts")
  public Contact createContact(@RequestBody Contact contact){
    return service.saveContact(contact);
  }

  @GetMapping("/addressBooks")
  public List<AddressBook> getAddressBook(){
    return service.getAllAddressBooks();
  }

  @GetMapping("/addressBooks/{id}")
  public AddressBook getAddressBook(@PathVariable Long id){
    return service.getAddressBook(id);
  }

  @GetMapping("/addressBooks/{id}/contacts")
  public List<Contact> getContactsByAddressBook(@PathVariable Long id){
    return service.getContactsByAddressBook(id); 
  }

  @PostMapping("/addressBooks/{id}/contacts")
  public AddressBook addContact(@PathVariable long id , @RequestBody Contact contact){
    return service.addContact(id, contact);
  }
}
