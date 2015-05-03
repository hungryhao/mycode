package com.hungry.others;

//将矩阵逆时针旋转45度后进行输出
public class RotateMatrix {
	public void printRotateMatrix(int[] matrix, int n) {
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= n - 1; j++) {
				if (i + j <= n - 1) {
					System.out.print(matrix[j * n + i + j] + " ");
				}
			}
			System.out.println();
		}

		for (int i = 1; i <= n - 1; i++) {
			for (int j = 0; j <= n - 1; j++) {
				if (i + j <= n - 1) {
					System.out.print(matrix[(i + j) * n + j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		RotateMatrix rm = new RotateMatrix();
		int[] matrix = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = 3;
		rm.printRotateMatrix(matrix, n);
	}

}
