package lab.four;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		String animals = "Животные:\n\n" +
		                 "1\tКот.\n" + 
		                 "2\tПтица.\n" +
		                 "3\tРыбка.\n";

		Scanner in = new Scanner(System.in);

		System.out.println(animals);
		System.out.print("Выберите животное:\n> ");
		byte animal = in.nextByte();

		if (animal < 1 || animal > 3) {
			System.out.println("[!] Такого животного нет.");
			return;
		}

		System.out.print("Введите кличку животного:\n> ");
		String name = in.next();
		System.out.print("Введите вид:\n> ");
		String species = in.next();

		String usage = "Доступные команды:\n\n" +
		               "1\tБегать/летать/плавать.\n" +
		               "2\tИздать звук.\n" +
		               "3\tВывести кличку.\n" +
		               "0\tВыйти.\n";

		System.out.println(usage);

		switch (animal) {
			case 1:
				Cat c = new Cat(name, species);
				c.printAction();
				break;
			case 2:
				Bird b = new Bird(name, species);
				b.printAction();
				break;
			case 3:
				Fish f = new Fish(name, species);
				f.printAction();
				break;
		}
		in.close();
	}
}
