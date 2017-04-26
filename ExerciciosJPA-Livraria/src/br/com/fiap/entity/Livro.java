package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_LIVRO")
public class Livro {
	
	@Id
	@Column(name="nr_isbn")
	private int isbn;
	@Column(name="ds_titulo", nullable=false, length=200)
	private String titulo;
	@Column(name="vl_preco", nullable=true)
	private float preco;
	@Column(name="dt_lancamento", nullable=true)
	private Calendar dataLancamento;
	@Column(name="bt_capa", nullable=true)
	private byte[] capa;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="cd_editora")
	private Editora editora;
	
	@OneToMany(mappedBy="livro", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Exemplar> exemplares = new ArrayList<Exemplar>();
	
	@ManyToMany(mappedBy="livros", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Autor> autores = new ArrayList<Autor>();
	
	public Livro() {
		super();
	}
	public Livro(int isbn, String titulo, float preco, Calendar dataLancamento, byte[] capa) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.capa = capa;
	}

	public void addExemplar(Exemplar e){
		e.setLivro(this);
		exemplares.add(e);
	}
	
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public List<Exemplar> getExemplares() {
		return exemplares;
	}
	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}


	public List<Autor> getAutores() {
		return autores;
	}


	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}


	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}
	
	

}
