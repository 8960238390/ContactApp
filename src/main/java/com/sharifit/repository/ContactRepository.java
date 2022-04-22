package com.sharifit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharifit.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
