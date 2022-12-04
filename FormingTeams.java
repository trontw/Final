
import java.util.Scanner;
import java.util.ArrayList; // This is a dynamic array (an array the expands when needed)
public class FormingTeams {
	private static int n; // The number of nodes
	private static int m; // The number of edges

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();

		// An adjacency list is an array of arrays (or array of ArrayList objects)
		ArrayList<Integer> [] adjacency_list = new ArrayList[n+1];
		for (int i = 0; i < n+1; ++i)
			adjacency_list[i] = new ArrayList<Integer>();

		// Read the edges and build the adjacency list. adjacency_list[x] contains the neighbor of x.
		for (int i = 0; i < m; ++i) {
			int a = kb.nextInt();
			int b = kb.nextInt();

			adjacency_list[a].add(new Integer(b));
			adjacency_list[b].add(new Integer(a));
		}
		// adjacency_list[x] contains the neighbors of x. You can iterate through them as...
		// for (Integer y: adjacency_list[x]) {
		//   y is a neighbor of x. But it is an Integer object.
		//   int z = y.intValue() is the neighbor, which is of type int.
		//   ...
 		//}

		// TODO: Code to form teams using depth-first search
	
 }
}
