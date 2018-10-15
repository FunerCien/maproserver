package com.cigolweb.maproserver.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "activities")
@PrimaryKeyJoinColumn(name = "id_act")
public class Activity extends Option implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "module_act", length = 30)
	private String module;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

}
