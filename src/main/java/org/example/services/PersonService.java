package org.example.services;



import org.example.Foo;
import org.example.FooRepository;
import org.example.FooRepositoryImpl;
import org.example.dtos.*;
import org.example.entities.Contact;
import org.example.entities.Person;
import org.example.repositories.ContactRepository;
import org.example.repositories.PersonRepository;
import org.example.utils.TransactionHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Map<String, List<>> messages = HashMap)()
// "az"
// "ru"
// "en"
public class PersonService {
    PersonRepository personRepository;
//    private final ContactRepository contactRepository;
//    private final TransactionHelper transactionHelper;
    FooRepository fooRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        fooRepository = new FooRepositoryImpl();
        fooRepository.save(new Foo());
    }

//    public PersonService(PersonRepository personRepository, ContactRepository contactRepository, TransactionHelper transactionHelper) {
//        this.personRepository = personRepository;
//        this.contactRepository = contactRepository;
//        this.transactionHelper = transactionHelper;
//    }




    public GenericResponse<PersonResponse> add(PersonRequest personRequest) throws SQLException {
//        List<ContactRequest> cr  = personRequest.getContacts();
//        List<Contact> contacts = new ArrayList<>();
//        for (ContactRequest contactRequest : cr) {
//            Contact c = ContactService.toContact(contactRequest);
//
//            contacts.add();
//        }
        Person p = toPerson(personRequest);
        personRepository.addPerson(p);
//        transactionHelper.executeInTransaction(()->{
//            personRepository.addPerson(p);
            List<ContactRequest> cr = personRequest.getContacts();
            for (ContactRequest contactRequest : cr) {
                Contact contact = ContactService.toContact(contactRequest);
                contact.setPersonId(p.getId()); // Associate with the saved person's ID
//                contactRepository.saveContact(contact);
            }
//        });

        return new GenericResponse<>("Success",toPersonResponse(p));
    }

    public List<PersonResponse> findAll() {
        List<Person> persons = personRepository.findAll();
        List<PersonResponse> personResponses = new ArrayList<>();
        for (Person pr : persons) {
             personResponses.add(toPersonResponse(pr));
        }
        return personResponses;
    }

    public static Person toPerson(PersonRequest personRequest) {
       return new Person(personRequest.getFin(), personRequest.getName(), personRequest.getSurname());
    }
    public static PersonResponse toPersonResponse(Person  p) {
        return new PersonResponse(p.getId(), p.getFin(), p.getName(), p.getSurname());
    }
}
