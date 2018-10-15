package com.cigolweb.maproserver.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cigolweb.maproserver.dao.interfaces.OptionDaoInt;
import com.cigolweb.maproserver.entities.Option;
import com.cigolweb.maproserver.service.interfaces.OptionServiceInt;

@Service
public class OptionService implements OptionServiceInt {

	@Autowired
	private OptionDaoInt optionDao;

	@Override
	@Transactional(readOnly = true)
	public Collection<Option> findAll() {
		return  (Collection<Option>) optionDao.findBasicOptions();
	}

}
