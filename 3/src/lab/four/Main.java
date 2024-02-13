package lab.four;

import java.io.*;

class Main {
	public static void main(String[] args) {
		File file = new File("./txt/", "java");
		File tmpFile = new File("./txt/", "tmp");

		try (BufferedReader br = new BufferedReader(new FileReader(file));
		     BufferedWriter bw = new BufferedWriter(new FileWriter(tmpFile))) {

			String line;
			
			while ((line = br.readLine()) != null) {
				String[] sentences = line.split("(?<=[.!?])(\\s*)");

				for (byte i = 0; i < sentences.length; i++) {
					if (Character.isLowerCase(sentences[i].charAt(0)))
						sentences[i] = Character.toUpperCase(sentences[i].charAt(0)) + sentences[i].substring(1);

					sentences[i] += "\s";
				}

				if (sentences.length > 5) {
					for (byte i = 4; i < sentences.length; i += 5)
						sentences[i] += "\n";
				}

				for (String s : sentences)
					bw.write(s);
			}

			bw.close();
			br.close();

			tmpFile.renameTo(file);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
