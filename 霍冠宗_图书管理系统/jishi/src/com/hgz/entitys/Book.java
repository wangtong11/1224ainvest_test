	package com.hgz.entitys;

public class Book {
	private int id;
	private String name;
	private String writer;
	private int price;

	public Book(int id, String name, String writer, int price) {
		super();
		this.id = id;
		this.name = name;
		this.writer = writer;
		this.price = price;
	}

	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return this.id+"\t"+this.name+"\t"+this.writer+"\t"+this.price;
}
}
