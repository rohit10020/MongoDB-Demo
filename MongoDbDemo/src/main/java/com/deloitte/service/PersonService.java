package com.deloitte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.model.Person;
import com.deloitte.repository.PersonRepository;

@Service
public class PersonService {
	
	
	@Autowired
	private PersonRepository personRepository;
	
	//create CRUD
	public Person create(String firstName, String lastName, int age)
	{
		return personRepository.save(new Person(firstName,lastName,age));
		
	}
	
	//fetch search
	public List<Person> getAll()
	{
		return personRepository.findAll();
			
	}
	
	public Person getByFirstName(String firstName)
	{
		return personRepository.findByFirstName(firstName);
	}

	
	//update
	public Person update(String firstName, String lastName, int age)
	{
		Person p=personRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		
		return personRepository.save(p);
				
	}
	
	//delete
	public void deleteAll()
	{
		personRepository.deleteAll();
	}
	
	public void delete(String firstName)
	{
		Person p=personRepository.findByFirstName(firstName);
		personRepository.delete(p);
		
	}
	
	 
}
