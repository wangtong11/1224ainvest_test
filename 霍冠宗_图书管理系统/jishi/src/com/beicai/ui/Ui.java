package com.beicai.ui;

import java.util.Scanner;

public class Ui {
	Scanner input = new Scanner(System.in);

	public int menu() {
		System.out.println("1.查看所有图书");
		System.out.println("2.增加一部图书");
		System.out.println("3.删除一部图书");
		System.out.println("4.修改图书价格");
		System.out.println("5.退出程序");
		int choose = input.nextInt();
		return choose;
	}
}
