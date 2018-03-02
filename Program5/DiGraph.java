import java.util.LinkedList;

public class DiGraph {
	private LinkedList<Integer>[] linkedListArray;
	
	public DiGraph(int n) {
		linkedListArray = new LinkedList[n];
	}
	
	public void addEdge(int from, int to) {
		if (linkedListArray[from-1].contains(to-1)) {
			return;
		}
		linkedListArray[from-1].add(to-1);
	}
	
	public void deleteEdge(int from, int to) {
		linkedListArray[from-1].remove(to-1);
	}
	
	public int edgeCount() {
		int edgeSum = 0;
		for (int i = 0; i < linkedListArray.length; i++) {
			edgeSum += linkedListArray[i].size();
		}
		return edgeSum;
	}
	
	public int vertexCount() {
		return linkedListArray.length;
	}
	
	public void print() {
		for (int i = 0; i < linkedListArray.length; i++) {
			System.out.print((i+1) + " is connected to: ");
			for (int j = 0; j < linkedListArray[i].size(); j++) {
				System.out.print(linkedListArray[i].get(j) + 1);
				if (j != linkedListArray[i].size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
	
}
