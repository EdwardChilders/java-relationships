package com.edward.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edward.relationships.models.License;
import com.edward.relationships.models.Person;
import com.edward.relationships.services.LicenseService;
import com.edward.relationships.services.PersonService;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;
	@Autowired
	private LicenseService licenseService;
	
//	public PersonController(PersonService personService) {
//		this.personService = personService;
//	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "newPerson.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/persons/" + person.getId();
        }
    }
    @RequestMapping("/persons/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Person person = personService.findPerson(id);
    	model.addAttribute("person", person);
        return "show.jsp";
    }
    
    @RequestMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license, Model model) {
    	List<Person> persons = personService.allPeople();
    	model.addAttribute("persons", persons);
    	return "newLicense.jsp";
    }
    
    @RequestMapping(value="/licenses/new", method=RequestMethod.POST)
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
    	if (result.hasErrors()) {
    		System.out.println("Error creating a license");
    		return "redirect:/licenses/new";
    	} else {
    		license.setNumber(String.format("%06d", license.getPerson().getId()));
    		licenseService.createLicense(license);
    		return "redirect:/persons/" + license.getPerson().getId();
    	}
    }
}
