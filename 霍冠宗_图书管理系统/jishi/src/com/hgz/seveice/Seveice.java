package com.hgz.seveice;

import java.util.ArrayList;
import java.util.Scanner;

import com.beicai.ui.Ui;
import com.hgz.dao.Dao;
import com.hgz.daoimp.Daoimp;
import com.hgz.entitys.Book;

public class Seveice {
	Scanner input = new Scanner(System.in);
	Ui ui = new Ui();
	Dao da = new Daoimp();

	public void menu() {
		int x = ui.menu();
		switch (x) {
		case 1:
			look();
			break;
		case 2:
			add();
			break;
		case 3:
			del();
			break;
		case 4:
			charger();

			break;
		case 5:
			System.out.println("程序已退出");
			System.exit(0);
			break;

		default:
			System.out.println("输入有误！");
			break;
		}
		menu();
	}

	private void charger() {
		System.out.println("请输入您要修改的图书id");
		int id = input.nextInt();
		System.out.println("请输入您要修改的图书价格");
		int price = input.nextInt();
		boolean x = da.charger(id, price);
		if (x) {
			System.out.println("修改成功");
			return;
		}
		System.out.println("修改失败");

	}

	private void del() {

		System.out.println("请输入您要删除的图书id");
		int id = input.nextInt();
		boolean x = da.del(id);
		if (x) {
			System.out.println("删除成功");
			return;
		}
		System.out.println("删除失败");

	}

	private void add() {
		System.out.println("请输入您要增加的图书名称");
		String name = input.next();
		System.out.println("请输入您要增加的图书作者");
		String writer = input.next();
		System.out.println("请输入您要增加的图书价格");
		int price = input.nextInt();
		Book book = new Book(0, name, writer, price);
		boolean x = da.add(book);
		if (x) {
			System.out.println("增加成功");
			return;
		}
		System.out.println("增加失败");

	}

	private void look() {
		System.out.println("id\t图书名称\t图书作者\t图书价格");
		ArrayList<Book> x = da.findAll();
		for (Book book : x) {
			System.out.println(book);
		}
	}
}
