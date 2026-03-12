package com.sneha.Address_Book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneha.Address_Book.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long>{
  
}
