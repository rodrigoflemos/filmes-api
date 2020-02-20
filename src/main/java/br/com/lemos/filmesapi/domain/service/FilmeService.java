package br.com.lemos.filmesapi.domain.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.lemos.filmesapi.domain.model.Filme;
import br.com.lemos.filmesapi.domain.model.ResultadoFilme;

@Service
public class FilmeService {

	Map<Integer, Filme> filmes = new HashMap<>();

	public void carregarFilmes() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<String> response = restTemplate.exchange("https://swapi.co/api/films", HttpMethod.GET,entity,String.class);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ResultadoFilme resultadoFilme = gson.fromJson(response.getBody(), ResultadoFilme.class);
		
		filmes =  resultadoFilme.getResults().stream()
			      .collect(Collectors.toMap(Filme::getId, filme -> filme));
	}

	public Map<Integer,Filme> getFilmes(){
		return filmes;
	}
	
	public Filme getFilme (Integer id) {
		return filmes.get(id);
	}

	public Filme atualizarDescricao(Integer id, Map<String, Object> campos) {
		Filme filme = getFilme(id);
		
		String descricao = (String)campos.get("descricao");
		if(Strings.isNotBlank(descricao) && !descricao.equals(filme.getDescricao())){
			filme.setDescricao((String)campos.get("descricao"));
			filme.setIpAlteracao((String)campos.get("ipAlteracao"));
			filme.setVersao(filme.getVersao() + 1);
		}
		return filme;
	}
}