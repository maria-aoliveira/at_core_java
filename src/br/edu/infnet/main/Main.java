package br.edu.infnet.main;

import java.text.ParseException;
import java.util.Scanner;

import br.edu.infnet.errors.IndexError;

public class Main {

	public static void main(String[] args) throws ParseException, IndexError {
		Cadastro cadastro = new Cadastro();
		cadastro.menuCadastrar();
	}
}
