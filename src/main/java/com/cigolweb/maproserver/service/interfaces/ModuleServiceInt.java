package com.cigolweb.maproserver.service.interfaces;

import java.util.Collection;

import com.cigolweb.maproserver.entities.Module;

public interface ModuleServiceInt {

	public Module save(Module module);

	public Collection<Module> findAll();
}
