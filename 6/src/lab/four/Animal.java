package lab.four;

import java.util.Scanner;

abstract class Animal {
	private String name, species;

	public String getName() {
		return name;
	}

	public String getSpecies() {
		return species;
	}

	public abstract String move();
	public abstract String sound();


	public Animal(String name, String species) {
		this.name = name;
		this.species = species;
	}


	public void printAction() {
		byte action;

		Scanner in = new Scanner(System.in);

		System.out.print("Действие для животного:\n> ");

		while ((action = in.nextByte()) != 0) {
			switch(action) {
				case 1:
					System.out.println(this.move());
					break;
				case 2:
					System.out.println(this.sound());
					break;
				case 3:
					System.out.printf("Кличка: %s\n", this.getName());
					break;
				default:
					System.out.println("[!] Такого действия нет.");
					break;
			}

			System.out.print("Действие для животного:\n> ");
		}
		in.close();
	}
}
