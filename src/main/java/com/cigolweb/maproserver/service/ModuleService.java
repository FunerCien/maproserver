package com.cigolweb.maproserver.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cigolweb.maproserver.dao.interfaces.ModuleDaoInt;
import com.cigolweb.maproserver.entities.Module;
import com.cigolweb.maproserver.service.interfaces.ModuleServiceInt;

@Service
public class ModuleService implements ModuleServiceInt {

	@Autowired
	private ModuleDaoInt moduleDao;

	@Override
	@Transactional(readOnly = true)
	public Collection<Module> findAll() {
		return (Collection<Module>) moduleDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Module save(Module module) {
		return moduleDao.save(module);
	}

}
