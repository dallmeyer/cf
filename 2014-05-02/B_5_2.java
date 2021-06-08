import java.util.LinkedList;
import java.util.Scanner;


public class B_5_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(),
			t = in.nextInt(),
			c = in.nextInt();
		
		int count = 0;
		int severeCount = 0;
		LinkedList<Integer> segment = new LinkedList<Integer>();
		
		for (int i = 0; i < c; i++)
		{
			int x = in.nextInt();
			if (x > t)
			{
				severeCount++;
			}
			
			segment.add(x);
		}
		
		if (severeCount == 0)
		{
			count++;
		}
		
		for (int i = c; i < n; i++)
		{
			int x = in.nextInt();
			segment.add(x);
			if (x > t)
			{
				severeCount++;
			}
			
			int removed = segment.removeFirst();
			if (removed > t)
			{
				severeCount--;
			}
			
			if (severeCount == 0)
			{
				count++;
			}
		}
		
		System.out.print(count);
	}

}
