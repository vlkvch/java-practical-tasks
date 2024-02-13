package lab.three;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Введите сумму в BYN:\n> ");
		double sum = in.nextDouble();

		if (sum < 0) {
			System.out.println("[!] Сумма меньше нуля.");
			return;
		}
		
		Converter conv = new Converter(sum);

		in.close();

		String[] currencies = new String[]{"USD", "RUB", "EUR", "UAH"};

		for (String c : currencies)
			System.out.printf("%s: %f\n", c, conv.convertTo(c));
	}
}
