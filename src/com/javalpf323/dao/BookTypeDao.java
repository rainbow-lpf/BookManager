package com.javalpf323.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javalpf323.model.BookType;
import com.javalpf323.util.DbUtil;
import com.javalpf323.util.StringUtil;


public class BookTypeDao {
	
	/**
	 * 添加图书类别
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws SQLException
	 */
	public int AddBookType(Connection conn,BookType bookType) throws SQLException {
		String sql="insert into t_bookType values(null,?,?)";
	    PreparedStatement ps=conn.prepareStatement(sql);
	    ps.setString(1,bookType.getBookTypeName());
	    ps.setString(2, bookType.getBookDesc());	    
		return ps.executeUpdate();
	}
	
	/**
	 * 返回结果集
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws SQLException
	 */
	public ResultSet GetBookTypeList(Connection conn,BookType bookType) throws SQLException {
		StringBuilder sb=new StringBuilder();
		String sql="select * from t_bookType";
		sb.append(sql);
		if(!StringUtil.IsEmpty(bookType.getBookTypeName())) {
			sb.append(" and  bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement ps=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return ps.executeQuery();
	}
	
	public int UpdateBookType(Connection conn,BookType bookType) throws SQLException {
		String sql="update t_booktype set bookTypeName=?, bookDesc=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bookType.getBookTypeName());
			ps.setString(2, bookType.getBookDesc());
			ps.setInt(3, bookType.getId());
			return ps.executeUpdate();
	}
	
	public int DeleteBookType(Connection conn,int id) throws SQLException {
		String sql="delete from t_booktype where id=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}
}
