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

import com.cigolweb.maproserver.entities.Module;
import com.cigolweb.maproserver.service.interfaces.ModuleServiceInt;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	private ModuleServiceInt moduleService;

	@GetMapping("/all/")
	public Collection<Module> getAll() {
		Collection<Module> modules = new HashSet<Module>();
		for (Module module : moduleService.findAll()) {
			modules.add(module.limit());
		}
		return modules;
	}

	@PostMapping("/create/")
	@ResponseStatus(HttpStatus.CREATED)
	public Module create(@RequestBody Module module) {
		return moduleService.save(module);
	}

}
