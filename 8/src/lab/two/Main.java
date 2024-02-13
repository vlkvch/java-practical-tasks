package lab.two;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.HashMap;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Введите пароль:\n> ");
		String passwd = in.next();
		in.close();

		if (passwd.length() != 8) {
			System.out.println("[!] Длина пароля не равна 8 символам.");
			// return;
		}

		HashMap<String, String> regex = new HashMap<String, String>();
		regex.put("\\w[^\\d]", "В пароле нет букв.");
		regex.put("\\d", "В пароле нет цифр.");
		regex.put("\\p{Punct}", "В пароле нет специальных символов.");
		regex.put("[\\*\\-#]", "Допустимые специальные символы: *, -, #.");

		boolean err = false;

		for (String k : regex.keySet()) {
			Pattern p = Pattern.compile(k);
			Matcher m = p.matcher(passwd);

			if (!m.find()) {
				System.out.println("[!] " + regex.get(k));
				err = true;
			}
		}

		if (!err)
			System.out.println("Пароль надежный.");
	}
}
