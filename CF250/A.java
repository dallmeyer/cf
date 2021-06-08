import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;


public class A {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		HashMap<String,Integer> look = new HashMap<String,Integer>();
		ArrayList<String> ans = new ArrayList<String>();
		for (int i = 0; i < 4; i++)
		{
			String s = in.next().substring(2);
			ans.add(s);
			look.put(s, i);
		}
		Collections.sort(ans, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		
		boolean smallGreat = false, bigGreat = false;

		if (ans.get(0).length() * 2 <= ans.get(1).length())
		{
			smallGreat = true;
		}
		if (ans.get(3).length() >= ans.get(2).length() * 2)
		{
			bigGreat = true;
		}
		
		if (smallGreat == bigGreat)
		{
			System.out.println("C");
		}
		else if (smallGreat)
		{
			int x = look.get(ans.get(0));
			char chosen = 'A';
			chosen += x;
			System.out.println(chosen);
		}
		else if (bigGreat)
		{
			int x = look.get(ans.get(3));
			char chosen = 'A';
			chosen += x;
			System.out.println(chosen);
		}
	}
	
	public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
 
    }

}
