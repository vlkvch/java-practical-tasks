package lab.two;

import java.io.*;

class Main {
	public static void main(String[] args) {
		File file = new File("./txt/", "text");
		byte lines = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while (br.readLine() != null)
				lines++;
			br.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		if (lines < 3) {
			System.out.println("[!] В тексте меньше 3 строк.");
			return;
		}

		File tmpFile = new File("./txt/", "tmp");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file));
		     BufferedWriter bw = new BufferedWriter(new FileWriter(tmpFile))) {

			while (lines > 3) {
				bw.write(br.readLine() + "\n");
				bw.flush();
				lines--;
			}

			bw.close();
			br.close();

			tmpFile.renameTo(file);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
