package com.cigolweb.maproserver.dao.interfaces;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.cigolweb.maproserver.entities.Menu;
import com.cigolweb.maproserver.entities.Profile;

public interface MenuDaoInt extends CrudRepository<Menu, Long> {

	
}
