package demo;

import java.util.ArrayList;
import java.util.List;

public class AllPathToDestination {

	private List<List<Integer>> allPaths;
	private List<Integer> currentPath;

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		currentPath = new ArrayList<>();
		allPaths = new ArrayList<>();
		int nodes = graph.length;
		allPathsSourceTarget(graph, nodes, 0, nodes - 1, currentPath);
		return allPaths;
	}

	private void allPathsSourceTarget(int[][] graph, int nodes, int src, int dest, List<Integer> currentPath) {

		if (src == dest) {
			currentPath.add(src);
			List<Integer> currentpathList = new ArrayList<Integer>(currentPath);
			allPaths.add(currentpathList);

			currentPath.remove(currentPath.size() - 1);
			return;
		} else {

			currentPath.add(src); // choose
			int size = currentPath.size();

			// work with current choice
			for (int j = 0; j < graph[src].length; j++) {
				allPathsSourceTarget(graph, nodes, graph[src][j], dest, currentPath);
			}
			// unchoose
			currentPath.remove(size - 1);

		}
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };

		AllPathToDestination d = new AllPathToDestination();
		List<List<Integer>> res = d.allPathsSourceTarget(graph);
		for (List<Integer> result : res)
			System.out.println(result);

		
	}
}
