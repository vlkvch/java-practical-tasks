package lab.four;

import java.util.Arrays;
import java.util.Scanner;

class Main {
	static void reverseArray(int[] array) {
		int size = array.length;
		for (int i = 0; i < size / 2; i++) {
			int oldArray = array[i];
			array[i] = array[size - i - 1];
			array[size - i - 1] = oldArray;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.printf("Введите кол-во строк/столбцов матрицы:\n> ");
		byte size = in.nextByte();
		int[][] matrix = new int[size][size];

		for (byte column = 0; column < matrix.length; column++) {
			System.out.printf("Элементы %d-го столбца:\n", column + 1);
			for (byte row = 0; row < matrix[column].length; row++) {
				System.out.printf("Введите %d-й элемент:\n> ", row + 1);
				matrix[column][row] = in.nextInt();
			}
		}
		in.close();

		int sortedMatrix[][] = new int[size][size];
		int sortedMatrixReversed[][] = new int[size][size];
		for (byte row = 0; row < matrix.length; row++) {
			for (byte column = 0; column < matrix[row].length; column++) {
				sortedMatrix[row][column] = matrix[row][column];
				sortedMatrixReversed[row][column] = matrix[row][column];
			}
			Arrays.sort(sortedMatrix[row]);
			Arrays.sort(sortedMatrixReversed[row]);
			reverseArray(sortedMatrixReversed[row]);
		}


		boolean[] sortedColumns = new boolean[size];
		for (byte column = 0; column < matrix.length; column++) {
			for (byte row = 0; row < matrix[column].length; row++) {
				if (matrix[column][row] == sortedMatrix[column][row]) {
					sortedColumns[column] = true;
				} else if (matrix[column][row] == sortedMatrixReversed[column][row]) {
					sortedColumns[column] = true;
				} else {
					sortedColumns[column] = false;
					break;
				}
			}
		}

		int maxNumber = 0;
		for (byte column = 0; column < matrix.length; column++) {
			if (sortedColumns[column] == true) {
				for (byte row = 0; row < matrix[column].length - 1; row++) {
					if (matrix[column][row] <= matrix[column][row + 1])
						maxNumber = matrix[column][row + 1];
					else if (matrix[column][row] - 1 >= matrix[column][row + 1] && matrix[column][row] > maxNumber)
						maxNumber = matrix[column][row];
				}
			}
		}
		System.out.printf("Максимальный элемент — %d.\n", maxNumber);
	}
}
