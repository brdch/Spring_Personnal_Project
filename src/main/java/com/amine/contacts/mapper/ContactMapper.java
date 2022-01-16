package com.amine.contacts.mapper;

import com.amine.contacts.entity.ContactEntity;
import org.openapitools.client.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public ContactEntity mapContactToEntity(Contact contact){
        ContactEntity entity = new ContactEntity();
        entity.setAddress(contact.getAddress());
        entity.setName(contact.getName());
        entity.setPhone(contact.getPhone());
        entity.setEmail(contact.getEmail());
        return entity;
    }
}
