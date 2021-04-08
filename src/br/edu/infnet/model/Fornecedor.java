package br.edu.infnet.model;

public class Fornecedor {

	private int id;
	private String nomeFornecedor;
	public static int nextId = 1;

	public Fornecedor() {
		super();
	}

	public Fornecedor(String nomeFornecedor) {
		this.id = Fornecedor.nextId;
		Fornecedor.nextId++;
		this.nomeFornecedor = nomeFornecedor;
	}

	public int getId() {
		return this.id;
	}

	public String getNomeFornecedor() {
		return this.nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public void setId(int id) {
		this.id = id;
	}
}
