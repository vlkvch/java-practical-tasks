package lab.one;

import java.io.FileWriter;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		String input;
		Scanner in = new Scanner(System.in);

		try (FileWriter fw = new FileWriter("./txt/input")) {
			System.out.print("> ");

			while (!(input = in.nextLine()).equals("q")) {
				fw.write(input + "\n");
				System.out.print("> ");
			}

			fw.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		in.close();
	}
}
