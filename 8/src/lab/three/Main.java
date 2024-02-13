package lab.three;

import java.util.Scanner;

interface Equatable {
	double discriminant(double a, double b, double c);
}

class Main {
	public static void main(String[] args) {
		Equatable eq = (a, b, c) -> { return b * b - 4 * a * c; };

		Scanner in = new Scanner(System.in);

		System.out.print("Введите число a:\n> ");
		double a = in.nextDouble();
		System.out.print("Введите  число b:\n> ");
		double b = in.nextDouble();
		System.out.print("Введите число c:\n> ");
		double c = in.nextDouble();
		in.close();

		System.out.printf("Дискриминант равен %f.\n", eq.discriminant(a, b, c));
	}
}
