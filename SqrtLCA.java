import java.util.ArrayList;
import java.util.List;

class Graph {

	private List<Integer>[] adjList;
	private int V;
	private int E;

	@SuppressWarnings("unchecked")
	public Graph(int n) {
		V = n;
		adjList = (List<Integer>[]) new List[V + 1];
		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int u, int v) {
		E++;
		this.adjList[u].add(v);
		this.adjList[v].add(u);
	}

	public List<Integer> adj(int v) {
		return adjList[v];
	}

	public int vertices() {
		return V;
	}

	public int edges() {
		return E;
	}

}

class DepthFirstSearch {

	private boolean marked[];
	private int parent[];
	private int depth[];
	private int ancesterInUpperBlock[];
	int blocks;

	public DepthFirstSearch(Graph G, int root, int block) {
		int V = G.vertices();
		marked = new boolean[V + 1];
		parent = new int[V + 1];
		depth = new int[V + 1];
		this.blocks = block;
		ancesterInUpperBlock = new int[V + 1];
		initRoot(root);
		dfs(G, root);

	}

	private void initRoot(int root) {
		ancesterInUpperBlock[root] = root;
		parent[root] = root;
		depth[root] = 0;
	}

	private void dfs(Graph G, int i) {
		marked[i] = true;
		for (int w : G.adj(i)) {
			if (!marked[w]) {
				parent[w] = i;
				depth[w] = depth[i] + 1;
				if (depth[w] % blocks == 0) {
					ancesterInUpperBlock[w] = parent[w];
				} else {
					ancesterInUpperBlock[w] = ancesterInUpperBlock[parent[w]];
				}
				dfs(G, w);

			}
		}

	}

	public int[] parent() {
		return parent;
	}

	public int[] depth() {
		return depth;
	}

	public int[] ancestorInUpperBlock() {
		return ancesterInUpperBlock;
	}
}

class SqrtLCAHelper {

	private int parent[];

	private int depth[];
	private int ancestorInUpperBlock[];

	public SqrtLCAHelper(int[] parent, int[] depth, int[] ancestorInUpperBlock) {
		super();
		this.parent = parent;
		this.depth = depth;
		this.ancestorInUpperBlock = ancestorInUpperBlock;
	}

	public int sqrtLCA(int x, int y) {

		while (ancestorInUpperBlock[x] != ancestorInUpperBlock[y]) {
			if (depth[x] > depth[y]) {
				x = ancestorInUpperBlock[x];
			} else {
				y = ancestorInUpperBlock[y];
			}

		}
		return linerLCA(x, y);
	}

	public int linerLCA(int x, int y) {
		if (x == y)
			return x;
		if (depth[x] > depth[y])
			x = parent[x];
		else
			y = parent[y];
		return linerLCA(x, y);

	}

}

public class SqrtLCA {

	public static void main(String[] args) {

		Graph g = new Graph(35);
		
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 6);
		g.addEdge(3, 7);
		g.addEdge(4, 8);
		g.addEdge(6, 9);

		g.addEdge(6, 10);
		g.addEdge(6, 11);
		g.addEdge(8, 12);
		g.addEdge(9, 13);
		g.addEdge(9, 14);
		g.addEdge(11, 15);
		g.addEdge(12, 16);
		g.addEdge(14, 17);

		g.addEdge(14, 18);
		g.addEdge(14, 19);
		g.addEdge(15, 20);
		g.addEdge(15, 21);
		g.addEdge(17, 22);
		g.addEdge(19, 23);
		g.addEdge(19, 24);
		g.addEdge(21, 25);
		g.addEdge(21, 26);
		g.addEdge(23, 27);
		g.addEdge(23, 28);
		g.addEdge(25, 29);
		g.addEdge(25, 30);
		g.addEdge(28, 31);
		g.addEdge(28, 32);
		g.addEdge(28, 33);

		g.addEdge(30, 34);
		g.addEdge(30, 35);

		DepthFirstSearch d = new DepthFirstSearch(g, 1, 3);

		// System.out.println(Arrays.toString(d.parent()));
		// System.out.println(Arrays.toString(d.depth()));
		// System.out.println(Arrays.toString(d.ancestorInUpperBlock()));
		SqrtLCAHelper lca = new SqrtLCAHelper(d.parent(), d.depth(), d.ancestorInUpperBlock());
		System.out.println(lca.sqrtLCA(27, 16));

	}
}
