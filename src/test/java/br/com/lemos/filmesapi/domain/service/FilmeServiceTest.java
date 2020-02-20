package br.com.lemos.filmesapi.domain.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.lemos.filmesapi.builder.FilmeBuilder;
import br.com.lemos.filmesapi.domain.model.Filme;

public class FilmeServiceTest {

	@InjectMocks
	@Spy
	FilmeService service;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveIncrementarVersaoSeDescricaoNaoEVazia() {
		
		//cenario
		Integer versaoAtual = 1;
		Integer versaoIncrementada = 2;
		Filme filme = FilmeBuilder.umFilme().comVersao(versaoAtual).build();
		Integer id = 1;
		Map<String, Object> campos = new HashMap<>();
		campos.put("descricao", "Nova descricao");
		Mockito.when(service.getFilme(id)).thenReturn(filme);
		
		//execucao
		Filme filmeAtualizado = service.atualizarDescricao(id, campos);

		//resultado
		assertEquals(versaoIncrementada, filmeAtualizado.getVersao());
		assertEquals("Nova descricao", filmeAtualizado.getDescricao());
	}
	
	@Test
	public void naoDeveIncrementarVersaoSeDescricaoEVazia() {
		
		//cenario
		Integer versaoAtual = 1;
		Filme filme = FilmeBuilder.umFilme().comVersao(versaoAtual).build();
		Integer id = 1;
		Map<String, Object> campos = new HashMap<>();
		campos.put("descricao", "");
		Mockito.when(service.getFilme(id)).thenReturn(filme);
		
		//execucao
		Filme filmeAtualizado = service.atualizarDescricao(id, campos);

		//resultado
		assertEquals(versaoAtual, filmeAtualizado.getVersao());
	}
	
	@Test
	public void naoDeveIncrementarVersaoSeDescricaoEIgual() {
		
		//cenario
		Integer versaoAtual = 1;
		Filme filme = FilmeBuilder.umFilme().comVersao(versaoAtual).comDescricao("Teste").build();
		Integer id = 1;
		Map<String, Object> campos = new HashMap<>();
		campos.put("descricao", "Teste");
		Mockito.when(service.getFilme(id)).thenReturn(filme);
		
		//execucao
		Filme filmeAtualizado = service.atualizarDescricao(id, campos);

		//resultado
		assertEquals(versaoAtual, filmeAtualizado.getVersao());
	}
}
