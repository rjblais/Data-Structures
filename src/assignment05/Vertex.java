/**
 * Data Structures
 * Assignment #5: Lazy Lazar's Delivery Service
 * Ryan Blais
 * 12/04/15
 * 
 * Vertex information structure
 */

package assignment05;

public class Vertex implements Comparable<Object> {
	public String name;
	public int elevation;
	
	public Vertex(String name, int elevation) {
		this.name = name;
		this.elevation = elevation;
	}

	// Used to sort and binary search the vertex array
	@Override
	public int compareTo(Object o) {
		// Used for searching for names
		if (o instanceof String) return name.compareTo((String) o);
		// Used for sorting by name
		else if (o instanceof Vertex) return name.compareTo(((Vertex)o).name);
		return 1;
	}	
}
