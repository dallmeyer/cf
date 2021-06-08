import java.util.Arrays;
import java.util.Scanner;


public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		double[] p = new double[n],
				 q = new double[n];
		for (int i = 0; i < n; i++)
		{
			p[i] = in.nextDouble();
		}
		Arrays.sort(p);
		for (int i = 0; i < n; i++)
		{
			q[i] = 1 - p[i];
		}
		
		double[] P0 = new double[n],
				 P1 = new double[n],
				 P2 = new double[n];
		
		P0[n-1] = q[n-1];
		P1[n-1] = p[n-1];
		P2[n-1] = 0;
		
		double max = P1[n-1];
		for (int i = n-2; i >= 0; i--)
		{
			P0[i] = P0[i+1] * q[i];
			P2[i] = P2[i+1] + p[i]*(P1[i+1]);
			P1[i] = 1 - P2[i] - P0[i];
			if (max < P1[i])
			{
				max = P1[i];
			}
		}
		
		System.out.println(max);
	}

}
