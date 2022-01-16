package com.amine.contacts.repository;

import com.amine.contacts.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ContactsRepository extends JpaRepository<ContactEntity, Long> {

}
