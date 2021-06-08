import java.util.Scanner;

public class A {

	private static String colors = "RGBYW";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[][] occ = new int[5][5];
		for (int i = 0; i < n; i++)
		{
			String s = in.next();
			char c = s.charAt(0);
			int v = s.charAt(1) - '1';
			int u = colors.indexOf(c);
			occ[u][v] = 3;
		}
		
		int min = 11;
		for (int mask = 0; mask < (1 << 10); mask++)
		{
			if (solves(occ, mask) && Integer.bitCount(mask) < min)
			{
				min = Integer.bitCount(mask);
			}
		}
		
		System.out.println(min);
	}

	private static boolean solves(int[][] occ, int mask)
	{
		//add hints from mask
		for (int i = 0; i < 10; i++)
		{
			if ((mask & (1 << i)) > 0)
			{
				if (i < 5)	//colors
				{
					for (int j = 0; j < 5; j++)
					{
						//decrement by 1 if hint is row i
						occ[i][j]--;
					}
				}
				else
				{
					for (int j = 0; j < 5; j++)
					{
						//decrement by 2 if hint is column (i-5)
						occ[j][i-5]-=2;
					}
				}
			}
		}
		
		boolean solved = true;
		int numUnknown = 0;
		checkLoop: for (int i = 0; i < 5; i++)
		{
			int numR = 0, numC = 0;
			for (int j = 0; j < 5; j++)
			{
				if (occ[i][j] == 3)
				{
					numUnknown++;
				}
				//number of elems in row with undetermined cols
				if (occ[i][j] == 2 || occ[i][j] == 3)
				{
					numR++;
				}
				//number of elems in col with undetermined rows
				if (occ[j][i] == 1 || occ[j][i] == 3)
				{
					numC++;
				}
			}
			
			//cannot be two col-undetermined elems in any row
			//cannot be two row-undetermined elems in any col
			if (numR > 1 || numC > 1)
			{
				solved = false;
				break checkLoop;
			}
		}
		
		if (numUnknown > 1)
		{
			solved = false;
		}
		
		//remove hints from mask
		for (int i = 0; i < 10; i++)
		{
			if ((mask & (1 << i)) > 0)
			{
				if (i < 5)	//colors
				{
					for (int j = 0; j < 5; j++)
					{
						occ[i][j]++;
					}
				}
				else
				{
					for (int j = 0; j < 5; j++)
					{
						occ[j][i-5]+=2;
					}
				}
			}
		}
		
		return solved;
	}
}
