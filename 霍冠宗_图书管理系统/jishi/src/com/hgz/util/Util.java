package com.hgz.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
	static String classPath=null;
	static String url=null;
	static String user=null;
	static String password=null;
	static{
		try {
			InputStream ins=Util.class.getClassLoader().getResourceAsStream("db.properties");
			Properties pr=new Properties();
			pr.load(ins);
			classPath =pr.getProperty("classPath");
			url=pr.getProperty("url");
			user=pr.getProperty("user");
			password=pr.getProperty("password");
			Class.forName(classPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			return null;
		}
	}
	public static void close(ResultSet re,Connection conn,PreparedStatement ps){
		if (re!=null) {
			try {
				re.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
