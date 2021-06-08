import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class D {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt(),
			m = in.nextInt();
		
		long[] a = new long[n],
				b = new long[m];
		long min = Integer.MAX_VALUE,
			max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
			if (a[i] < min)
			{
				min = a[i];
			}
		}
		for (int i = 0; i < m; i++)
		{
			b[i] = in.nextInt();
			if (b[i] > max)
			{
				max = b[i];
			}
		}
		
		long c1 = -1, c2 = -2;
		while (max-min > 1)
		{
			long mid = (max+min)/2;
			long cost = detCost(mid, a, b);
			long mid1 = Math.max(min, mid-1);
			long mid2 = Math.min(max, mid+1);
			c1 = detCost(mid1, a, b);
			c2 = detCost(mid2, a, b);
			
			if (c1 < cost)
			{
				max = mid;
			}
			else if (c2 < cost)
			{
				min = mid;
			}
			else
			{
				break;
			}
		}
		
		System.out.println(Math.min(detCost((max+min)/2,a,b),Math.min(detCost(min,a,b), detCost(max,a,b))));
	}
	
	private static long detCost(long thresh, long[] a, long[] b)
	{
		int n = a.length,
			m = b.length;
		
		long cost = 0;
		for (int i = 0; i < n; i++)
		{
			if (a[i] < thresh)
			{
				cost += (thresh - a[i]);
			}
		}
		for (int i = 0; i < m; i++)
		{
			if (b[i] > thresh)
			{
				cost += (b[i] - thresh);
			}
		}
		
		return cost;
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
