package com.cigolweb.maproserver.dao.interfaces;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cigolweb.maproserver.entities.Option;

public interface OptionDaoInt extends CrudRepository<Option, Long> {

	@Query(nativeQuery = true, value = "SELECT *, CASE WHEN a.id_act IS NOT NULL THEN 1 WHEN m.id_men IS NOT NULL THEN 2 WHEN o.id_opt IS NOT NULL THEN 0 END clazz_ FROM options o LEFT JOIN activities a ON o.id_opt = a.id_act LEFT JOIN menus m ON o.id_opt = m.id_men WHERE m.menu_men IS NULL")
	public Collection<Option> findBasicOptions();
}
