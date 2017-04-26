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

public class TesteRelacionamentos {
	
	public static void main(String[] args) {
		
		Autor a = new Autor("Daniel",
				1,
				"Silverio",
				new GregorianCalendar(28,8,1995));
		
		Livro l = new Livro(1234,
				"A Lenda",
				80,
				new GregorianCalendar(1,1,2018),
				null);
		
		Editora ed = new Editora("123",
				"Somagraf");
		
		ed.addLivro(l);
		
		Exemplar ex = new Exemplar(new GregorianCalendar(20,
				Calendar.JANUARY, 2017),
				Situacao.Disponivel);
		
		l.addExemplar(ex);
		
		Emprestimo emp = new Emprestimo(new GregorianCalendar(21,
				Calendar.JANUARY, 2017),
				new GregorianCalendar(28,
						Calendar.JANUARY,
						2017));
		
		Usuario u = new Usuario("fulano123",
				"Fulano",
				"da Silva",
				"12345"); 
		
		u.addEmprestimo(emp);

		
		
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		AutorDAO aDAO = new AutorDAOImpl(em);
		aDAO.cadastrar(a);
		try {
			aDAO.commit();
		} catch (CommitErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EditoraDAO edDAO = new EditoraDAOImpl(em);
		edDAO.cadastrar(ed);
		try {
			edDAO.commit();
		} catch (CommitErrorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		UsuarioDAO uDAO = new UsuarioDAOImpl(em);
		uDAO.cadastrar(u);
		try {
			uDAO.commit();
		} catch (CommitErrorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		LivroDAO lDAO = new LivroDAOImpl(em);
		Livro l2 = lDAO.buscar(ed.getLivros().get(0).getIsbn());
		System.out.println("Livro");
		System.out.println(l2.getIsbn() + " " + l2.getTitulo());

		ExemplarDAO exDAO = new ExemplarDAOImpl(em);
		Exemplar ex2 = exDAO.buscar(l2.getExemplares().get(0).getId());
		System.out.println("Exemplar");
		System.out.println(ex2.getId() + " ");
		
		EmprestimoDAO empDAO = new EmprestimoDAOImpl(em);
		Emprestimo emp2 = empDAO.buscar(u.getEmprestimos().get(0).getId());
		System.out.println("Emprestimo");
		System.out.println(emp2.getId());
				
		 
		
		em.close();
		System.exit(0);
		
	}

}
