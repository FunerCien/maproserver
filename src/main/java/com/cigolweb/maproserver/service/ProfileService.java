package com.cigolweb.maproserver.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cigolweb.maproserver.dao.interfaces.ProfileDaoInt;
import com.cigolweb.maproserver.entities.Profile;
import com.cigolweb.maproserver.service.interfaces.ProfileServiceInt;
import com.cigolweb.maproserver.statics.values.LongValues;

@Service
public class ProfileService implements ProfileServiceInt {

	@Autowired
	private MenuService menuService;

	@Autowired
	private ProfileDaoInt profileDao;

	@Override
	@Transactional(readOnly = true)
	public Profile findById(Long id) {
		Profile profile = new Profile();
		if (id.equals(LongValues.ZERO)) {
			profile.setId(LongValues.ZERO);
			profile.setMenus(menuService.findByMenuAndProfiles(null, null));
		} else if (profileDao.existsById(id)) {
			profile = profileDao.findById(id).get();
			Set<Profile> profiles = new HashSet<Profile>();
			profiles.add(profile);
			profile.setMenus(menuService.findByMenuAndProfiles(null, profiles));
		}
		return new Profile();
	}
}
