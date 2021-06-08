import java.util.HashSet;
import java.util.Scanner;


public class A_div2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		HashSet<Character> uniques = new HashSet<Character>();
		
		String s = in.nextLine();
		if (s.length() < 3)
		{
			System.out.println("0");
			return;
		}
		for (int i = 1; i < s.length(); i+=3)
		{
			uniques.add(s.charAt(i));
		}
		
		System.out.println(uniques.size());
	}

}
