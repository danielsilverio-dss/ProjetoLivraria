package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AutorDAO;
import br.com.fiap.dao.EditoraDAO;
import br.com.fiap.dao.EmprestimoDAO;
import br.com.fiap.dao.ExemplarDAO;
import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.impl.AutorDAOImpl;
import br.com.fiap.dao.impl.EditoraDAOImpl;
import br.com.fiap.dao.impl.EmprestimoDAOImpl;
import br.com.fiap.dao.impl.ExemplarDAOImpl;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.dao.impl.UsuarioDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Emprestimo;
import br.com.fiap.entity.Exemplar;
import br.com.fiap.entity.Livro;
import br.com.fiap.entity.Situacao;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TestesDAO {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		/*
		 * 
		 * 		Exercicio 1
		 * 
		 */
		
		AutorDAO aDAO = new AutorDAOImpl(em);
		Autor a = new Autor("Daniel", 1, "Silverio", new GregorianCalendar(28,8,1995));
		aDAO.cadastrar(a);
		
		try {
			aDAO.commit();
		} catch (CommitErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LivroDAO lDAO = new LivroDAOImpl(em);
		Livro l = new Livro(1234, "A Lenda", 80, new GregorianCalendar(1,1,2018), null);
		lDAO.cadastrar(l);
		
		try {
			lDAO.commit();
		} catch (CommitErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EditoraDAO eDAO = new EditoraDAOImpl(em);
		Editora e = new Editora("123", "Somagraf");
		
		eDAO.cadastrar(e);
		
		try {
			eDAO.commit();
		} catch (CommitErrorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*
		 * 
		 * 	Exercicio 2
		 * 
		 * 
		 */
		
		ExemplarDAO exDAO = new ExemplarDAOImpl(em);
		Exemplar ex = new Exemplar(new GregorianCalendar(20, Calendar.JANUARY, 2017), Situacao.Disponivel);
		exDAO.cadastrar(ex);
		
		try {
			exDAO.commit();
		} catch (CommitErrorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		EmprestimoDAO empDAO = new EmprestimoDAOImpl(em);
		Emprestimo emp = new Emprestimo(new GregorianCalendar(21, Calendar.JANUARY, 2017), new GregorianCalendar(28, Calendar.JANUARY, 2017));
		empDAO.cadastrar(emp);
		
		try {
			empDAO.commit();
		} catch (CommitErrorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
				
		UsuarioDAO uDAO = new UsuarioDAOImpl(em);
		Usuario u = new Usuario("fulano123", "Fulano", "da Silva", "12345"); 
		uDAO.cadastrar(u);
		
		try {
			uDAO.commit();
		} catch (CommitErrorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		em.close();
		System.exit(0);
		
		
		
	}

}
