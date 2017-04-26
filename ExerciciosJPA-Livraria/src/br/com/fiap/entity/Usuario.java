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
@Table(name="TB_USUARIO")
@SequenceGenerator(name="seqUsuario", sequenceName="SQ_TB_USUARIO", allocationSize=1)
public class Usuario {
	
	@Id
	@GeneratedValue(generator="seqUsuario", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_usuario")
	private int id;
	@Column(name="ds_nome_usuario", length=300 , nullable=false)
	private String nomeUsuario;
	@Column(name="ds_nome", length=300 , nullable=false)
	private String nome;
	@Column(name="ds_sobrenome", length=300 , nullable=true)
	private String sobrenome;
	@Column(name="ds_cpf", length=20 , nullable=false)
	private String cpf;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	
	
	
	public Usuario(){}

	public Usuario(String nomeUsuario, String nome, String sobrenome, String cpf) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}
	
	public void addEmprestimo(Emprestimo e){
		e.setUsuario(this);
		emprestimos.add(e);
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
