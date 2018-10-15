package com.cigolweb.maproserver.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "menus")
@PrimaryKeyJoinColumn(name = "id_men")
public class Menu extends Option implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "url_men", length = 30)
	private String url;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_men")
	private Menu menu;

	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Menu> menus;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Menu limit() {
		this.setMenu(null);
		return this;
	}
}
