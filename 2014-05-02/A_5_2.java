import java.util.Scanner;

public class A_5_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int police = 0;
		int crimes = 0;
		for (int i = 0; i < n; i++)
		{
			int x = in.nextInt();
			if (x > 0)
			{
				police += x;
			}
			else if (police == 0)
			{
				crimes++;
			}
			else
			{
				police--;
			}
		}
		
		System.out.println(crimes);
	}
}
