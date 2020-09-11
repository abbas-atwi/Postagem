package entities;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	private String nome;
	private Integer id;
	private int idade;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	public Pessoa(String nome, Integer id, int idades) {
		this.nome = nome;
		this.id = id;
		this.idade = idades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}


}
