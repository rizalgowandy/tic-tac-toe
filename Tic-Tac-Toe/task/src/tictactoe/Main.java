package tictactoe;

import java.util.Scanner;

public class Main {
	static int boardSize = 3;
	static char[][] state = new char[boardSize][boardSize];
	static Scanner in = new Scanner(System.in);
	static int xCounter = 0;
	static int oCounter = 0;
	static int blankCounter = 0;

	public static void main(String[] args) {
		System.out.print("Enter cells: ");
		String input = in.next();
		state = toM2(input, boardSize);
		PrintState();
		CheckState();
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
				switch (state[i][j]) {
					case 'X':
						xCounter++;
						break;
					case 'O':
						oCounter++;
						break;
					default:
						blankCounter++;
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

	public static void CheckState() {
		boolean xWin = CheckWin('X');
		boolean oWin = CheckWin('O');
		if (xWin && oWin || Math.abs(xCounter - oCounter) >= 2) {
			System.out.print("Impossible");
			return;
		}
		if (xWin) {
			System.out.println("X wins");
			return;
		}
		if (oWin) {
			System.out.println("O wins");
			return;
		}
		if (blankCounter == 0) {
			System.out.println("Draw");
			return;
		}
		System.out.println("Game not finished");
	}

	public static boolean CheckWin(char c) {
		return (c == state[0][0] && state[0][0] == state[0][1] && state[0][0] == state[0][2]) ||
			(c == state[1][0] && state[1][0] == state[1][1] && state[1][0] == state[1][2]) ||
			(c == state[2][0] && state[2][0] == state[2][1] && state[2][0] == state[2][2]) ||
			(c == state[0][0] && state[0][0] == state[1][1] && state[0][0] == state[2][2]) ||
			(c == state[0][2] && state[0][2] == state[1][1] && state[0][0] == state[2][0]) ||
			(c == state[0][0] && state[0][0] == state[1][0] && state[0][0] == state[2][0]) ||
			(c == state[0][1] && state[0][1] == state[1][1] && state[0][1] == state[2][1]) ||
			(c == state[0][2] && state[0][2] == state[1][2] && state[0][2] == state[2][2]);
	}
}
