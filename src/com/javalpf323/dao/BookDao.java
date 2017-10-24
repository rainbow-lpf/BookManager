package com.javalpf323.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javalpf323.model.Book;
import com.javalpf323.util.StringUtil;

public class BookDao {
	
	/**
	 * 添加书籍
	 * @param conn
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public int addBook(Connection conn,Book book) throws SQLException {
		String sql="insert into t_books values(null,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getSex());
		ps.setFloat(4, book.getPrice());
		ps.setString(5, book.getBookDesc());
		ps.setInt(6, book.getBookTypeId());
		return ps.executeUpdate();	
	}
	
	/**
	 * 更新书籍
	 * @param conn
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public int updateBook(Connection conn, Book book) throws SQLException {
		String sql="update t_books set bookName=?, author=?, sex=?, price=?, bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getSex());
		ps.setFloat(4, book.getPrice());
		ps.setString(5, book.getBookDesc());
		ps.setInt(6, book.getBookTypeId());
		ps.setInt(7, book.getId());		
		return ps.executeUpdate();
	}
	
	/**
	 *删除书籍 
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int deleteBook(Connection conn,int id)throws SQLException {
		String sql="delete from t_books where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}
	
	/**
	 * 查询图书
	 * @param conn
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getBookList(Connection conn,Book book) throws SQLException {
		String sql="select * from t_books b,t_bookType bt where b.bookTypeId=bt.id";
		StringBuilder sb=new StringBuilder(sql);
		if(StringUtil.IsNotEmpty(book.getBookName())) {
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.IsNotEmpty(book.getAuthor())) {
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=-1) {
			sb.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		ResultSet rs=conn.prepareStatement(sb.toString()).executeQuery();
		return rs;

	}
}
