package com.cigolweb.maproserver.service.interfaces;

import java.util.Collection;

import com.cigolweb.maproserver.entities.Module;

public interface ModuleServiceInt {
	
	public Boolean existsByName(String name);

	public Collection<Module> findAll();

	public Module save(Module module);

}
