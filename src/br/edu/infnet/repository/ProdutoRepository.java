package br.edu.infnet.repository;

import br.edu.infnet.model.Produto;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;

public class ProdutoRepository extends Produto{
	
	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public ProdutoRepository(String nome, String dataValidade) {
		super();
	}
	
	public void PopularLista() {
//		Date hoje = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
//		String strDate = dateFormat.format(hoje);  
		
		produtos.add(new Produto("Açúcar", converte()));
		produtos.add(new Produto("Sal", converte()));
		produtos.add(new Produto("Arroz", "10/01/2020"));
		produtos.add(new Produto("Feijão", "10/02/2020"));
		produtos.add(new Produto("Nescau", "30/12/2019"));
		produtos.add(new Produto("Miojo", converte()));
	}	
			
			
	public void listar(){
		for(var produto : produtos) {
			System.out.println(produto.getId() + " " + produto.getNome() + " " + produto.getData());
		}
	}
	
	public Produto obterId(int id) {
		Produto produto = new Produto();
		for(var item : produtos) {
			if (item.getId() == id) {
				produto = item;
				System.out.println(item.getId() + " " + item.getNome() + " " + item.getData());
				break;
			}
		}
		return produto;
	}
	
	public void alterarProduto(Produto produto, int id) {
		Produto produtoSalvo = obterId(id);
		
		produtoSalvo.setNome(produto.getNome());
		produtoSalvo.setData(produto.getData());
		
//		listar();
	}
	
	public void cadastrarProduto(Produto produto){
		produtos.add(produto);
		listar();
	}
	
	public void excluirProduto(int id) {
		for(var item : produtos) {
			if (item.getId() == id) {
				produtos.remove(item);
				break;
			}
		}
		
		listar();
	}
	
	public void listarPorData(String data) throws ParseException {
//		Date hoje = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
//		String strDate = dateFormat.format(hoje);  
	
		converte();	
		for(var item : produtos) {
			if(item.getData().equals(data)) {
				System.out.println(item.getId() + " " + item.getNome() + " " + item.getData());
				break;
			}
		}	
		
		listar();
	}
	
	public String converte() {
		Date hoje = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate = dateFormat.format(hoje);  
		return strDate;
	}
}
