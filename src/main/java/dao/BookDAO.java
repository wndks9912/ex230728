package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import vo.BookVO;

@Repository
public class BookDAO implements BookDAOInter {
    Connection conn;
    PreparedStatement ps;

    public BookDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insert(BookVO book) {
        try {
            String sql = "insert into book values(book_idx_seq.nextval,?,?,?)";
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, book.getName());
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getPrice());
            
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<BookVO> findAll() {
        try {
            String sql = "select * from book order by idx desc";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            List<BookVO> list = new ArrayList<BookVO>();
            
            while(rs.next()) {
                list.add(new BookVO(rs.getInt("idx"), rs.getString("name"), rs.getString("title"), rs.getInt("price")));
            }
            rs.close();
            ps.close();
            return list;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BookVO findOneById(int idx) {
        try {
            String sql = "select * from book where idx=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idx);
            ResultSet rs = ps.executeQuery();
            
            BookVO book = null;
            
            if(rs.next()) {
                book = new BookVO(rs.getInt("idx"), rs.getString("name"), rs.getString("title"), rs.getInt("price"));
            }
            rs.close();
            ps.close();
            return book;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<BookVO> searchFind(String search) {
        try {
            String sql = "select * from book where name like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ResultSet rs = ps.executeQuery();
            
            List<BookVO> list = new ArrayList<BookVO>();
            BookVO book = null;
            
            while(rs.next()) {
                book = new BookVO(rs.getInt("idx"), rs.getString("name"), rs.getString("title"), rs.getInt("price"));
                list.add(book);
            }
            rs.close();
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(BookVO book) {
        try {
            String sql = "update book set name=?, title=?, price=? where idx=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getPrice());
            ps.setInt(4, book.getIdx());

            int result = ps.executeUpdate();
            ps.close();
            return result;            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int idx) {
        try {
            String sql = "delete from book where idx=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idx);
            
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

	@Override
	public int update(int id, BookVO book) {
		// TODO Auto-generated method stub
		return 0;
	}
}
