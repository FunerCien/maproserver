package com.cigolweb.maproserver.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cigolweb.maproserver.dao.interfaces.MenuDaoInt;
import com.cigolweb.maproserver.entities.Menu;
import com.cigolweb.maproserver.entities.Profile;
import com.cigolweb.maproserver.service.interfaces.MenuServiceInt;

@Service
public class MenuService implements MenuServiceInt {

	@Autowired
	private MenuDaoInt menuDao;

	@Override
	@Transactional(readOnly = true)
	public Set<Menu> findByMenuAndProfiles(Menu menu, Set<Profile> profiles) {
		Set<Menu> menus = null;
		for (Menu menuToFilter : menus) {
		}
		return menus;
	}

}
