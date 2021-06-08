import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[][] g = new int[5][5];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				g[i][j] = in.nextInt();
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(solve(g, list));
	}
	
	private static int solve(int[][] g, ArrayList<Integer> list)
	{
		if (list.size() == 5)
		{
			int count = 0;
			count += g[list.get(0)][list.get(1)] + g[list.get(1)][list.get(0)];
			count += g[list.get(1)][list.get(2)] + g[list.get(2)][list.get(1)];
			count += 2 * (g[list.get(2)][list.get(3)] + g[list.get(3)][list.get(2)]);
			count += 2 * (g[list.get(3)][list.get(4)] + g[list.get(4)][list.get(3)]);
			return count;
		}
		
		int max = 0;
		for (int x = 0; x < 5; x++)
		{
			if (list.contains(x))
				continue;
			
			ArrayList<Integer> listClone = new ArrayList<Integer>(list);
			listClone.add(x);
			max = Math.max(max, solve(g, listClone));
		}
		
		return max;
	}
	
}
