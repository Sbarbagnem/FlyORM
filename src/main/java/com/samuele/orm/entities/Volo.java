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
	@JoinColumn(name="aeroportoPartenza_id", referencedColumnName="aeroporto_id")
	@Cascade({
		CascadeType.MERGE
	})
	private Aeroporto AeroportoPartenza;

	@ManyToOne
	@JoinColumn(name="aeroportoArrivo_id", referencedColumnName="aeroporto_id")
	@Cascade({
		CascadeType.MERGE
	})
	private Aeroporto AeroportoArrivo;
	
	@ManyToOne
	@JoinColumn(name="compagnia_id", referencedColumnName="compagnia_id")
	@Cascade({
		CascadeType.MERGE
	})
	private CompagniaAerea compagnia;
	
	@ManyToOne
	@JoinColumn(name="aereo_id", referencedColumnName="aereo_id")
	@Cascade({
		CascadeType.MERGE
	})
	private Aereo aereo;
		
	public Volo(Date dataPartenza, Date dataArrivo, Aeroporto AeroportoPartenza,
			Aeroporto AeroportoArrivo, CompagniaAerea compagnia, Aereo aereo) {
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataArrivo;
		this.AeroportoArrivo = AeroportoArrivo;
		this.AeroportoPartenza = AeroportoPartenza;
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
		return AeroportoPartenza;
	}

	public void setAeroportoPartenza(Aeroporto aeroportoPartenza) {
		AeroportoPartenza = aeroportoPartenza;
	}

	public Aeroporto getAeroportoArrivo() {
		return AeroportoArrivo;
	}

	public void setAeroportoArrivo(Aeroporto aeroportoArrivo) {
		AeroportoArrivo = aeroportoArrivo;
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
				+ ", AeroportoPartenza=" + AeroportoPartenza + ", AeroportoArrivo=" + AeroportoArrivo + ", compagnia="
				+ compagnia + ", aereo=" + aereo + "]";
	}
}
