import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		
		int one = 0,
			two = 0;
		
		for (int i = 0; i < n; i++)
		{
			int x = in.nextInt();
			if (x == 100)
			{
				one++;
			}
			else
			{
				two++;
			}
		}
		
		boolean can = true;
		if (one % 2 == 0)
		{
			if (two % 2 == 0)
			{
				can = true;
			}
			else if (one >= 2)
			{
				can = true;
			}
			else
			{
				can = false;
			}
		}
		else 
		{
			can = false;
		}
		
		if (can)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
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
