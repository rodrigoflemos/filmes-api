package br.com.lemos.filmesapi.api.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.lemos.filmesapi.builder.FilmeBuilder;
import br.com.lemos.filmesapi.domain.model.Filme;
import br.com.lemos.filmesapi.domain.service.FilmeService;

@RunWith(SpringRunner.class)
@WebMvcTest(FilmeController.class)
public class FilmeControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private FilmeService service;

	@Test
	public void getFilmesNotFound()
			throws Exception {

		Filme filme = FilmeBuilder.umFilme().comId(1).build();

		Map<Integer, Filme> filmes = new HashMap<>();
		filmes.put(filme.getId(), filme);

		when(service.getFilmes()).thenReturn(filmes);

		mvc.perform(get("/films")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
	}

	@Test
	public void getFilmesOk()
			throws Exception {

		Filme filme = FilmeBuilder.umFilme().comId(1).build();

		Map<Integer, Filme> filmes = new HashMap<>();
		filmes.put(filme.getId(), filme);

		when(service.getFilmes()).thenReturn(filmes);

		mvc.perform(get("/filmes")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].id", is(filme.getId())));
	}

	@Test
	public void getFilmeNotFound()
			throws Exception {

		Filme filme = FilmeBuilder.umFilme().comId(10).build();

		when(service.getFilme(filme.getId())).thenReturn(null);

		mvc.perform(get("/filmes/{id}",filme.getId())
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
	}

	@Test
	public void getFilmeOk()
			throws Exception {

		Filme filme = FilmeBuilder.umFilme().comId(1).build();

		when(service.getFilme(filme.getId())).thenReturn(filme);

		mvc.perform(get("/filmes/{id}",filme.getId())
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(filme.getId())));
	}
}