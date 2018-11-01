package com.cigolweb.maproserver.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cigolweb.maproserver.entities.Activity;
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
			Collection<Activity> activities = new HashSet<Activity>();
			for (Activity activity : module.getActivities()) {
				activities.add(activity);
			}
			module.setActivities((Set<Activity>) activities);
			modules.add(module);
		}
		return modules;
	}

	@GetMapping("/all/limit/")
	public Collection<Module> getAllLimit() {
		Collection<Module> modules = new HashSet<Module>();
		for (Module module : moduleService.findAll()) {
			modules.add(module.limit());
		}
		return modules;
	}

	@PostMapping("/exists/")
	public Boolean exists(@RequestBody Module module) {
		return moduleService.existsByName(module.getName());
	}

	@PostMapping("/create/")
	public Module create(@RequestBody Module module) {
		return moduleService.save(module);
	}

}
