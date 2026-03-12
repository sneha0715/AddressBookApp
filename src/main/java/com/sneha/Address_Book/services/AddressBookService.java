package com.sneha.Address_Book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sneha.Address_Book.entities.Contact;
import com.sneha.Address_Book.repositories.ContactRepository;

@Service
public class AddressBookService {

  @Autowired
  private ContactRepository repository;

  public Contact saveContact(Contact contact){
    return repository.save(contact);
  }
}
