package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Postagem{

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date momento;
	private String title;
	private String conteudo;
	private Integer likes;
	
	private List<Comentarios> comentarios = new ArrayList<>();
	private Pessoa pessoa;

	
	public Postagem() {
	}

	public Postagem(Date momento, String title, String conteudo, Integer likes) {
		this.momento = momento;
		this.title = title;
		this.conteudo = conteudo;
		this.likes = likes;
	}


	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void addComentario(Comentarios comentario) {
		comentarios.add(comentario);
	}

	public void removerComentario(Comentarios comentario) {
		comentarios.add(comentario);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titulo " + title + "\n");
		sb.append(likes);
		sb.append(" Likes - Data ");
		sb.append(sdf.format(momento) + " \n");
		sb.append("Conteudo " + conteudo + "\n");
		sb.append("Comentarios : ");
		for (Comentarios c : comentarios) {
			sb.append(c.getText() + "\n");
		}
		sb.append("Nome " + pessoa.getNome());
		return sb.toString();
	}
}
