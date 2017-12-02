package br.edu.infnet.library.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.infnet.library.model.Books;
import br.edu.infnet.library.persistence.BooksDao;

@Path("/books")
public class BooksController {
	
private static BooksDao booksDao;
	
	public BooksController() {
		booksDao = new BooksDao();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Books> getTodos(){
		return booksDao.getAll();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Books book){
		booksDao.salvar(book);
		return Response.status(Response.Status.CREATED).entity(book).build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Books book, @PathParam("id") Integer id){
		book.setId(id);
		booksDao.atualizar(book);
		return Response.status(Response.Status.OK).entity(book).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(Books book, @PathParam("id") Integer id) {
		book.setId(id);
		booksDao.remove(book);
		return Response.status(Response.Status.OK).build();
	}
	
}
