package com.javalpf323.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * �������ݿ⹤����
 * @author Fife
 * ctrl+shift+o ���ٵ����
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
			System.out.println("�������ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
	}
}
