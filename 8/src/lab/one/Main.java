package lab.one;

import java.util.Scanner;

interface Comparable {
	String longestString(String x, String y);
}

class Main {
	public static void main(String[] args) {
		Comparable str = (x, y) -> {
			if (x.length() == y.length())
				return "Равны";
			else
				return x.length() > y.length() ? x : y; };

		Scanner in = new Scanner(System.in);

		System.out.print("Введите первую строку:\n> ");
		String x = in.nextLine();
		System.out.print("Введите вторую строку:\n> ");
		String y = in.nextLine();
		in.close();

		System.out.printf("Наиболее длинная строка — \"%s\".\n", str.longestString(x, y));
	}
}
