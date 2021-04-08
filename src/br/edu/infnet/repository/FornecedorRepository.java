package br.edu.infnet.repository;

import java.util.ArrayList;
import br.edu.infnet.model.Fornecedor;
import br.edu.infnet.model.Produto;

public class FornecedorRepository extends Fornecedor{
	
	private static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	private ProdutoRepository produtoRepository = new ProdutoRepository(null, null);
	
	public FornecedorRepository(String nomeFornecedor) {
		super();
	}
	
	public void popularLista() {
		fornecedores.add(new Fornecedor("Extra"));
		fornecedores.add(new Fornecedor("Mundial"));
		fornecedores.add(new Fornecedor("Carrefour"));
		fornecedores.add(new Fornecedor("Supermarket"));
		fornecedores.add(new Fornecedor("Wallmart"));
	}

	public int cadastrarFornecedor(Fornecedor fornecedor) {
		fornecedores.add(fornecedor);
		return fornecedor.getId();	
	}
	
	public void listar(){
		for(Fornecedor item : fornecedores) {
			System.out.println(item.getId() + " " + item.getNomeFornecedor());
		}
	}

	public Fornecedor printarPeloId(int id) {
		boolean result = true;
		for(Fornecedor item : fornecedores) {
			if(item.getId() == id) {
				System.out.println(item.getId() + " " + item.getNomeFornecedor());
				result = true;
				return item;
			}else {
				result = false;
			}
		}
		
		if (!result == true){
		    System.out.println("Nada foi encontrado");
		}	
		return null;
	}
	
	public Fornecedor obterPeloId(int id) {
		boolean result = true;
		for(Fornecedor item : fornecedores) {
			if(item.getId() == id) {
				result = true;
				return item;
			}else {
				result = false;
			}
		}
		
		if (!result == true){
		    System.out.println("Nada foi encontrado");
		}	
		return null;
	}
	
	public void excluirPeloId(int id) {
		boolean result = true;
		for(Fornecedor item : fornecedores) {
			if(item.getId() == id) {
				fornecedores.remove(item);
				result = true;
				listar();
				break;
			}else {
				result = false;
			}
		}			
		if (!result == true){
		    System.out.println("Nada foi encontrado");
		}	
	}
	
	public int imprimirPeloNome(String nome) {
		Fornecedor fornecedor = null;
		if(fornecedores != null && fornecedores.size() > 0) {
			for(Fornecedor item: fornecedores) {
				if(item.getNomeFornecedor().equalsIgnoreCase(nome)) {
					fornecedor = item;
					System.out.println("Fornecedor: ");
					System.out.println(item.getId() + " " + item.getNomeFornecedor());
					break;
				}
			}
		}	
		if(fornecedor != null) {
			return fornecedor.getId();
		}else {
			System.out.println("Fornecedor não existe, cadastrando...");
			int idFornecedor = cadastrarFornecedor(new Fornecedor(nome));
			listar();
			return idFornecedor;
		}
	}
	
	
	
	public void alterarFornecedor(String nomeFornecedor, int idFornecedor) {
		var fornecedorSalvo = obterPeloId(idFornecedor);
		if (fornecedorSalvo == null) {
			System.out.println("Fornecedor não encontrado");
		}else {
			fornecedorSalvo.setNomeFornecedor(nomeFornecedor);
		}
	}
}
