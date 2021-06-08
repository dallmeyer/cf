import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int sum = in.nextInt(), limit = in.nextInt();

		ArrayList<Tuple> lowbits = new ArrayList<Tuple>();
		for (int i = 1; i <= limit; i++) {
			lowbits.add(new Tuple(i, i & ~(i - 1)));
		}
		
		Collections.sort(lowbits);
		ArrayList<Integer> set = new ArrayList<Integer>();
		int cur = 0;
		while (!lowbits.isEmpty() && cur != sum)
		{
			Tuple t = lowbits.remove(0);
			if (cur + t.v <= sum)
			{
				cur += t.v;
				set.add(t.x);
			}
		}
		
		if (cur == sum)
		{
			System.out.println(set.size());
			String s = "";
			for (Integer i : set)
			{
				s += (i + " ");
			}
			System.out.println(s);
		}
		else
		{
			System.out.println("-1");
		}
	}

	private static class Tuple implements Comparable<Tuple> {
		int x, v;

		public Tuple(int x, int v) {
			this.x = x;
			this.v = v;
		}

		@Override
		//largest first
		public int compareTo(Tuple o) {
			return o.v - v;
		}
		
		public String toString()
		{
			return x + "," + v;
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
