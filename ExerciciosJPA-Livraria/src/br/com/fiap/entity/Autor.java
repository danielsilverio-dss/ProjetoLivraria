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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_AUTOR")
@SequenceGenerator(name="seqAutor", sequenceName="SQ_TB_AUTOR", allocationSize=1)
public class Autor {
	
	@Id
	@Column(name="cd_autor")
	private int id;
	@Column(name="nm_autor", nullable=false, length=300)
	private String nome;
	@Column(name="nr_sexo", nullable=false)
	private int sexo;
	@Column(name="ds_sobrenome", nullable=false, length=300)
	private String sobrenome;
	@Column(name="dt_nasc", nullable=true)
	private Calendar dataNascimento;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="TB_AUTOR_LIVRO", 
	joinColumns={@JoinColumn(name="cd_autor")},
	inverseJoinColumns={@JoinColumn(name="isbn")})
	private List<Livro> livros = new ArrayList<Livro>();
	
	public Autor() {
		super();
	}
	
	public Autor(String nome, int sexo, String sobrenome, Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}

	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	

}
