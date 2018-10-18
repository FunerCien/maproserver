package com.cigolweb.maproserver.service.interfaces;

import java.util.Collection;

import com.cigolweb.maproserver.entities.Option;

public interface OptionServiceInt {

	public Collection<Option> findAll();

	public Option save(Option option);
}
