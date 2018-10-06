package com.cigolweb.maproserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cigolweb.maproserver.entities.Profile;
import com.cigolweb.maproserver.service.interfaces.ProfileServiceInt;
import com.cigolweb.maproserver.statics.delivery.ProfileDeliveryPrepare;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileServiceInt profileService;

	@GetMapping("/profile/{idPrf}")
	public Profile getMenusByProfileId(@PathVariable Long idPrf) {
		return ProfileDeliveryPrepare.sendProfile(profileService.findById(idPrf));
	}

}
