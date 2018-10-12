package com.cigolweb.maproserver.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_opt")
	@OneToOne(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Long id;

	@Column(name = "url_men")
	private String url;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bestMenu")
	private Set<Option> options;

}
