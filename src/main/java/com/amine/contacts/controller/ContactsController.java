package com.amine.contacts.controller;

import com.amine.contacts.config.H2ServerManual;
import com.amine.contacts.entity.ContactEntity;
import com.amine.contacts.mapper.ContactMapper;
import com.amine.contacts.repository.ContactsRepository;
import org.openapitools.client.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactsController {
    @Autowired
    private ContactsRepository repo;

    @Autowired
    private ContactMapper cMapper;

    @PostMapping("/contacts")
    public ResponseEntity createContact(@RequestBody Contact myContact) {
        repo.saveAndFlush(cMapper.mapContactToEntity(myContact));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<ContactEntity> getContact(@PathVariable("id") Long id){

        return new ResponseEntity(repo.findById(id), HttpStatus.OK);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactEntity>> getAllContacts(){

        return new ResponseEntity(repo.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<List<ContactEntity>> deleteContact(@PathVariable("id") Long id){
        repo.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity modifyRecipient(@PathVariable("id") Long id, @RequestBody Contact contact) {
        ContactEntity entity = repo.findById(id).get();
        entity.setEmail(contact.getEmail());
        entity.setPhone(contact.getPhone());
        entity.setAddress(contact.getAddress());
        entity.setName(contact.getName());

        repo.saveAndFlush(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
