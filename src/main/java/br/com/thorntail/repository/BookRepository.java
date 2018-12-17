package br.com.thorntail.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.thorntail.model.Book;

@ApplicationScoped
public class BookRepository {

	@Inject
	private EntityManager entityManager;
	
	public List<Book> findAll(){
		String consulta = "SELECT book FROM Book book";
		return entityManager.createQuery(consulta, Book.class).getResultList();
	}
	
	public Book findById(int id){
		String consulta = "SELECT book FROM Book book where book.id = :id";
		return entityManager.createQuery(consulta, Book.class).setParameter("id", id).getSingleResult();
	}
	
	
}
