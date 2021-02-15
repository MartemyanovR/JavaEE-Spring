package springCrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import springCrud.dao.PersonDao;

@Controller
@RequestMapping("/people")
public class PeopleController {
	
	private final PersonDao personDao;
	
	//DI
	public PeopleController(PersonDao personDao) {
		this.personDao = personDao;
	}

	/*
	 * возвращает список из людей из DAO, и передает на отображение в представление
	 */
	@GetMapping()
	public String index(Model/*Разработан в первую очередь для добавления атрибутов в модель.*/ model) {
		model.addAttribute("peoples", personDao.index());
		return "/people/index";
	}
	
	/*
	 * получим  одноого человека из дао и передадим на  отображение в представление
	 */
	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", personDao.show(id));
		return "/people/show";
	}








}
