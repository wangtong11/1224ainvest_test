package com.hgz.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hgz.dao.Dao;
import com.hgz.entitys.Book;
import com.hgz.util.Util;

public class Daoimp implements Dao {

	@Override
	public boolean add(Book book) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet re=null;
		conn=Util.getConnection();
		String sql="insert into book values(0,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, book.getName());
			ps.setString(2, book.getWriter());
			ps.setInt(3, book.getPrice());
			int x = ps.executeUpdate();
			Util.close(re, conn, ps);;
			return x>0?true:false;
		} catch (SQLException e) {
			Util.close(re, conn, ps);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean del(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet re=null;
		conn=Util.getConnection();
		String sql="delete from book where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int x = ps.executeUpdate();
			Util.close(re, conn, ps);;
			return x>0?true:false;
		} catch (SQLException e) {
			Util.close(re, conn, ps);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean charger(int id,int price) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet re=null;
		conn=Util.getConnection();
		String sql="update book set price=? where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,price);
			ps.setInt(2,id);
			int x = ps.executeUpdate();
			Util.close(re, conn, ps);;
			return x>0?true:false;
		} catch (SQLException e) {
			Util.close(re, conn, ps);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public ArrayList<Book> findAll() {
		ArrayList<Book> bo=new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet re=null;
		conn=Util.getConnection();
		String sql="select * from book";
		try {
			ps=conn.prepareStatement(sql);
			 re = ps.executeQuery();
			 
			 while(re.next()){
				 int id=re.getInt("id");
				 String name=re.getString("name");
				 String writer =re.getString("writer");
				 int price= re.getInt("price");
				 bo.add(new Book(id, name, writer, price));
			 }
			 return bo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}

}
