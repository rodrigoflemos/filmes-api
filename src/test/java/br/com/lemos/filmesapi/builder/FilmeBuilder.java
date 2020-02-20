package br.com.lemos.filmesapi.builder;

import br.com.lemos.filmesapi.domain.model.Filme;

public class FilmeBuilder {
	
	private Filme filme;

	private FilmeBuilder() {}

	public static FilmeBuilder umFilme() {
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme();
		return builder;
	}

	public Filme build() {
		return filme;
	}
	
	public FilmeBuilder comId(Integer id) {
		filme.setId(id);
		return this;
	}
	
	public FilmeBuilder comVersao(Integer versao) {
		filme.setVersao(versao);
		return this;
	}
	
	public FilmeBuilder comDescricao(String descricao) {
		filme.setDescricao(descricao);
		return this;
	}

}
