package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.model.Person;
import com.deloitte.repository.PersonRepository;
import com.deloitte.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age)
	{
		Person p=personService.create(firstName, lastName, age);
		return p.toString();
	}
	
	@RequestMapping("/get")
	public Person getPerson(@RequestParam String firstName)
	{
		return personService.getByFirstName(firstName);
	}
	
	@RequestMapping("/getAll")
	public List<Person> getAll()
	{
		return personService.getAll();		
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age)
	{
		Person p=personService.update(firstName, lastName, age);
		return p.toString();
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll()
	{
		personService.deleteAll();
		return "deleted all records";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String firstName)
	{
		personService.delete(firstName);
		return "deleteed "+firstName;
		
		
		
	
	}

}
