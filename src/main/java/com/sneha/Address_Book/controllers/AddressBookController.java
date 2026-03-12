package com.sneha.Address_Book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sneha.Address_Book.entities.Contact;
import com.sneha.Address_Book.services.AddressBookService;

@RestController
public class AddressBookController {
  
  @Autowired
  private AddressBookService service;

  @GetMapping("/test")
  public String Test(){
    return "Test";
  }

  @PostMapping("/contacts")
  public Contact createContact(@RequestBody Contact contact){
    return service.saveContact(contact);
  }
}
