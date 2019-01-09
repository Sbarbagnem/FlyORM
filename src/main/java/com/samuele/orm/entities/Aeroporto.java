package com.samuele.orm.entities;
  
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

//import java.util.List; 

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "aeroporto")
public class Aeroporto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false, unique=true)
	private String nome;
	
	@Column(nullable=false)
	private String città;
	
	@Column(nullable=false)
	private String nazione;
	
	@OneToMany(mappedBy = "aeroportoPartenza", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<Volo> voliInPartenza = new ArrayList<>();
	
	@OneToMany(mappedBy = "aeroportoArrivo", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<Volo> voliInArrivo = new ArrayList<>();
	
	public Aeroporto(String nome, String città, String nazione) {
		this.nome = nome;
		this.città = città;
		this.nazione = nazione;		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public List<Volo> getVoliInPartenza() {
		return voliInPartenza;
	}

	public void setVoliInPartenza(List<Volo> voliInPartenza) {
		this.voliInPartenza = voliInPartenza;
	}

	public List<Volo> getVoliInArrivo() {
		return voliInArrivo;
	}

	public void setVoliInArrivo(List<Volo> voliInArrivo) {
		this.voliInArrivo = voliInArrivo;
	}

	@Override
	public String toString() {
		return "Aeroporto [id=" + id + ", nome=" + nome + ", città=" + città + ", nazione=" + nazione
				+ "]";
	}
	
	
	
}
