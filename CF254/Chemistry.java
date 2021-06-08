import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class Chemistry {
	private static int N;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		int m = in.nextInt();
		ArrayList<Node> OGnodes = new ArrayList<Node>();

		for (int i = 0; i < N; i++) {
			OGnodes.add(new Node(i));
		}
		for (int i = 0; i < m; i++) {
			int x = in.nextInt() - 1, y = in.nextInt() - 1;
			OGnodes.get(x).adj.set(y);
			OGnodes.get(y).adj.set(x);
		}
		
		ArrayList<Node> nodes = new ArrayList<Node>(OGnodes);
		
		Collections.sort(nodes);

		BitSet vis = new BitSet(N);
		long danger = 1;
		while (nodes.size() > 0) {
			Node cur = nodes.remove(0);
			vis.set(cur.n);

			BitSet newVis = new BitSet(N);
			newVis.set(cur.n);
			
			Queue<Node> q = new ArrayDeque<Node>();
			q.add(cur);
			while (!q.isEmpty()) {
				cur = q.poll();
				for (int i = 0; i < N; i++) {
					if (!vis.get(i) && cur.adj.get(i)) {
						q.add(OGnodes.get(i));
						nodes.remove(OGnodes.get(i));
						vis.set(i);
						newVis.set(i);
						danger *= 2;
					}
				}
			}
			
			for (Node x : nodes)
			{
				x.adj.xor(newVis);
			}
			Collections.sort(nodes);
		}
		
		System.out.println(danger);
	}

	private static class Node implements Comparable<Node> {
		BitSet adj;
		int n;

		public Node(int n) {
			this.n = n;
			adj = new BitSet(N);
		}

		@Override
		public int compareTo(Node o) {
			return o.adj.size() - this.adj.size();
		}

		public int hashCode() {
			return n;
		}
	}

}
