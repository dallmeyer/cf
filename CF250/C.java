import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class C {
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int n = in.nextInt(), m = in.nextInt();

		ArrayList<Node> graph = new ArrayList<Node>();
		for (int i = 0; i < n; i++)
		{
			graph.add(new Node(i, in.nextInt()));
		}
		
		for (int i = 0; i < m; i++)
		{
			int x = in.nextInt()-1,
				y = in.nextInt()-1;
			
			graph.get(x).adj.add(graph.get(y));
			graph.get(x).cost += graph.get(y).w;
			graph.get(y).adj.add(graph.get(x));
			graph.get(y).cost += graph.get(x).w;
		}
		
		Collections.sort(graph);
		int minEnergy = 0;
		while (!graph.isEmpty())
		{
			ArrayList<Node> poss = new ArrayList<Node>();
			Node cur = graph.remove(0);
			int w = cur.w;
			poss.add(cur);
			
			while (!graph.isEmpty() && graph.get(0).w == w)
			{
				cur = graph.remove(0);
				poss.add(cur);
			}
			
			while (!poss.isEmpty())
			{
				Collections.sort(poss);
				
				cur = poss.remove(0);
				minEnergy += cur.cost;
				for (Node adjNode : cur.adj)
				{
					adjNode.cost -= cur.w;
					adjNode.adj.remove(cur);
				}
			}
		}
		
		System.out.println(minEnergy);
	}

	private static class Node implements Comparable<Node> {
		int i, w;
		int cost = 0;
		ArrayList<Node> adj;

		public Node(int i, int w) {
			this.i = i;
			this.w = w;
			adj = new ArrayList<Node>();
		}

		@Override
		//largest first
		public int compareTo(Node o) {
			int d = o.w - w;
			if (d == 0)
			{
				return cost - o.cost;
			}
			return d;
		}
		
		public int hashCode() {
			return i;
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
