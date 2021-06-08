import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int n = in.nextInt();
		int[] a = new int[n];
		int max = 0, min = 0, cur = 0, tot = 0;

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			if (i % 2 == 0) {
				cur += a[i];
			} else {
				cur -= a[i];
			}

			if (cur < min) {
				min = cur;
			}
			if (cur > max) {
				max = cur;
			}

			tot += a[i];
		}

		char[][] c = new char[max - min][tot];
		for (int i = 0; i < max - min; i++) {
			Arrays.fill(c[i], ' ');
		}

		int row = min * -1, col = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < a[i]; j++) {
				if (i % 2 == 0) // going up
				{
					c[row][col] = '/';
					if (j < a[i] - 1)
						row++;
				} else {
					c[row][col] = '\\';
					if (j < a[i] - 1)
						row--;
				}
				col++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = max - min - 1; i >= 0; i--) {
			for (int j = 0; j < tot; j++) {
				sb.append(c[i][j]);
			}
			if (i > 0) {
				sb.append("\n");
			}
		}
		
		System.out.print(sb.toString());
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
