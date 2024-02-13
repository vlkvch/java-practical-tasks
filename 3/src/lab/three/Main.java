package lab.three;

import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		String action;
		Scanner in = new Scanner(System.in);

		System.out.print("Хотите ввести информацию о студенте? (y/n)\n> ");

		while (!(action = in.next()).equals("n")) {
			System.out.print("Введите ФИО студента:\n> ");
			in.nextLine();
			String fio = in.nextLine();

			System.out.print("Введите группу студента:\n> ");
			String group = in.next();

			System.out.print("Введите оценки студента: [1 2 3 4 5]\n> ");
			in.nextLine();
			String[] grades = in.nextLine().split("\\s+");

			if (grades.length == 5) {
				boolean areCorrect = true;
				byte[] convertedGrades = new byte[grades.length];
				for (byte i = 0; i < convertedGrades.length; i++) {
					convertedGrades[i] = Byte.parseByte(grades[i]);

					if (convertedGrades[i] < 0 || convertedGrades[i] > 10) {
						areCorrect = false;
						System.out.println("[!] Неправильные оценки.");
						break;
					}
				}

				if (areCorrect) {
					Student student = new Student(fio, group, convertedGrades);

					try (BufferedWriter bw = new BufferedWriter(new FileWriter("./txt/info", true))) {
						bw.write(student.getInfo());
						bw.close();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			} else {
				System.out.println("[!] Было введено не 5 оценок.");
			}

			System.out.print("Хотите ввести информацию о студенте? (y/n)\n> ");
		}
		in.close();
	}
}
