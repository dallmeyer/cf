import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] a = new int[4];
		for (int i = 0; i < 4; i++)
		{
			a[i] = in.nextInt();
		}
		
		long count = 0;
		in.nextLine();
		char[] s = in.nextLine().toCharArray();
		for (int i = 0; i < s.length; i++)
		{
			int x = Integer.parseInt(s[i] + "") - 1;
			count += a[x];
		}
		
		System.out.println(count);
	}

}
