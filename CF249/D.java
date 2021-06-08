import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class D {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt(),
			m = in.nextInt();
		
		boolean[][] b = new boolean[n][m];
		for (int i = 0; i < n; i++)
		{
			String s = in.next();
			for (int j = 0; j < m; j++)
			{
				b[i][j] = (s.charAt(j) == '1'); 
			}
		}
		
		int diags = Math.max(n,m);
		Tree[] vert = new Tree[m],
			   horiz = new Tree[n],
			   diag1 = new Tree[diags],
			   diag2 = new Tree[diags];
		
		for (int i = 0; i < diags; i++)
		{
			if (i < m)
			{
				vert[i] = new Tree(n);
			}
			if (i < n)
			{
				horiz[i] = new Tree(m);
			}
			diag1[i] = new Tree(diags);
			diag2[i] = new Tree(diags);
		}
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (b[i][j])
				{
					vert[j].add(i,1);
					horiz[i].add(j, 1);
					
				}
			}
		}
	}
	
	private static class Tree {
        private int[] tree;

        /* Initialize all elements to zero. */
        Tree(int size) {
            this.tree = new int[size];
        }

        /* O(log n) get sum of tree[0..idx], inclusive */
        int getPartialSum(int idx) {
            int res = 0;
            while (idx >= 0) {
                res += tree[idx];
                idx = (idx & (idx + 1)) - 1;
            }
            return res;
        }

        /* O(log n) update.  t[idx] += val */
        void add(int idx, int val) {
            while (idx < tree.length) {
                tree[idx] += val;
                idx |= (idx + 1);
            }
        }

        /* O(log n) return t[idx] */
        int getSingle(int idx){
            int sum = tree[idx];
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
        int getRangeSum(int from, int to) {
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
