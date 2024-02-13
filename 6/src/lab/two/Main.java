package lab.two;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		String usage = "Доступные команды:\n\n" +
		               "add\tДобавить задачу.\n" +
		               "print\tВывести текущие задачи.\n" +
		               "remove\tУбрать задачу под номером i.\n" +
		               "q\tВыйти из программы.\n";

		Todo list = new Todo();
		String action;
		Scanner in = new Scanner(System.in);
		
		System.out.println(usage);
		System.out.print("> ");
		
		while (!(action = in.next()).equals("q")) {
			switch (action) {
				case "add":
					System.out.print("Какую задачу добавить?\n> ");
					in.nextLine();
					list.add(in.nextLine());
					break;
				case "print":
					list.print();
					break;
				case "remove":
					System.out.print("Задачу под каким номером нужно убрать?\n> ");
					list.remove(in.nextByte());
					break;
				default:
					System.out.println("[!] Такой команды нет — пожалуйста, повторите ввод.");
					break;
			}
			System.out.print("> ");
		}
		in.close();
	}
}