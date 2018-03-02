import java.util.Scanner;

public class DiGraphTest {

	public static void main(String[] args) {
		int vertices; 
		String choice;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of vertices");
		vertices = in.nextInt();
		DiGraph diGraph = new DiGraph(vertices);
		
		System.out.println("Choose one of the following operations:");
		System.out.println("- add edge (enter a) ");
		System.out.println("- delete edge (enter d) ");
		System.out.println("- edge count (enter e)");
		System.out.println("- vertex count (enter v)");
		System.out.println("- print graph (enter p)");
		System.out.println("- Quit (enter q)");
		choice = in.next();
		
		while (choice != "q") {
			int from, to;
			switch(choice) {
				case ("a"):
					System.out.println("Enter two vertices for edge to add.");
					from = in.nextInt();
					to = in.nextInt();
					
					diGraph.addEdge(from, to);
					System.out.println("Edge (" + from + ", " + to + ") added.");
					
					break;
				case ("d"):
					System.out.println("Enter two vertices for edge to delete.");
					from = in.nextInt();
					to = in.nextInt();
					
					diGraph.deleteEdge(from, to);
					System.out.println("Edge (" + from + ", " + to + ") deleted.");
					
					break;
				case ("e"):
					System.out.println("Edge count is: " + diGraph.edgeCount());
					
					break;
				case ("v"):
					System.out.println("Vertex count is: " + diGraph.vertexCount());
					
					break;
				case ("p"):
					diGraph.print();
					
					break;
				default:
					// nothing
			}
			System.out.println(choice);
			if (choice != "q") {
				choice = in.next();
			}
		}
		
	}

}
