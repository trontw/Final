
import java.util.Scanner;
import java.util.ArrayList; // This is a dynamic array (an array the expands when needed)
public class FormingTeams {
	private static int n; // The number of nodes
	private static int m; // The number of edges
	private static ArrayList<Integer> adjacency_list;
	private static int [][] T;//Team : a double array for Team nodes: <student #> <Team: 1 or 2>
	//private static int [][] T2;//Team 2: a double array for Team 1 nodes: <student #> <Team: 1 or 2>
	
	//Method to place Students on a Team based on their neighbors
	public static void placeNTeam(int student_x, int neighbor){
		//Check if a member of Team 1 already
		if (T[student_x][1] == 1) {
			//place neighbors into Team 2 if not already on Team 2
			if ((T[neighbor][2] != 1) && (T[neighbor][1] == 0)) {
				T[neighbor][2] = 1;
			}
		} else if (T[student_x][2] == 1) {
			//place neighbors into Team 1 if not already on Team 1
			if ((T[neighbor][1] != 1) && (T[neighbor][2] == 0)) {
				T[neighbor][1] = 1;	
			}
			//Lastly, if not assigned, place on Team 1
		} else if ((T[student_x][1] == 0) && (T[neighbor][2] == 0)) {
			T[neighbor][1] = 1;
		}
	}
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		//System.out.println("Input for number of Ss = "+n);
		//System.out.println("Input for number of friendships = "+m);
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

		//Initialize Teams 1 and 2 [students][team: 0, 1, 2] -> 0 means unassigned
		T = new int[n + 1][3];
		//Initialize Team1 to zero (unassigned)
		for (int i = 0; i < (n + 1); ++i) {
			for (int j = 0; j < (3); ++j) {
				T[i][j] = 0;
			} 
		}

		// adjacency_list[x] contains the neighbors of x. You can iterate through them as...
		// for (Integer y: adjacency_list[x]) {
		//   y is a neighbor of x. But it is an Integer object.
		//   int z = y.intValue() is the neighbor, which is of type int.
		//   ...
 		//}
		//Initially set Student 1 to Team 1:
		//[1][0] -> Student 1 team unassigned
		//[1][1] -> Student 1 on team 1
		//[1][2] -> Student 1 on team 2
		T[1][1] = 1;
		int x = 0; 
		for (x = 0; x < n + 1; ++x) {
		 	for (Integer y: adjacency_list[x]) {// this loops through the neighbor x
				//converts the Integer object to int 
				//(z is a neighbor of x)
				//call placeNTeam to run the checks and adding to Teams
				int z = y.intValue();
				placeNTeam(x, z);
				//System.out.println("Neighbors of "+x+" are: "+z);
			}
		}
		int [] arr = new int[x + 1];
		for (int i = 1; i < x; ++i){
			for (int j = 0; j < 3; ++j){
				//System.out.print(" " + T[i][j]+" ");
			}
			if (T[i][1] == 1) {
				arr[i] = 1;
			} else if (T[i][2] == 1) {
				arr[i] = 2;
			} else {
				System.out.println("impossible");
				return;
			}
			//System.out.println();
		}
		//System.out.println("----------------");
		for (int k = 1; k < x; ++k) {
			System.out.print(arr[k]+" ");
		}
		System.out.println();

		// TODO: Code to form teams using depth-first search
	
 }
}
