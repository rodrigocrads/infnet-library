package br.edu.infnet.library.persistence;

import java.util.List;

public interface Dao<T> {

	void salvar(T entity);

	void atualizar(T entity);

	T getById(Integer id);
	
	List<T> getAll();
	
	void remove(T entity);

}
