import java.util.Scanner;

public class DiGraphTest {

	public static void main(String[] args) {
		int vertices; 
		String choice = "random";
		Scanner in = new Scanner(System.in).useDelimiter("\n| "); // | 
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
		
		in.nextLine();
		choice = in.nextLine();

		while (!choice.equals("q")) {
			int from, to;
				
						
			switch(choice) {
				case ("a"):
					System.out.println("Enter two vertices for edge to add.");
					from = in.nextInt();
					to = in.nextInt();
					
					if (diGraph.addEdge(from, to) == true) {
						System.out.println("Edge (" + from + ", " + to + ") added.");
					} else {
						System.out.println("Edge (" + from + ", " + to + ") is already in graph.");
					}
                                        in.nextLine();
					
					break;
				case ("d"):
					System.out.println("Enter two vertices for edge to delete.");
					from = in.nextInt();
                                        to = in.nextInt();
					
					diGraph.deleteEdge(from, to);
					System.out.println("Edge (" + from + ", " + to + ") deleted.");
                                        in.nextLine();
					
					break;
				case ("e"):
					System.out.println("Edge count is: " + diGraph.edgeCount());
					
                                        break;
				case ("v"):
					System.out.println("Vertex count is: " + diGraph.vertexCount());
					
					break;
				case ("p"):
					System.out.println("The graph is the following:");
					diGraph.print();
					
					break;
				case ("t"):
					try {
                                            int[] topSort = diGraph.topSort();
                                            System.out.println("The graph is the following:");
                                            for (int i = 0; i < topSort.length; i++) {
                                                    System.out.print(topSort[i]);
                                                    if (i != topSort.length - 1) {
                                                            System.out.print(", ");
                                                    }
                                            }
                                            System.out.println();
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Error: graph is cyclic.");
                                        }
                                        break;
				default:
					System.out.println("Invalid option.");
                                        break;
			}
                        
                        choice = in.nextLine();
                        if (choice.length() > 1) {
                            System.out.println("Invalid option.");
                            choice = in.nextLine();
                            
                        }
		}
                System.out.println("Good bye.");
		
	}

}
