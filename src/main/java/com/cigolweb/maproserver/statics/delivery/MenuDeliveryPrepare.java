package com.cigolweb.maproserver.statics.delivery;

import java.util.HashSet;
import java.util.Set;

import com.cigolweb.maproserver.entities.Menu;

public final class MenuDeliveryPrepare {

	public static Menu sendMenu(Menu menu) {
		menu.setMenu(null);
		menu.setProfiles(null);
		for (Menu menus : menu.getMenus()) {
			sendMenu(menus);
		}
		return menu;
	}

	public static Set<Menu> sendMenus(Set<Menu> menus) {
		Set<Menu> menusToSend = new HashSet<Menu>();
		for (Menu menu : menus) {
			menusToSend.add(sendMenu(menu));
		}
		return menusToSend;
	}
}
