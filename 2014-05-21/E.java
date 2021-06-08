import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class E {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(),
			q = in.nextInt();
		
		ArrayList<Tube> t = new ArrayList<Tube>();
		for (int i = 0; i < n; i++)
		{
			t.add(new Tube(in.nextInt()));
		}
		
		for (int i = 0; i < q; i++)
		{
			int qt = in.nextInt();
			if (qt == 1)
			{
				double vi = in.nextDouble();
				PriorityQueue<Tube> queue = new PriorityQueue<Tube>(t);
				while (vi )
			}
			else //qt == 2
			{
				int pi = in.nextInt(),
					xi = in.nextInt();
				Tube z = t.get(pi-1);
				z.w = 0;
				z.m = xi;
			}
		}
	}
	
	private static class Tube implements Comparable<Tube>
	{
		double m, w;
		
		public Tube(double m)
		{
			this.m = m;
			this.w = 0;
		}

		@Override
		public int compareTo(Tube o) {
			double d = (m + w) - (o.m + o.w);
			if (d < 0)
			{
				return -1;
			}
			else if (d > 0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}

}
