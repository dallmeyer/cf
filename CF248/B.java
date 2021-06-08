import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		
		ArrayList<Long> orig = new ArrayList<Long>();
		Tree first = new Tree(n),
			 second = new Tree(n);
		
		for (int i = 0; i < n; i++)
		{
			long x = in.nextInt();
			orig.add(x);
			first.add(i, x);
		}
		Collections.sort(orig);
		for (int i = 0; i < n; i++)
		{
			second.add(i, orig.get(i));
		}
		
		int m = in.nextInt();
		for (int i = 0; i < m; i++)
		{
			int type = in.nextInt(),
				l = in.nextInt()-1,
				r = in.nextInt()-1;
			
			if (type == 1)
			{
				System.out.println(first.getRangeSum(l, r));
			}
			else
			{
				System.out.println(second.getRangeSum(l, r));
			}
		}
	}
	
	private static class Tree {
        private long[] tree;

        /* Initialize all elements to zero. */
        Tree(int size) {
            this.tree = new long[size];
        }

        /* O(log n) get sum of tree[0..idx], inclusive */
        long getPartialSum(int idx) {
            long res = 0;
            while (idx >= 0) {
                res += tree[idx];
                idx = (idx & (idx + 1)) - 1;
            }
            return res;
        }

        /* O(log n) update.  t[idx] += val */
        void add(int idx, long val) {
            while (idx < tree.length) {
                tree[idx] += val;
                idx |= (idx + 1);
            }
        }

        /* O(log n) return t[idx] */
        long getSingle(int idx){
            long sum = tree[idx];
            if (idx > 0) {
                int z = (idx & (idx + 1)) - 1;
                idx--;
                while (idx != z) {
                    sum -= tree[idx]; 
                    idx = (idx & (idx + 1)) - 1;
                }
            }
            return sum;
        }

        /* O(log n) return sum(t[idx] for idx in range[from, to]) */
        long getRangeSum(int from, int to) {
            return getPartialSum(to) - getPartialSum(from - 1);
        }

        /* can also do: scaling in O(n),
         * searching for given cumulative freq in O(log n),
         * adding to entire range in O(log n)
         */
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
