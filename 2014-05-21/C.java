import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;


public class C {

	static HashMap<Integer,BigInteger> factMap = new HashMap<Integer,BigInteger>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(),
			k = in.nextInt(),
			d = in.nextInt();
		
		BigInteger count = BigInteger.ZERO;
		BigInteger MOD = BigInteger.valueOf(1000000007);
		
		int[] p = new int[n]; // An array to store a partition
	    int q = 0;  // Index of last element in a partition
	    p[q] = n;  // Initialize first partition as number itself
	 
	    // This loop first prints current partition, then generates next
	    // partition. The loop stops when the current partition has all 1s
	    while (true)
	    {
	    	count = count.add(check(p, q, k, d));
	        // Generate next partition
	 
	        // Find the rightmost non-one value in p[]. Also, update the
	        // rem_val so that we know how much value can be accommodated
	        int rem_val = 0;
	        while (q >= 0 && p[q] == 1)
	        {
	            rem_val += p[q];
	            q--;
	        }
	 
	        // if q < 0, all the values are 1 so there are no more partitions
	        if (q < 0)  break;
	 
	        // Decrease the p[q] found above and adjust the rem_val
	        p[q]--;
	        rem_val++;
	 
	 
	        // If rem_val is more, then the sorted order is violeted.  Divide
	        // rem_val in differnt values of size p[q] and copy these values at
	        // different positions after p[q]
	        while (rem_val > p[q])
	        {
	            p[q+1] = p[q];
	            rem_val = rem_val - p[q];
	            q++;
	        }
	 
	        // Copy rem_val to next position and increment position
	        p[q+1] = rem_val;
	        q++;
	    }
	    
	    System.out.println(count.mod(MOD));
	}

	private static BigInteger check(int[] p, int q, int k, int d)
	{
		if (p[0] > k || p[0] < d)
		{
			return BigInteger.ZERO;
		}
		
		BigInteger ways = fact(q+1);
		int repeats = 1;
		for (int i = 1; i <= q; i++)
		{
			if (p[i] == p[i-1])
			{
				repeats++;
			}
			else
			{
				ways = ways.divide(fact(repeats));
				repeats = 1;
			}
		}
		ways = ways.divide(fact(repeats));
		return ways;
	}
	
	private static BigInteger fact(int n)
	{
		if (factMap.containsKey(n))
		{
			return factMap.get(n);
		}
		
		BigInteger x = BigInteger.ONE;
		for (int i = 2; i <= n; i++)
		{
			x = x.multiply(BigInteger.valueOf(i));
		}
		
		factMap.put(n, x);
		return x;
	}
	
}
