package com.hgz.dao;

import java.util.ArrayList;

import com.hgz.entitys.Book;

public interface Dao {
	boolean add(Book book);

	boolean del(int id);

	ArrayList<Book> findAll();

	boolean charger(int id, int price);
}
