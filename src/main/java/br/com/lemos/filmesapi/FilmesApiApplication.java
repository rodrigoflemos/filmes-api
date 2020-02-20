package br.com.lemos.filmesapi;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.lemos.filmesapi.domain.service.FilmeService;

@SpringBootApplication
public class FilmesApiApplication {

	@Autowired
	FilmeService filmeService;
	
	public static void main(String[] args) {
		SpringApplication.run(FilmesApiApplication.class, args);
	}

	@Bean
	public void carregarFilmes(){
		filmeService.carregarFilmes();
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
