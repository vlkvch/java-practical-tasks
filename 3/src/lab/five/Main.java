package lab.five;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		String usage = "Доступные команды:\n\n" +
		               "create\tСоздать файл.\n" +
		               "rename\tПереименовать файл.\n" +
		               "write\tЗаписать информацию в файл.\n" +
		               "delete\tУдалить файл.\n" +
		               "q\tВыйти из программы.\n";
		
		String action;
		Scanner in = new Scanner(System.in);
		
		System.out.println(usage);
		System.out.print("> ");
		
		while (!(action = in.next()).equals("q")) {
			String fileName;

			switch (action) {
				case "create":
					System.out.print("Введите название файла, который необходимо создать:\n> ");
					Util.createFile(in.next());
					break;
				case "rename":
					System.out.print("Введите название файла, который необходимо переименовать:\n> ");
					fileName = in.next();

					if (!Util.fileExists(fileName)) {
						System.out.printf("[!] Файл `%s` не существует.\n", fileName);
						break;
					}

					System.out.print("Введите новое название для файла:\n> ");
					Util.renameFile(fileName, in.next());
					break;
				case "write":
					System.out.print("Введите название файла, в который необходимо записать информацию:\n> ");
					fileName = in.next();

					if (!Util.fileExists(fileName)) {
						System.out.printf("[!] Файл `%s` не существует.\n", fileName);
						break;
					}

					System.out.print("Введите информацию:\n> ");
					in.nextLine();
					Util.writeToFile(fileName, in.nextLine());
					break;
				case "delete":
					System.out.print("Введите название файла, который необходимо удалить:\n> ");
					fileName = in.next();

					if (!Util.fileExists(fileName)) {
						System.out.println("[!] Такого файла не существует.");
						break;
					}

					Util.deleteFile(fileName);
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
