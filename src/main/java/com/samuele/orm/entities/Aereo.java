package com.samuele.orm.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "aereo")
public class Aereo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modello;
	
	@Column(nullable = false)
	private Date annoAcquisto;
	
	@OneToMany(mappedBy = "aereo")
	private List<Volo> voli;

	public Aereo(String marca, String modello, Date annoAcquisto) {
		this.marca = marca;
		this.modello = modello;
		this.annoAcquisto = annoAcquisto;
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

	public Date getAnnoAcquisto() {
		return annoAcquisto;
	}

	public void setAnnoAcquisto(Date annoAcquisto) {
		this.annoAcquisto = annoAcquisto;
	}

	@Override
	public String toString() {
		return "Aereo [id=" + id + ", marca=" + marca + ", modello=" + modello + ", annoAcquisto=" + annoAcquisto + "]";
	}

}
