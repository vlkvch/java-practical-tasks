package lab.three;

import java.util.Random;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.printf("Введите количество строк/столбцов матрицы:\n> ");
		byte size = in.nextByte();
		in.close();
		byte[][] matrix = new byte[size][size];
		byte[] counters = new byte[size];

		Random rand = new Random();
		for (byte i = 0; i < matrix.length; i++) {
			for (byte j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (byte)(rand.nextInt(100));
				if (i != 0 || j != 0) {
					if (matrix[i][j] % (i + j) == 0)
						counters[j]++;
				}
				System.out.printf("%d\t", matrix[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Количество элементов, кратных сумме индексов:");
		for (byte elem : counters)
			System.out.printf("%d\t", elem);
		System.out.printf("\n\n");

		byte minColumn = 0;
		for (byte i = 0; i < counters.length - 1; i++) {
			if (counters[i] <= counters[i + 1])
				minColumn = i;
			else
				minColumn = (byte)(i + 1);
		}
		System.out.printf("В(-о) %d-м столбце минимальное количество элементов, кратных сумме индексов.\nВ нем %d элемент(-а/ов).\n", minColumn + 1, counters[minColumn]);
	}
}