package DB;

import java.util.TreeMap;

public class BookDAO extends DBConnection{

	public BookDAO() {
		
	}

	public TreeMap<Integer, BookDTO> bookSelect(String field, String input){
		TreeMap<Integer, BookDTO> booklist = new TreeMap<Integer, BookDTO>();
		
		try {
			getConnection();
			
			sql = "select bn, title, author, price, pub_date, page, publisher from bookinfo ";
			
			if(field != null) sql += "where " + field + " like ?";
			
			pstmt = conn.prepareStatement(sql);
			
			if(field != null) pstmt.setString(1, "%" + input + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO bd = new BookDTO();
				bd.setBn(rs.getInt(1));
				bd.setTitle(rs.getString(2));
				bd.setAuthor(rs.getString(3));
				bd.setPrice(rs.getInt(4));
				bd.setPub_date(rs.getString(5));
				bd.setPage(rs.getInt(6));
				bd.setPublisher(rs.getString(7));
				
				booklist.put(bd.getBn(), bd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose();
		}
		return booklist;
	}
	
	public int bookInsert(BookDTO bd) {
		int result = 0;
		try {
			getConnection();
			
			sql = "insert into bookinfo(bn, title, author, price, pub_date, page, publisher) values(?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bd.getBn());
			pstmt.setString(2, bd.getTitle());
			pstmt.setString(3, bd.getAuthor());
			pstmt.setInt(4, bd.getPrice());
			pstmt.setString(5, bd.getPub_date());
			pstmt.setInt(6, bd.getPage());
			pstmt.setString(7, bd.getPublisher());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose();
		}
		
		return result;
	}
	
	public int bookUpdate(int bn, String field, String input) {
		int result = 0;
		try {
			getConnection();
			
			sql = "update bookinfo set " + field + " = ? where bn = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input);
			pstmt.setInt(2, bn);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose();
		}

		return result;
	}
	
	public int bookDelete(int bn) {
		int result = 0;
		try {
			getConnection();
			
			sql = "delete from bookinfo where bn = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bn);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose();
		}

		return result;
	}
}
