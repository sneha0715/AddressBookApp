package com.sneha.Address_Book.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneha.Address_Book.entities.AddressBook;

public interface AddressBookRepository extends JpaRepository<AddressBook , Long> {
  Optional<AddressBook> findByName(String name);
}
