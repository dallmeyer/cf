import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++)
		{
			nodes[i] = new Node(i);
		}
		
		for (int i = 1; i < n; i++)
		{
			int u = in.nextInt()-1,
				v = in.nextInt()-1;
			
			nodes[u].children.add(nodes[v]);
			nodes[v].children.add(nodes[u]);
		}
		
		boolean[] 	init = new boolean[n],
					goal = new boolean[n];
		
		for (int i = 0; i < n; i++)
		{
			init[i] = (in.nextInt() == 1);
		}
		for (int i = 0; i < n; i++)
		{
			goal[i] = (in.nextInt() == 1);
		}
		
		int numFlips = 0;
		ArrayList<Integer> toFlip = new ArrayList<Integer>();
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(nodes[0]);
		while (!q.isEmpty())
		{
			Node x = q.poll();
			
			if (init[x.i] != goal[x.i])
			{
				flip(x, init);
				numFlips++;
				toFlip.add(x.i + 1);
			}
			
			for (Node c : x.children)
			{
				c.children.remove(x);
				q.add(c);
			}
		}
		
		System.out.println(numFlips);
		for (Integer i : toFlip)
		{
			System.out.println(i);
		}
	}
	
	private static void flip(Node s, boolean[] init)
	{
		Queue<Tuple> q = new ArrayDeque<Tuple>();
		q.add(new Tuple(s, true));
		while (!q.isEmpty())
		{
			Tuple x = q.poll();
			if (x.flip)
			{
				init[x.node.i] = !init[x.node.i];
			}
			
			for (Node c : x.node.children)
			{
				c.children.remove(x.node);
				q.add(new Tuple(c, !x.flip));
			}
		}
	}
	
	private static class Tuple
	{
		Node node;
		boolean flip;
		
		public Tuple(Node n, boolean f)
		{
			this.node = n;
			this.flip = f;
		}
	}
	
	private static class Node
	{
		int i;
		ArrayList<Node> children;
		
		public Node(int i)
		{
			this.i = i;
			children = new ArrayList<Node>();
		}
	}

}
