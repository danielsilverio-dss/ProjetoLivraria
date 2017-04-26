package br.com.fiap.dao;

import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.exception.IdNotFoundException;

public interface GenericDAO<T, K> {
	
	void cadastrar(T entidade);
	T buscar(K id);
	void alterar(T entidade);
	void excluir(K id) throws IdNotFoundException;	
	void commit() throws CommitErrorException;

}
