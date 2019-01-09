package com.samuele.orm.entities;

import java.util.ArrayList; 
import java.util.List;

//import java.util.ArrayList;  
//import java.util.List; 

import javax.persistence.*;

@Entity
@Table(name = "compagniaAerea")
public class CompagniaAerea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable=false, unique=true)
	private String nome;
	
	@Column(nullable=false)
	private String nazione;
	
	@ManyToOne
	private CompagniaAerea compagniaGruppo;

	@OneToMany(mappedBy="compagniaGruppo", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true) 
	private List<CompagniaAerea> compagnieSub = new ArrayList<>();
	
	@OneToMany(mappedBy = "compagnia", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<Volo> voliOfferti = new ArrayList<>();
	
	public CompagniaAerea(String nome, String nazione, CompagniaAerea compagniaGruppo) {
		super();
		this.nome = nome;
		this.nazione = nazione;
		this.compagniaGruppo = compagniaGruppo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}	

	public CompagniaAerea getCompagniaGruppo() {
		return compagniaGruppo;
	}

	public void setCompagniaGruppo(CompagniaAerea compagniaGruppo) {
		this.compagniaGruppo = compagniaGruppo;
	}

	public List<CompagniaAerea> getCompagnieSub() {
		return compagnieSub;
	}

	public void setCompagnieSub(List<CompagniaAerea> compagnieSub) {
		this.compagnieSub = compagnieSub;
	}

	public List<Volo> getVoliOfferti() {
		return voliOfferti;
	}

	public void setVoliOfferti(List<Volo> voliOfferti) {
		this.voliOfferti = voliOfferti;
	}

	@Override
	public String toString() {
		return "CompagniaAerea [id=" + id + ", nome=" + nome + ", nazione=" + nazione + ", compagniaGruppo="
				+ compagniaGruppo + "]";
	}
	
	

	
	
	
	
	
	
	

}
