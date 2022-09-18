package com.alpha;

import java.util.ArrayList;
import java.util.List;

public class HamiltonianPath {

	static int conf = 0;

	public static void main(String[] args) {

		// @formatter:off
 
		int[][] graph = { 
				{0,1,1,1},
				{1,0,0,0},
				{1,0,0,1},
				{1,0,1,0}
		};
		// @formatter:on

		hamiltonPath(graph);

		System.out.println(conf);
	}

	public static void hamiltonPath(int[][] graph) {

		boolean[] visited;

		for (int i = 0; i < graph.length; i++) {
			visited = new boolean[graph.length];
			enumurateGraph(graph, visited, i, 1, new ArrayList<>());
		}
	}

	public static void enumurateGraph(int[][] graph, boolean[] visited, int vertexToVisit, int depth,
			List<Integer> currentPath) {

		if (depth == visited.length) {
			List<Integer> res = new ArrayList<>(currentPath);
			res.add(vertexToVisit);
			System.out.println(res);
			conf += 1;
			return;
		}

		// choose
		visited[vertexToVisit] = true;
		currentPath.add(vertexToVisit);

		// explore
		for (int i = 0; i < graph.length; i++) {
			if (graph[vertexToVisit][i] == 1) {
				if (!visited[i]) {
					enumurateGraph(graph, visited, i, depth + 1, currentPath);
				}
			}
		}
		// unchoose
		visited[vertexToVisit] = false;
		currentPath.remove(currentPath.size() - 1);

	}
}
