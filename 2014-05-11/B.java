import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(),
			k = in.nextInt(),
			x = in.nextInt();
		
		ArrayList<Integer> possPlays = new ArrayList<Integer>(); 
		LinkedList<Integer> row = new LinkedList<Integer>();
		for (int i = 0; i < n; i++)
		{
			int c = in.nextInt();
			if (c == x && i > 0 && row.getLast() == x)
			{
				possPlays.add(i);
			}
			row.add(c);
		}
		
		int max = 0;
		for (Integer i : possPlays)
		{
			max = Math.max(max,play(new LinkedList<Integer>(row), i));
		}
		
		System.out.println(max);
	}

	private static int play(LinkedList<Integer> row, int p)
	{
		int totalCount = 2;
		
		int l = p - 2,
			r = p + 1;
		
		while (l >= 0 && r < row.size() && row.get(l) == row.get(r))
		{
			int subCount = 0;
			int x = row.get(l);
			
			while (l >= 0 && row.get(l) == x)
			{
				subCount++;
				l--;
			}
			while (r < row.size() && row.get(r) == x)
			{
				subCount++;
				r++;
			}
			
			if (subCount < 3)
			{
				break;
			}
			else
			{
				totalCount += subCount;
			}
		}
		
		return totalCount;
	}
	
}
