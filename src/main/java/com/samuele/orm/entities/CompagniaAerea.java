package com.samuele.orm.entities;

import java.util.List; 

import javax.persistence.*;

@Entity
@Table(name = "compagniaAerea")
public class CompagniaAerea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String nazione;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="compagniaGruppo_id")
	private CompagniaAerea compagniaGruppo;

	@OneToMany(mappedBy="compagniaGruppo")
	private List<CompagniaAerea> compagnieSub;
	
	@OneToMany(mappedBy="compagnia")
	private List<Volo> voli;
	
	public CompagniaAerea(long id, String nome, String nazione) {
		super();
		this.id = id;
		this.nome = nome;
		this.nazione = nazione;
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

	public List<Volo> getVoli() {
		return voli;
	}

	public void setVoli(List<Volo> voli) {
		this.voli = voli;
	}
	

	public CompagniaAerea getCompagniaGruppo() {
		return compagniaGruppo;
	}

	public void setCompagniaGruppo(CompagniaAerea compagniaGruppo) {
		this.compagniaGruppo = compagniaGruppo;
	}

	@Override
	public String toString() {
		return "CompagniaAerea [id=" + id + ", nome=" + nome + ", nazione=" + nazione + ", compagniaGruppo="
				+ compagniaGruppo + ", voli=" + voli + "]";
	}
	
	

	
	
	
	
	
	
	

}
