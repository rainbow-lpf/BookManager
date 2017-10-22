package com.javalpf323.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javalpf323.model.User;

public class UserDao {

	/**
	 * µÇÂ¼ÑéÖ¤²Ù×÷
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User Login(Connection conn,User user) throws SQLException {
		  User result=null;
		 String sql="select * from t_user where userName=? and password=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, user.getUserName());
		  ps.setString(2,user.getPassword());
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) {
			  result=new User();
			  result.setId(rs.getInt("id"));
			  result.setUserName(rs.getString("userName"));
			  result.setPassword(rs.getString("password"));
		  }		  
		return result;
	}
}
