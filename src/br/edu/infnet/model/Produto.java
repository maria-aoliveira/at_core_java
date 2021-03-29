package br.edu.infnet.model;

import java.util.Calendar;
import java.util.Date;

public class Produto {
	
	private int id;
	private String nome;
	private String dataValidade;
	public static int nextId = 1;
	
	public Produto() {
		super();
	}

	public Produto(String nome, String dataValidade) {
		this.id = Produto.nextId;
		Produto.nextId++;
		this.nome = nome;
		this.dataValidade = dataValidade;
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getData() {
		return this.dataValidade;
	}

	public void setData(String data) {
		this.dataValidade = data;
	}
}
