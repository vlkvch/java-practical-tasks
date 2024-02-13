package lab.one;

import java.lang.Thread;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Введите время таймера (сек.):\n> ");
		byte seconds = in.nextByte();
		in.close();

		long start = System.currentTimeMillis() + seconds * 1000;

		while (start > System.currentTimeMillis()) {
			System.out.printf("%3d\r", (start - System.currentTimeMillis()) / 1000);
			try {
				Thread.sleep(100);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("Время вышло!");
	}
}
