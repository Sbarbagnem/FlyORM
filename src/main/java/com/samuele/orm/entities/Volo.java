package com.samuele.orm.entities;
         
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

 

@Entity
@Table(name = "volo")
public class Volo {  
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataPartenza;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataArrivo;
	
	@ManyToOne
	private Aeroporto aeroportoPartenza;

	@ManyToOne
	private Aeroporto aeroportoArrivo;
	
	@ManyToOne
	private CompagniaAerea compagnia;
	
	@ManyToOne
	private Aereo aereo;
		
	public Volo(Date dataPartenza, Date dataArrivo, Aeroporto aeroportoPartenza,
			Aeroporto aeroportoArrivo, CompagniaAerea compagnia, Aereo aereo) {
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataArrivo;
		this.aeroportoArrivo = aeroportoArrivo;
		this.aeroportoPartenza = aeroportoPartenza;
		this.compagnia = compagnia;
		this.aereo = aereo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public Aeroporto getAeroportoPartenza() {
		return aeroportoPartenza;
	}

	public void setAeroportoPartenza(Aeroporto aeroportoPartenza) {
		this.aeroportoPartenza = aeroportoPartenza;
	}

	public Aeroporto getAeroportoArrivo() {
		return aeroportoArrivo;
	}

	public void setAeroportoArrivo(Aeroporto aeroportoArrivo) {
		this.aeroportoArrivo = aeroportoArrivo;
	}

	public CompagniaAerea getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(CompagniaAerea compagnia) {
		this.compagnia = compagnia;
	}

	
	public Aereo getAereo() {
		return aereo;
	}

	public void setAereo(Aereo aereo) {
		this.aereo = aereo;
	}

	@Override
	public String toString() {
		return "Volo [id=" + id + ", dataPartenza=" + dataPartenza + ", dataArrivo=" + dataArrivo
				+ ", AeroportoPartenza=" + aeroportoPartenza + ", AeroportoArrivo=" + aeroportoArrivo + ", compagnia="
				+ compagnia + ", aereo=" + aereo + "]";
	}
}
