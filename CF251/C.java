import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class C {

	static int n,k,p;
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		n = in.nextInt();
		k = in.nextInt();
		p = in.nextInt();
		
		ArrayList<Integer> odds = new ArrayList<Integer>(),
							evens = new ArrayList<Integer>();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
			if (a[i] % 2 == 0)
			{
				evens.add(a[i]);
			}
			else
			{
				odds.add(a[i]);
			}
		}
		
		if ((k-p) % 2 == 0)	//even # of odd parts, requires even # of odd #s
		{
			if (odds.size() >= k-p && odds.size() % 2 == 0 && p <= evens.size() + (odds.size() - (k-p))/2)
			{
				System.out.println("YES");
				int o = 0;
				int parts = 0;
				//make odd parts
				while (o < k-p && parts < k)
				{
					if (parts == k-1)
					{
						System.out.print((odds.size() - o + evens.size()) + " ");
						for (; o < odds.size(); o++)
						{
							System.out.print(odds.get(o) + " ");
						}
						for (int e = 0; e < evens.size(); e++)
						{
							System.out.print(evens.get(e) + " ");
						}
						System.out.println();
						parts++;
					}
					else
					{
						System.out.println("1 " + odds.get(o++));
						parts++;
					}
				}
				//make even parts
				while (o < odds.size() && parts < k)
				{
					if (parts == k-1)
					{
						System.out.print((odds.size() - o + evens.size()) + " ");
						for (; o < odds.size(); o++)
						{
							System.out.print(odds.get(o) + " ");
						}
						for (int e = 0; e < evens.size(); e++)
						{
							System.out.print(evens.get(e) + " ");
						}
						System.out.println();
						parts++;
					}
					else
					{
						System.out.println("2 " + odds.get(o) + " " + odds.get(o+1));
						parts++;
						o += 2;
					}
				}
				int e = 0;
				while (parts < k)
				{
					if (parts == k-1)
					{
						System.out.print((evens.size() - e) + " ");
						for (; e < evens.size(); e++)
						{
							System.out.print(evens.get(e) + " ");
						}
						System.out.println();
						parts++;
					}
					else
					{
						System.out.println("1 " + evens.get(e++));
						parts++;						
					}
				}
			}
			else
			{
				System.out.println("NO");
			}
		}
		else
		{
			if (odds.size() < k-p || odds.size() % 2 == 0 || p > evens.size() + (odds.size() - (k-p))/2)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
				int o = 0;
				int parts = 0;
				//make odd parts
				while (o < k-p && parts < k)
				{
					if (parts == k-1)
					{
						System.out.print((odds.size() - o + evens.size()) + " ");
						for (; o < odds.size(); o++)
						{
							System.out.print(odds.get(o) + " ");
						}
						for (int e = 0; e < evens.size(); e++)
						{
							System.out.print(evens.get(e) + " ");
						}
						System.out.println();
						parts++;
					}
					else
					{
						System.out.println("1 " + odds.get(o++));
						parts++;
					}
				}
				//make even parts
				while (o < odds.size() && parts < k)
				{
					if (parts == k-1)
					{
						System.out.print((odds.size() - o + evens.size()) + " ");
						for (; o < odds.size(); o++)
						{
							System.out.print(odds.get(o) + " ");
						}
						for (int e = 0; e < evens.size(); e++)
						{
							System.out.print(evens.get(e) + " ");
						}
						System.out.println();
						parts++;
					}
					else
					{
						System.out.println("2 " + odds.get(o) + " " + odds.get(o+1));
						parts++;
						o += 2;
					}
				}
				int e = 0;
				while (parts < k)
				{
					if (parts == k-1)
					{
						System.out.print((evens.size() - e) + " ");
						for (; e < evens.size(); e++)
						{
							System.out.print(evens.get(e) + " ");
						}
						System.out.println();
						parts++;
					}
					else
					{
						System.out.println("1 " + evens.get(e++));
						parts++;						
					}
				}
			}			
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
