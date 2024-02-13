package lab.five;

import java.io.*;

class Util {
	static boolean fileExists(String fileName) {
		File f = new File("./txt/", fileName);
		return f.exists();
	}

	static void createFile(String fileName) {
		File f = new File("./txt/", fileName);
		
		try {
			boolean created = f.createNewFile();
			
			if (created)
				System.out.println("Файл был создан.");
			else
				System.out.printf("[*] Файл `%s` уже существует.\n", fileName);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void renameFile(String fileName, String newFileName) {
		File f = new File("./txt/", fileName);
		File newFile = new File("./txt/", newFileName);

		f.renameTo(newFile);
	}

	static void writeToFile(String fileName, String text) {
		File f = new File("./txt/", fileName);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
			bw.write(text);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void deleteFile(String fileName) {
		File f = new File("./txt/", fileName);
		
		try {
			boolean deleted = f.delete();

			if (deleted)
				System.out.println("Файл был удален.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
