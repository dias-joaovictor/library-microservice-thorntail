package br.com.thorntail.resources;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.thorntail.repository.BookRepository;

@Path("/books")
@RequestScoped
public class BookResource {

	
	@Inject
	private BookRepository bookRepository;
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBook(@PathParam("id") Integer id) {
		return Response.ok(bookRepository.findById(id)).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks() {
		return Response.ok(bookRepository.findAll()).build();
	}
	
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response add(Book book) {
//		Integer id = bookManager.add(book);
//		return Response.created(UriBuilder.fromResource(this.getClass()).path(Integer.toString(id)).build()).build();
//	}
	
}
