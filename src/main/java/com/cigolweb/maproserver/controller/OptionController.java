package com.cigolweb.maproserver.controller;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
			if (option.getClass().equals(Menu.class)) {
				Menu optionMenu = ((Menu) option);
				limitMenuTree(optionMenu);
				options.add(optionMenu);
			} else {
				options.add(option);
			}
		}
		return options;
	}

	private Menu limitMenuTree(Menu menu) {
		for (Menu subMenu : menu.getMenus()) {
			limitMenuTree(subMenu.limit());
		}
		return menu;
	}

}
