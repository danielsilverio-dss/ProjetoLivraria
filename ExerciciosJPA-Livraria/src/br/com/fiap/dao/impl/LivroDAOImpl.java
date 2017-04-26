package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.entity.Livro;

public class LivroDAOImpl extends GenericDAOImpl<Livro, Integer> implements LivroDAO{

	public LivroDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
