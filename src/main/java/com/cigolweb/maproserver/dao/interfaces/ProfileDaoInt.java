package com.cigolweb.maproserver.dao.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.cigolweb.maproserver.entities.Profile;

public interface ProfileDaoInt extends CrudRepository<Profile, Long> {

}
