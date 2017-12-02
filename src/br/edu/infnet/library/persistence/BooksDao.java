package br.edu.infnet.library.persistence;

import br.edu.infnet.library.model.Books;

public class BooksDao extends JpaDao<Books>{

	public BooksDao() {
		super(Books.class, "Books");
	}

}
