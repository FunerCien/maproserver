package com.cigolweb.maproserver.controller;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cigolweb.maproserver.entities.Menu;
import com.cigolweb.maproserver.entities.Option;
import com.cigolweb.maproserver.service.interfaces.OptionServiceInt;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/option")
public class OptionController {

	@Autowired
	private OptionServiceInt optionService;

	@GetMapping("/all/")
	public Collection<Option> getAllOptions() {
		Collection<Option> options = new HashSet<Option>();
		for (Option option : optionService.findAll()) {
			options.add(option.getClass().equals(Menu.class) ? limitMenuTree(((Menu) option)) : option);
		}
		return options;
	}

	@PostMapping("/create/")
	@ResponseStatus(HttpStatus.CREATED)
	public Option create(@RequestBody Option option) {
		return optionService.save(option);
	}

	private Menu limitMenuTree(Menu menu) {
		for (Menu subMenu : menu.getMenus()) {
			limitMenuTree(subMenu.limit());
		}
		return menu;
	}

}
