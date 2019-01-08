package com.samuele.orm.entities;

import javax.persistence.*;

@Entity
@Table(name = "aereo", uniqueConstraints= {@UniqueConstraint(columnNames ={"marca","modello"})})
public class Aereo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modello;

	public Aereo(String marca, String modello) {
		this.marca = marca;
		this.modello = modello;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	@Override
	public String toString() {
		return "Aereo [id=" + id + ", marca=" + marca + ", modello=" + modello + "]";
	}

}
