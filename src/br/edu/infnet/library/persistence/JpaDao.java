package br.edu.infnet.library.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDao<T> implements Dao<T> {

	protected EntityManager em;
	private Class clazz;
	private String clazzName;

	@SuppressWarnings("rawtypes")
	public JpaDao(Class clazz, String clazzName) {
		super();
		this.clazz = clazz;
		this.clazzName = clazzName;
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("library");
		em = fac.createEntityManager();
	}

	public void salvar(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public void atualizar(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	public T getById(Integer id) {
		return (T) em.find(clazz, id);
	}
	
	public List<T> getAll(){
		return em.createQuery("t FROM " + this.clazzName + " t").getResultList();
	}
	
	public void remove(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}
}
