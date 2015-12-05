/**
 * Data Structures
 * Assignment #5: Lazy Lazar's Delivery Service
 * Ryan Blais
 * 12/04/15
 * 
 * This program will be designed to create an undirected weighted graph
 * structure for a man's delivery service. The program will also utilize
 * both minimum cost spanning tree and node connectivity algorithms. The
 * program will create the graph by reading in a list of node of each stop
 * that the man must take along with the vertices between these nodes. The
 * man can only travel on paved roads that do not increase in elevation.
 */

package assignment05;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// Input node data into graph structure
		int numberOfNodes = input.nextInt();
		Graph graph = new Graph(numberOfNodes);
		for (int i = 0; i < numberOfNodes; i++) {
			int elevation = input.nextInt();
			String name = input.next();
			Vertex vertex = new Vertex(name, elevation);
			graph.vertices[i] = vertex;
		}

		Arrays.sort(graph.vertices);// Put in alphabetical order

		// Input edge data in graph structure
		int numOfEdges = input.nextInt();
		for (int i = 0; i < numOfEdges; i++) {
			boolean paved = input.next().equals("P");
			int length = input.nextInt();
			int fromIndex = Arrays.binarySearch(graph.vertices, input.next());
			int toIndex = Arrays.binarySearch(graph.vertices, input.next());
			Edge edge = new Edge(paved, length);
			graph.edges[fromIndex][toIndex] = edge;
			graph.edges[toIndex][fromIndex] = edge;
		}

		// Print Minimum Spanning Tree and the Total Cost
		graph.printMinimumSpanningTree();

		System.out.println();
		System.out
				.println("Enter a series of two locations to be connected "
						+ "(enter quit to terminate): ");

		graph.removeDirt();
		graph.removeUphill();

		// Shortest Possible Path
		String to = "", from = "";

		// Except locations to connect until terminated
		while (true) {
			from = input.next();
			if (from.equalsIgnoreCase("quit"))
				return;
			to = input.next();
			graph.printShortestPath(from, to);

		}
	}
}
