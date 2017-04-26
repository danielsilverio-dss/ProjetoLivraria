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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_EMPRESTIMO")
@SequenceGenerator(name="seqEmprestimo", sequenceName="SQ_TB_EMPRESTIMO", allocationSize=1)
public class Emprestimo {
	
	@Id
	@GeneratedValue(generator="seqEmprestimo", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_emprestimo")
	private int id;
	@Temporal(TemporalType.DATE)
	@Column(name="dt_emprestimo", nullable=false)
	private Calendar dataEmprestimo;
	@Temporal(TemporalType.DATE)
	@Column(name="dt_retorno", nullable=false)
	private Calendar dataRetorno;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;
	
	@ManyToMany(mappedBy="emprestimos", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Exemplar> exemplares = new ArrayList<Exemplar>();
	
	public Emprestimo(){}
	
	public Emprestimo(Calendar dataEmprestimo, Calendar dataRetorno) {
		super();
		this.dataEmprestimo = dataEmprestimo;
		this.dataRetorno = dataRetorno;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Calendar getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Calendar dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}
	
	
	

}
