package lab.onetwo;

class Main {
	public static void main(String[] args) {
		System.out.println("— Задание 1 —");
		byte[][] students = new byte[4][7];
		byte counter = 1;
		for (byte i = 0; i < students.length; i++) {
			for (byte j = 0; j < students[i].length; j++) {
				students[i][j] = counter;
				counter++;
				System.out.printf("%d\t", students[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();

		for (byte i = 0; i < students.length; i++) {
			for (byte j = 0; j < students[i].length; j++) {
				if (students[i][j] % 2 != 0)
					System.out.print("28\t");
				else
					System.out.printf("%d\t", students[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("— Задание 2 —");
		int[][] studentsNew = new int[4][students[0].length - 1];
		for (byte i = 0; i < studentsNew.length; i++) {
			for (byte j = 1; j < studentsNew[i].length; j++) {
				studentsNew[i][j] = students[i][j];
			}
		}

		for (byte i = 0; i < studentsNew.length; i++) {
			studentsNew[i][0] = 1;
			for (byte j = 1; j < studentsNew[i].length; j++) {
				studentsNew[i][0] *= students[i][j];
			}
		}
		
		for (byte i = 0; i < studentsNew.length; i++) {
			for (byte j = 0; j < studentsNew[i].length; j++) {
				System.out.printf("%d\t", studentsNew[i][j]);
			}
			System.out.println();
		}

	}
}