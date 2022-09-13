package demo;

import java.util.Arrays;

public class MColoring {

	public static void colorGraph(int[][] graph, int vertices, int colors) {

		int[] currentColorPath = new int[vertices];
		Arrays.fill(currentColorPath, -1);
		for (int v = 0; v < vertices; v++) {
			solve(graph, vertices, colors, currentColorPath, v);
			Arrays.fill(currentColorPath, -1);
		}

	}

	public static void solve(int graph[][], int vertices, int colors, int[] currentColorPath, int vertexToColor) {

		if (vertexToColor == graph.length) { // all are colored safely or we exhausted the choice
			if (Arrays.stream(currentColorPath).allMatch(i -> i > -1)) {
				for (int i = 0; i < currentColorPath.length; i++) {
					System.out.printf("Node %d , color %d \n", i + 1, currentColorPath[i] + 1);
				}
				System.out.println();
			}

			return;
		} else {

			for (int c = 0; c < colors; c++) {
				if (isColorSafe(graph, currentColorPath, vertexToColor, c)) {
					currentColorPath[vertexToColor] = c;
					solve(graph, vertices, colors, currentColorPath, vertexToColor + 1);
					currentColorPath[vertexToColor] = -1;
				}
			}

		}
	}

	public static boolean isColorSafe(int[][] graph, int[] currentColorPath, int currentVertex, int currentColor) {
		int[] neighobur = graph[currentVertex];
		for (int i = 0; i < neighobur.length; i++) {
			if (neighobur[i] != 0 && currentColor == currentColorPath[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int graph[][] = { { 0, 1, 1, 0 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 0, 1, 1, 0 } };
		colorGraph(graph, 4, 3);

	}
}
