package br.com.lemos.filmesapi.api.model;

import java.util.List;

public class FilmeDetalheDTO {

	private Integer id;

	private String titulo;
	
	private String textoAbertura;

	private String descricao;

	private Integer versao;
	
	private String dataLancamento;
	
	private String ipAlteracao;

	private List<String> personagens;
	
	private List<String> planetas;
	
	private List<String> navesEspaciais;
	
	private List<String> veiculos;
	
	private List<String> especies;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTextoAbertura() {
		return textoAbertura;
	}

	public void setTextoAbertura(String textoAbertura) {
		this.textoAbertura = textoAbertura;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getIpAlteracao() {
		return ipAlteracao;
	}

	public void setIpAlteracao(String ipAlteracao) {
		this.ipAlteracao = ipAlteracao;
	}

	public List<String> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<String> personagens) {
		this.personagens = personagens;
	}

	public List<String> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<String> planetas) {
		this.planetas = planetas;
	}

	public List<String> getNavesEspaciais() {
		return navesEspaciais;
	}

	public void setNavesEspaciais(List<String> navesEspaciais) {
		this.navesEspaciais = navesEspaciais;
	}

	public List<String> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<String> veiculos) {
		this.veiculos = veiculos;
	}

	public List<String> getEspecies() {
		return especies;
	}

	public void setEspecies(List<String> especies) {
		this.especies = especies;
	}
}