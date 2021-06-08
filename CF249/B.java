import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		char[] s = in.next().toCharArray();
		int k = in.nextInt();
		long n = s.length;

		ArrayList<Character> a = new ArrayList<Character>();
		for (int i = 0; i < n; i++) {
			a.add(s[i]);
		}

		int ind = 0;
		while (k != 0 && ind < n) {
			char cur = a.get(ind);
			char best = cur;
			int bestJ = -1;
			
			for (int j = 1; j <= k && ind+j < n; j++)
			{
				char temp = a.get(ind+j);
				if (temp > best)
				{
					best = temp;
					bestJ = j;
				}
			}
			
			if (bestJ != -1)
			{
				k -= bestJ;
				char swap = a.remove(ind+bestJ);
				a.add(ind, swap);
			}
			
			ind++;
		}
		
		for (int i = 0; i < n; i++)
		{
			System.out.print(a.get(i));
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
