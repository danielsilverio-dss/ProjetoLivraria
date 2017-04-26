package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_EDITORA")
@SequenceGenerator(name="seqEditora", sequenceName="SQ_TB_EDITORA", allocationSize=1)
public class Editora {
	
	@Id
	@GeneratedValue(generator="seqEditora", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_editora")
	private int id;
	@Column(name="nr_cnpj", nullable=false, length=100)
	private String cnpj;
	@Column(name="nm_editora", nullable=false, length=300)
	private String nome;
	@Column(name="ds_endereco", nullable=true, length=400)
	private String endereco;
	
	@OneToMany(mappedBy="editora", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Livro> livros = new ArrayList<Livro>();
	
	public Editora(){}
	
	public Editora(String cnpj, String nome) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
	}

	public void addLivro(Livro l){
		l.setEditora(this);
		this.livros.add(l);
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	

}
