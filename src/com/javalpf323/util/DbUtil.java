package com.javalpf323.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 操作数据库工具类
 * @author Fife
 * ctrl+shift+o 快速导入包
 */
public class DbUtil {
	
	private static String dbUrl="jdbc:mysql://localhost:3306/t_book";
	private static String userName="root";
	private static String password="323323";
	private static String dbDriver="com.mysql.jdbc.Driver";
	
	/*private static String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=t_book";
	private static String userName="sa";
	private static String password="323323";
	private static String dbDriver="com.sqlserver.jdbc.SQLServerDriver";
	*/
	public static Connection getConnection() throws Exception
	{
		Class.forName(dbDriver);
	    Connection conn=DriverManager.getConnection(dbUrl, userName, password);
		return conn;
	}
	
	public static  void CloseConnection(Connection conn) throws SQLException 
	{
		if(conn!=null) {
			conn.close();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			DbUtil.getConnection();
			System.out.println("数据连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库链接失败");
		}
	}
}
