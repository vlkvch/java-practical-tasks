package lab.four;

class Util {
	public static void setAction(String action) {
		while ((action = in.nextByte()) != 0) {
			switch(action) {
				case 1:
					System.out.println(animl.move());
					break;
				case 2:
					System.out.println(animl.sound());
					break;
				default:
					System.out.println("[!] Такого действия нет.");
					break;
			}

			System.out.print("Действие для животного:\n> ");
		}
	}
}
