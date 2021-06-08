import java.util.Scanner;

public class Chessboard {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(), m = in.nextInt();

		char[][] board = new char[n][m];
		boolean B = true;
		for (int i = 0; i < n; i++) {
			char[] line = in.next().toCharArray();
			for (int j = 0; j < m; j++) {
				if (line[j] == '.') {
					if ((i + j) % 2 == 0) {
						System.out.print("B");
					} else {
						System.out.print("W");
					}
				} else {
					System.out.print("-");
				}
				B = !B;
			}
			B = !B;
			System.out.println();
		}
	}

}
