package com.cigolweb.maproserver.dao.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.cigolweb.maproserver.entities.Module;

public interface ModuleDaoInt extends CrudRepository<Module, Long> {
	public Boolean existsByName(String name);
}
