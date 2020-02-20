package br.com.lemos.filmesapi.api.controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lemos.filmesapi.api.model.FilmeDTO;
import br.com.lemos.filmesapi.api.model.FilmeDetalheDTO;
import br.com.lemos.filmesapi.domain.model.Filme;
import br.com.lemos.filmesapi.domain.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	FilmeService service;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping
	public ResponseEntity<List<FilmeDTO>> getFilmes(){
		
		Map<Integer, Filme> filmes = service.getFilmes();
		
		if(filmes == null || filmes.isEmpty())
			return ResponseEntity.notFound().build();
		
		Type listType = new TypeToken<List<FilmeDTO>>(){}.getType();
		return ResponseEntity.ok(modelMapper.map(filmes.values(),listType));
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/{id}")
	public ResponseEntity<FilmeDetalheDTO> getFilme(@PathVariable Integer id){
		
		Filme filme = service.getFilme(id);
		if(filme == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(modelMapper.map(filme,FilmeDetalheDTO.class));
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<FilmeDetalheDTO> atualizarDescricao(@PathVariable("id") Integer id,
			@RequestBody Map<String, Object> campos, HttpServletRequest request) {
		campos.put("ipAlteracao", request.getRemoteAddr());
		return ResponseEntity.ok(modelMapper.map(service.atualizarDescricao(id, campos), FilmeDetalheDTO.class));
	}
}