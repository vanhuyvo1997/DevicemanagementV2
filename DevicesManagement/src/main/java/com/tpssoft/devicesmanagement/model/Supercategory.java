package com.tpssoft.devicesmanagement.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "supercategory")
public class Supercategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsupercategory;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy="supercategory")
	private Set<Subcategory> subcategories; 
	
	public int getIdsupercategory() {
		return idsupercategory;
	}

	public void setIdsupercategory(int idsupercategory) {
		this.idsupercategory = idsupercategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Set<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	public Supercategory() {
		super();
	}

	

}