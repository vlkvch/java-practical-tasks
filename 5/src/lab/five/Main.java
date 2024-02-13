package lab.five;

import java.util.Arrays;
import java.util.Scanner;

class Main {
	static byte[] removeDuplicates(byte[] array) {
		Arrays.sort(array);
		byte numberOfDuplicates = 0;
		for (byte i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1])
				numberOfDuplicates++;
		}
		byte[] newArray = new byte[array.length - numberOfDuplicates];
		newArray[0] = array[0];
		byte index = 0;
		for (byte i = 1; i < array.length; i++) {
			if (array[i - 1] == array[i])
				continue;
			newArray[index] = array[i];
			index++;
		}
		return newArray;
	}
	
	static boolean arraysAreEqual(byte[] fstArray, byte[] sndArray) {
		byte[] fstSet = removeDuplicates(fstArray);
		byte[] sndSet = removeDuplicates(sndArray);

		if (fstSet.length != sndSet.length)
			return false;
		
		for (byte i = 0; i < fstSet.length; i++) {
			if (fstSet[i] != sndSet[i])
				return false;
		}
		return true;
	}

	static byte countEqual(byte[][] matrix) {
		byte counter = 0;
		for (byte i = 1; i < matrix.length; i++) {
			if (arraysAreEqual(matrix[0], matrix[i]))
				counter++;
		}
		return counter;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.printf("Введите кол-во строк матрицы:\n> ");
		byte a = in.nextByte();
		System.out.printf("Введите кол-во столбцов матрицы:\n> ");
		byte b = in.nextByte();
		byte[][] matrix = new byte[a][b];
		
		for (byte i = 0; i < matrix.length; i++) {
			System.out.printf("[*] Элементы %d-й строки:\n", i + 1);
			for (byte j = 0; j < matrix[i].length; j++) {
				System.out.printf("Введите число от 0 до 100\n> ");
				matrix[i][j] = in.nextByte();
				if (matrix[i][j] < 0 || matrix[i][j] > 100) {
					System.out.println("[!] Число должно быть в диапазоне от 0 до 100.");
					return;
				}
			}
		}
		in.close();

		System.out.printf("Кол-во строк, похожих на первую: %d.\n", countEqual(matrix));
	}
}