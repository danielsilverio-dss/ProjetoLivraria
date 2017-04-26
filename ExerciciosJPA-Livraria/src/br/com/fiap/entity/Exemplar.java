package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_EXEMPLAR")
@SequenceGenerator(name="seqExemplar", sequenceName="SQ_TB_EXEMPLAR", allocationSize=1)
public class Exemplar {
	
	@Id
	@GeneratedValue(generator="seqExemplar", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_exemplar")
	private int id;
	@Column(name="dt_exemplar")
	private Calendar dtExemplar;
	@Column(name="nr_situacao")
	private Situacao situacao;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="cd_livro")
	private Livro livro;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="TB_EMPRESTIMO_EXEMPLAR",
	joinColumns={@JoinColumn(name="cd_exemplar")},
	inverseJoinColumns={@JoinColumn(name="cd_emprestimo")}
	)
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	
	public Exemplar(){}
	
	public Exemplar(Calendar dtExemplar, Situacao situacao) {
		super();
		this.dtExemplar = dtExemplar;
		this.situacao = situacao;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDtExemplar() {
		return dtExemplar;
	}

	public void setDtExemplar(Calendar dtExemplar) {
		this.dtExemplar = dtExemplar;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	

}
