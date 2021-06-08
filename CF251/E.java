import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class E {
	
	static BigInteger MOD = BigInteger.valueOf(1000000007);
	static int n,k,p;
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		
		
		BigInteger ways = BigInteger.ZERO;
		Queue<State> q = new ArrayDeque<State>();
		q.add(new State());
		while (!q.isEmpty())
		{
			State s = q.poll();
			if (s.sum == n)
			{
				ways = ways.add(s.perms()).mod(MOD);
			}
		}
	}
	
	private static class State
	{
		ArrayList<Integer> parts;
		int gcd, sum;
		
		public State()
		{
			parts = new ArrayList<Integer>();
			gcd = -1;
			sum = 0;
		}
		
		public State clone()
		{
			State s = new State();
			s.parts = new ArrayList<Integer>(this.parts);
			s.gcd = this.gcd;
			
			return s;
		}
		
		public void add(int x)
		{
			sum += x;
			parts.add(x);
			if (gcd == -1)
			{
				gcd = x;
			}
			else
			{
				gcd = gcd(gcd,x);
			}
		}
		
	
	}
	
	static int gcd(int a, int b)
	{
		if ((a % b) == 0)	return b;
		return gcd(b, a%b);
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
