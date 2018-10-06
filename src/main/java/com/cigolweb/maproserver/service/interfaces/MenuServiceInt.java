package com.cigolweb.maproserver.service.interfaces;

import java.util.Set;

import com.cigolweb.maproserver.entities.Menu;
import com.cigolweb.maproserver.entities.Profile;

public interface MenuServiceInt {

	public Set<Menu> findByMenuAndProfiles(Menu menu, Set<Profile> profiles);

}
