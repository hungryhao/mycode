package com.hungry.others;

public class FindInPartiallySortedMatrix {

	public boolean find(int[] matrix, int rows, int columns, int num) {
		boolean found = false;

		if (matrix != null && rows > 0 && columns > 0) {
			int row = 0;
			int column = columns - 1;
			while (row < rows && column >= 0) {
				if (matrix[row * columns + column] == num) {
					found = true;
					break;
				} else if (matrix[row * columns + column] > num) {
					--column;
				} else {
					++row;
				}
			}
		}
		return found;
	}
	
	public static void main(String[] args) {
		FindInPartiallySortedMatrix fp = new FindInPartiallySortedMatrix();
		int[] matrix = {1,2,8,9,2,4,9,12,4,7,10,13,6,8,11,15};
		int columns = 4;
		int rows = 4;
		int num = 3;
		System.out.println(fp.find(matrix, rows, columns, num));
	}

}
