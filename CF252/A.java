import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int n = in.nextInt(),
			v = in.nextInt();
		
		int count = 0;
		String s = " ";
		
		for (int i = 0; i < n; i++)
		{
			boolean can = false;
			int k = in.nextInt();
			for (int j = 0; j < k; j++)
			{
				int x = in.nextInt();
				if (v > x)
				{
					can = true;
				}
			}
			
			if (can)
			{
				count++;
				s += (i+1) + " ";
			}
		}
		
		s = s.trim();
		System.out.println(count);
		if (count > 0)
		{
			System.out.println(s);
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
