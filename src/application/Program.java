package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entities.Comentarios;
import entities.Pessoa;
import entities.Postagem;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//		Comentarios c1 = new Comentarios("Have a nice trip");
//		Comentarios c2 = new Comentarios("Have a nice trip");
//		Postagem p1 = new Postagem(sdf.parse("21/06/2020 21:33:21"), "Traveling to new zeland", "Im a going", 12);
//		p1.addComentario(c1);
//		p1.addComentario(c2);
//		
//		
//		

//		
//		System.out.println(p1.toString());

		List<Pessoa> listPessoa = new ArrayList<>();
		List<Postagem> list = new ArrayList<>();

		int n = requestIntInput("Quantas pessoas deseja cadastrar?");

		for (int i = 0; i < n; i++) {
			int id = requestIntInput("Registre um id");
			while (temId(listPessoa, id)) {
				id = requestIntInput("Este id ja existe. Digite um novo id");
			}
			String nomePessoa = requestStringIput("Qual e o seu nome?");
			int idade = requestIntInput("Sua idade");

			Pessoa pessoas = new Pessoa(nomePessoa, id, idade);
			listPessoa.add(pessoas);
		}

		int post = requestIntInput("Quantas postagens deseja fazer");
		for (int i = 0; i <= post; i++) {
			int id = requestIntInput("Digite o id especifico para criar a postagem");
			Pessoa pessoa = listPessoa.stream().filter(x -> x.getId() == id).findFirst().get();

			if (pessoa.getId() == id) {
				System.out.println("Digite a data");
				Date momento = sdf.parse(sc.next());
				String title = requestStringIput("Escreva o titulo");
				String conteudo = requestStringIput("Qual e o conteudo?");
				int likes = requestIntInput("Quantos likes deseja deixar?");
				String comentario = requestStringIput("Deixe seu comentario...");
				Postagem p = new Postagem(momento, title, conteudo, likes);
				Comentarios comentarios = new Comentarios(comentario);
				p.addComentario(comentarios);
				System.out.println(p);

			} else if (pessoa.getId() != id) {
				ShowDialogMensage("Este id nao existe");
			}

		}

//			System.out.println("Digite a data");
//			Date momento = sdf.parse(sc.next());
//			String title = requestStringIput("Escreva o titulo");
//			String conteudo = requestStringIput("Qual e o conteudo?");
//			int likes = requestIntInput("Quantos likes deseja deixar?");
//			String comentario = requestStringIput("Deixe seu comentario...");
//			Postagem p = new Postagem(momento, title, conteudo, likes);
//			Comentarios comentarios = new Comentarios(comentario);
//			p.addComentario(comentarios);
//		ShowDialogMensage(p.toString());

		sc.close();
	}

	private static boolean temId(List<Pessoa> list, int id) {
		Pessoa pessoa = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return pessoa != null;
	}

	private static String requestStringIput(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);
	}

	private static int requestIntInput(String mensagem) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
	}

	private static void ShowDialogMensage(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	private static void ok(String mensagem) {
		JOptionPane.showConfirmDialog(null, mensagem);
	}

	private static String data(String mensagem, Date data) {
		return JOptionPane.showInputDialog(mensagem, data);
	}
}
