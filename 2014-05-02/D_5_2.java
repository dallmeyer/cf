import java.util.ArrayList;
import java.util.Scanner;

public class D_5_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String 	s1 = in.nextLine(),
				s2 = in.nextLine();
		
		int len = findMin(s1, s2);
		
		System.out.println(len);
	}
	
	private static class Match {
		
	}

	private static class Entry implements Comparable<Entry> {
		int[] nr;
		int p;

		public Entry() {
			this.nr = new int[2];
			this.p = -1;
		}

		public int compareTo(Entry o) {
			return this.nr[0] == o.nr[0] 
					? (this.nr[1] < o.nr[1] ? -1 : 1)
					: (this.nr[0] < o.nr[0] ? -1 : 1);
		}
	}
	
	
	private static int findMin(String s1, String s2) {
		String s = s1 + s2;
		
		int l1 = s1.length(),
			l2 = s2.length();
		
		int n = l1 + l2;
		char[] A = s.toCharArray();

		ArrayList<Integer> 	seeds1 = new ArrayList<Integer>(),
							seeds2 = new ArrayList<Integer>();
		
		int[] prev = new int[n];
		for (int i = 0; i < n; i++)
		{
			prev[i] = A[i];
			if (i < l1)
			{
				int j = s2.indexOf(A[i]);
				if (j != -1)
				{
					seeds1.add(i);
				}
			}
			else
			{
				int j = s1.indexOf(A[i]);
				if (j != -1)
				{
					seeds2.add(i);
				}
			}
		}
		int[] next = new int[n];		
		
		int len = 1;
		checkLoop: while (true)
		{
			//check for common unique subseqs
			ArrayList<Integer> 	subs1 = new ArrayList<Integer>(),
								uniqueSubs1 = new ArrayList<Integer>();
			for (Integer i : seeds1)
			{
				int x = prev[i];
				if (!subs1.contains(x))
				{
					subs1.add(x);
					uniqueSubs1.add(x);
				}
				else if (uniqueSubs1.contains(x))
				{
					uniqueSubs1.remove(x);
				}
			}
			
			ArrayList<Integer> 	subs2 = new ArrayList<Integer>(),
								uniqueSubs2 = new ArrayList<Integer>();
			for (Integer i : seeds2)
			{
				int x = prev[i];
				if (!subs2.contains(x))
				{
					subs2.add(x);
					uniqueSubs2.add(x);
				}
				else if (uniqueSubs2.contains(x))
				{
					uniqueSubs2.remove(x);
				}
			}
			
			for (Integer x: uniqueSubs1)
			{
				if (uniqueSubs2.contains(x))
				{
					break checkLoop;
				}
			}
			
			//nothing yet, must update
			
		}
		
		return len;
	}

}
