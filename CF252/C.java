import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {

	private static int r, c, m, n;

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		n = in.nextInt();
		m = in.nextInt();
		int k = in.nextInt();

		r = 1;
		c = 1;
		int t = 0;

		StringBuilder output = new StringBuilder();
		for (int i = 0; i < k; i++) {
			StringBuilder s = new StringBuilder(); 
			if (i < k - 1) // two cell tube
			{
				s.append(nextCell(2));
				t += 2;
			} else // tube spans rest of grid
			{
				s.append(nextCell(n * m - t));
			}

			output.append(s + "\n");
		}

		System.out.print(output);
	}

	private static String nextCell(int n) {
		StringBuilder s = new StringBuilder(n + " ");
		for (int i = 0; i < n; i++) {
			s.append(r + " " + c + " ");
			if (r % 2 == 1) // L to R
			{
				if (c == m) {
					r++;
				} else {
					c++;
				}
			} else {
				if (c == 1) {
					r++;
				} else {
					c--;
				}
			}
		}
		return s.toString();
	}

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
}
