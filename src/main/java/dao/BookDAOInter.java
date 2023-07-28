package dao;

import java.util.List;
import vo.BookVO;

public interface BookDAOInter {
    public int insert(BookVO book);
    public List<BookVO> findAll();
    public BookVO findOneById(int id);
    public List<BookVO> searchFind(String search);
    public int update(int id, BookVO book);
    public int delete(int id);
	int update(BookVO book);
}
