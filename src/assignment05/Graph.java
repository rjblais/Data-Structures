/**
 * Data Structures
 * Assignment #5: Lazy Lazar's Delivery Service
 * Ryan Blais
 * 12/04/15
 * 
 * Graph data structure implementation
 */

package assignment05;

import java.util.Arrays;

public class Graph {
	public Edge[][] edges;
	public int numVertices;
	public Vertex[] vertices;

	public Graph(int numVertices) {
		this.numVertices = numVertices;
		edges = new Edge[numVertices][numVertices];
		vertices = new Vertex[numVertices];
	}

	private int getWeight(int x, int y) {
		return edges[x][y] == null ? Integer.MAX_VALUE : edges[x][y].length;

	}

	public void printMinimumSpanningTree() {
		boolean[] reached = new boolean[vertices.length];
		// int[] treeEdges = new int[vertices.length];
		int cost = 0;

		reached[0] = true;

		for (int v = 1; v < vertices.length; v++) {
			int x = 0, y = 0;

			for (int i = 0; i < vertices.length; i++) {

				for (int j = 0; j < vertices.length; j++) {

					if (reached[i] && !reached[j]
							&& getWeight(i, j) < getWeight(x, y)) {
						x = i;
						y = j;
					}
				}
			}
			// treeEdges[y] = x;
			if (edges[x][y] != null) {
			System.out.println(vertices[x].name + " to " + vertices[y].name
					+ " " + edges[x][y].length);
			cost += edges[x][y].length;
			reached[y] = true;
			} else {
				cost = Integer.MIN_VALUE;
			}
		}
		
		System.out.println("====");
		if (cost > 0) {
			System.out.println("Total Cost of Minimum Spanning Tree: " + cost);
		} else {
			System.out.println("No minimum spanning tree.");
		}
	}

	public void removeDirt() {
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				if (edges[i][j] != null && !edges[i][j].paved) {
					edges[i][j] = null;
				}
			}
		}
	}

	public void removeUphill() {
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				if (edges[i][j] != null && vertices[i].elevation < vertices[j].elevation) {
					edges[i][j] = null;
				}
			}
		}
	}

	public void printShortestPath(String from, String to) {
		int fromIndex =	Arrays.binarySearch(vertices, from);
		int toIndex = Arrays.binarySearch(vertices, to);
		
		int[] lengths = new int[vertices.length];
		int[] paths = new int[vertices.length];
		boolean[] reached = new boolean[vertices.length];
		reached[fromIndex] = true;
		
		for (int v = 0; v < vertices.length; v++) {
			if (edges[fromIndex][v] != null) {
				lengths[v] = edges[fromIndex][v].length;
				paths[v] = fromIndex;
			} else {
				lengths[v] = Integer.MAX_VALUE;
				paths[v] = -1;
			}
		}
		
		for (int i = 1; i < vertices.length; i++) {
			int min = Integer.MAX_VALUE, w = -1;
			// Find the current minimum that has not been reached
			for (int m = 0; m < vertices.length; m++) {
				if (reached[m]) continue;
				if (lengths[m] > 0 && lengths[m] < min) {
					min = lengths[m];
					w = m;
				}
			}
			if (w == -1) break; // TODO this might not be needed
			reached[w] = true;
			for (int v = 0; v < vertices.length; v++) {
				if (reached[v]) continue;
				// Leave the least cost path as it is or update it if a shorter one has been found
				if (edges[w][v] != null && lengths[v] > lengths[w] + edges[w][v].length) {
					lengths[v] = lengths[w] + edges[w][v].length;
					paths[v] = w;
				}
			}
		}
		
		// Build output
		int current = toIndex;
		if (paths[current] == -1) {
			System.out.println("No acceptable path exists.");
			return;
		}
		String expression = "] " + lengths[current];
		while (true) { // Trace backward through the path and build output
			expression = vertices[current].name + expression;
			
			if (current != fromIndex) expression = " to " + expression;
			else break;
			
			current = paths[current];
		}
		expression = "[" + expression;
		System.out.println(expression);
	}
}
