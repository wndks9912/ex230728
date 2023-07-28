package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDAOInter;
import vo.BookVO;

@Service
public class BookService {
	
	@Autowired
	BookDAOInter dao;

	public int insert(BookVO book) {
		return dao.insert(book);
	}
	
	public List<BookVO> findAll() {
		return dao.findAll();
	}
	
	public BookVO findOneById(int id) {
		return dao.findOneById(id);
	}
	
	public List<BookVO> searchFind(String search) {
		return dao.searchFind(search);
	}

	public int update(int id, BookVO book) {
		return dao.update(id, book);
	}

	public int delete(int id) {
		return dao.delete(id);
	}
}
