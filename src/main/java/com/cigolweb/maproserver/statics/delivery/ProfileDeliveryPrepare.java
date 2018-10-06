package com.cigolweb.maproserver.statics.delivery;

import com.cigolweb.maproserver.entities.Profile;

public final class ProfileDeliveryPrepare {
	public static Profile sendProfile(Profile profile) {
		profile.setMenus(MenuDeliveryPrepare.sendMenus(profile.getMenus()));
		return profile;
	}
}
