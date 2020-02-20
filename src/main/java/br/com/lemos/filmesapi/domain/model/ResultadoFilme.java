package br.com.lemos.filmesapi.domain.model;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.JsonElement;

public class ResultadoFilme {

	private int count;
	private String next = null;
	private String previous = null;
	Set <Filme> results = new HashSet<>();

	// Getter Methods 

	public int getCount() {
		return count;
	}

	public String getNext() {
		return next;
	}

	public Set<Filme> getResults() {
		return results;
	}

	public void setResults(Set<Filme> results) {
		this.results = results;
	}

	public String getPrevious() {
		return previous;
	}

	// Setter Methods 

	public void setCount(int count) {
		this.count = count;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}
}