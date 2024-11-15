package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Principal {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Produto> lista = new ArrayList<>();
		
		System.out.print("Entre com o numero de produtos: ");
		int numero = sc.nextInt();
		
		for(int i = 1; i <= numero; i++) {
			System.out.println("Dados do produto #" + i + ":");
			System.out.print("Comum, usado, importado (C/U/I)? ");
			char type = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			if(type == 'c') {
				lista.add(new Produto(nome, preco));
			}
			else if(type == 'u') {
					System.out.print("Data de fabricação (DD/MM/YYYY): ");
					LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					lista.add(new ProdutoUsado(nome, preco, date));
				}
			else {
				System.out.print("Taxa de importação: ");
				double alfandegas = sc.nextDouble();
				lista.add(new ProdutoImportado(nome, preco, alfandegas));
			}
		}
		
		System.out.println();
		System.out.println("Etiquetas de preço:");
		for (Produto produto : lista) {
			System.out.println(produto.etiquetaDePreco());
		}
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
