package tictactoe;

import java.util.Scanner;

public class Main {
	static char[][] state = new char[3][3];
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter cells: ");
		String input = in.next();
		state = toM2(input, 3);
		PrintState();
	}

	public static void PrintState() {
		System.out.println("---------");
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				if (j == 0) {
					System.out.print("| ");
				} else if (j < state[i].length) {
					System.out.print(" ");
				}
				System.out.print(state[i][j]);
				if (j == state[i].length - 1) {
					System.out.print(" |");
				}
			}
			System.out.println();
		}
		System.out.println("---------");
	}

	public static char[][] toM2(String array, int a) {
		char[][] matrix = new char[(array.length() + a - 1) / a][a];
		for (int i = 0; i < array.length(); i++) matrix[i / a][i % a] = array.charAt(i);
		return matrix;
	}
}
