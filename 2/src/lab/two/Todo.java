package lab.two;

import java.util.ArrayList;
import java.util.Scanner;

class Todo {
	private ArrayList<String> list;

	public Todo() {
		list = new ArrayList<String>();
	}

	public void add(String task) {
		list.add(task);
	}

	public void print() {
		for (byte i = 0; i < list.size(); i++)
			System.out.printf("%d. %s\n", i + 1, list.get(i));
	}

	public void remove(byte index) {
		byte i = index;
		Scanner in = new Scanner(System.in);

		while (i < 1 || i > list.size()) {
			System.out.print("Задачи под таким номером нет. Пожалуйста, повторите ввод:\n> ");
			i = in.nextByte();
		}

		list.remove(i - 1);
	}
}