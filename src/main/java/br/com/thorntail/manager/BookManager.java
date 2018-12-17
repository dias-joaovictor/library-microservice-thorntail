package br.com.thorntail.manager;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import br.com.thorntail.model.Book;

@ApplicationScoped
public class BookManager {
	
	private ConcurrentMap<Integer, Book> inMemoryStore = new ConcurrentHashMap<>();
	private int bookSequence = 0;
	
	
	public BookManager() {
		Book book = new Book();
		book.setId(++bookSequence);
		book.setAuthor("Dias");
		book.setIsbn("122211isbn");
		book.setName("O livro");
		book.setPages(234);
		
		inMemoryStore.put(bookSequence, book);
	}
	
	public Integer add(Book book) {
		book.setId(++bookSequence);
		inMemoryStore.put(book.getId(), book);
		return book.getId();
	}
	
	public Book getBookById(Integer id) {
		return inMemoryStore.get(id);
	}
	
	public List<Book> findAll(){
		return (List<Book>) inMemoryStore.values().stream().collect(Collectors.toList());
	}
	
	
	

}
