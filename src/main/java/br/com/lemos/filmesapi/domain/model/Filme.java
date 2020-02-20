package br.com.lemos.filmesapi.domain.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Filme {

	@SerializedName(value = "title")
	private String titulo;
	
	@SerializedName("episode_id")
	private Integer id;
	
	@SerializedName("opening_crawl")
	private String textoAbertura;
	
	@SerializedName("director")
	private String diretor;
	
	@SerializedName("producer")
	private String produtor;
	
	@SerializedName("release_date")
	private String dataLancamento;
	
	private Integer versao = 1;
	
	private String descricao;
	
	private String ipAlteracao;
	
	@SerializedName("characters")
	private List<String> personagens;
	
	@SerializedName("planets")
	private List<String> planetas;
	
	@SerializedName("starships")
	private List<String> navesEspaciais;
	
	@SerializedName("vehicles")
	private List<String> veiculos;
	
	@SerializedName("species")
	private List<String> especies;
	
	public String getTitulo() {
		return titulo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTextoAbertura() {
		return textoAbertura;
	}

	public void setTextoAbertura(String textoAbertura) {
		this.textoAbertura = textoAbertura;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIpAlteracao() {
		return ipAlteracao;
	}

	public void setIpAlteracao(String ipAlteracao) {
		this.ipAlteracao = ipAlteracao;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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