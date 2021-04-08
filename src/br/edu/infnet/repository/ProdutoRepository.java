package br.edu.infnet.repository;

import br.edu.infnet.model.Fornecedor;
import br.edu.infnet.model.Produto;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;

public class ProdutoRepository extends Produto{
	
	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public ProdutoRepository(String nome, String dataValidade) {
		super();
	}
	
	public void PopularLista() {
		
		produtos.add(new Produto("Açúcar", converte()));
		produtos.add(new Produto("Sal", converte()));
		produtos.add(new Produto("Arroz", "10/01/2020"));
		produtos.add(new Produto("Feijão", "10/02/2020"));
		produtos.add(new Produto("Nescau", "30/12/2019"));
	}	
				
	public void listar(){
		for(Produto produto : produtos) {
			System.out.println(produto.getId() + " " + produto.getNome() + " " + produto.getData());
		}
	}
	
	public Produto obterId(int id) {
		boolean result = true;
		Produto produto = new Produto();
		for(Produto item : produtos) {
			if (item.getId() == id) {
				produto = item;
				result = true;
				break;
			}else {
				result = false;
			}
		}
		if (!result == true){
		    System.out.println("Nada foi encontrado");
		}
		return produto;
	}
	
	public Produto imprimirId(int id) {
		boolean result = true;
		Produto produto = new Produto();
		for(Produto item : produtos) {
			if (item.getId() == id) {
				produto = item;
				System.out.println(item.getId() + " " + item.getNome() + " " + item.getData());
				result = true;
				break;
			}else {
				result = false;
			}
		}
		if (!result == true){
		    System.out.println("Nada foi encontrado");
		}
		return produto;
	}
	
	
	
	public void alterarProduto(Produto produto, int id){
		Produto produtoSalvo = obterId(id);
		
		produtoSalvo.setNome(produto.getNome());
		produtoSalvo.setData(produto.getData());
		
		listar();
	}
	
	public int cadastrarProduto(Produto produto){
		produtos.add(produto);
		return produto.getId();
	}
	
	public void excluirProduto(int id) {
		boolean result = true;
		for(Produto item : produtos) {
			if (item.getId() == id) {
				produtos.remove(item);
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
	
	public void listarPorData(String data) {
		for(Produto item : produtos) {
			if(item.getData().equals(data)) {
				System.out.println(item.getId() + " " + item.getNome() + " " + item.getData());					
			}			
		}
		if (!produtos.contains(data)) {
			System.out.println("Fim dos resultados");
		}	
	}
	
	
	public int imprimirPorNome(String nomeProduto) {
		Produto produto = null;
		boolean result = true;
		if(produtos != null && produtos.size() > 0) {
			for(Produto item : produtos) {
				if(item.getNome().equalsIgnoreCase(nomeProduto)) {	
					System.out.println(item.getNome() + ": " + Collections.frequency(produtos, 
							new Produto(nomeProduto, converte())));
				//	Collections.frequency(produtos, produto);
					produto = item;
					result = true;
				//	break;
				}else {
					result = false;
				}
			}
			if(result == false) {
				System.out.println("Produto não existe, cadastrando...");
				int idProduto = cadastrarProduto(new Produto(nomeProduto, converte()));
				listar();
				return idProduto;
			}
		}		
		
		if(produto != null) {
			//System.out.println(produto.getId() + " " + produto.getNome() + " " + produto.getData());
			return produto.getId();
		}else {
			int idProduto = cadastrarProduto(new Produto(nomeProduto, converte()));
			return idProduto;
		}
	}
	
	public int buscarPorNome(String nomeProduto) {
		boolean result = true;
		Produto produto = null;
		if(produtos != null && produtos.size() > 0) {
			for(Produto item : produtos) {		
				if(item.getNome().equalsIgnoreCase(nomeProduto)) {
					produto = item;
					result = true;
					break;
				}else {
					result = false;
				}
			}
		}		
		
		if(result == true) {
			System.out.println("Produto encontrado: ");
			System.out.println("Id: " + produto.getId());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Data: " + produto.getData());
			return produto.getId();
		}else {
			int idProduto = cadastrarProduto(new Produto(nomeProduto, converte()));
			return idProduto;
		}
	}
	
	public String converte() {
		Date hoje = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate = dateFormat.format(hoje);  
		return strDate;
	}
}
