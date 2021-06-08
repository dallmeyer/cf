import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int n = in.nextInt(), v = in.nextInt();

		int[] fruit = new int[3002];
		for (int i = 0; i < n; i++) {
			int a = in.nextInt(), b = in.nextInt();
			fruit[a] += b;
		}

		int count = 0, leftover = 0;
		for (int i = 1; i < 3002; i++) {
			int daily = 0;
			daily += Math.min(leftover, v);
			int fresh = Math.min(fruit[i], v - daily);
			daily += fresh;
			leftover = fruit[i] - fresh;

			count += daily;
		}

		System.out.println(count);
	}

	private static class Tree implements Comparable<Tree> {
		int a, b;

		public Tree(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Tree o) {
			return Integer.compare(a, o.a);
		}

		public String toString() {
			return a + "," + b;
		}

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
