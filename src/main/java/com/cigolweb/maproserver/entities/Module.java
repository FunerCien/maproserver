package com.cigolweb.maproserver.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "modules")
public class Module implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_mod")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name_mod", length = 30)
	private String name;

	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Activity> activities = new HashSet<Activity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public Module limit() {
		this.setActivities(null);
		return this;
	}

}