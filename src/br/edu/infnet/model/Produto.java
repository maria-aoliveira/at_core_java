package br.edu.infnet.model;

import java.util.Calendar;
import java.util.Date;

public class Produto {
	
	private int id;
	private String nome;
//	private Date dataValidade;
	private String dataValidade;
	public static int nextId = 0;
	
	public Produto() {
		super();
	}
	
//	public Produto(String nome, Date dataValidade) {
//		
//		this.id = Produto.nextId;
//		Produto.nextId++;
//		this.nome = nome;
//		this.dataValidade = dataValidade;
//	}
	
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
	
//	public Date getData() {
//		return this.dataValidade;
//	}
//	
//	public void setData(Date data) {
//		this.dataValidade = data;
//	}
	
	
	public String getData() {
		return this.dataValidade;
	}

	public void setData(String data) {
		this.dataValidade = data;
	}
	

}
