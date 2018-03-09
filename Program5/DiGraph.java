import java.util.LinkedList;

import java.util.Queue;

public class DiGraph {
	private LinkedList<Integer>[] linkedListArray;
	
	public DiGraph(int n) {
		linkedListArray = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			linkedListArray[i] = new LinkedList<Integer>();
		}
	}
	
	// Ask - Validity check for vertex in graph?
	// Ask - can we return value?
	// Natural indexing?
	public boolean addEdge(int from, int to) {
		//if (linkedListArray[from-1] != null) {
		if (linkedListArray[from-1].contains(to)) {
			return false;
		}
		linkedListArray[from-1].add(to);
		return true;
	}
	
	public void deleteEdge(int from, int to) {
		int index = linkedListArray[from-1].indexOf(to);
		linkedListArray[from-1].remove(index);
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
				System.out.print(linkedListArray[i].get(j));
				if (j != linkedListArray[i].size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
	
	private int[] indegrees() {
		int n = linkedListArray.length;
		int[] indegrees = new int[n];
		//System.out.println("indegrees: ");
		for (int u = 0; u < n; u++) { // loop through vertex array
			for (int v = 0; v < linkedListArray[u].size(); v++) { // loop through each linked list
				indegrees[linkedListArray[u].get(v) - 1] += 1;
			}
		}
		/*for (int i = 0; i < n; i++) {
			System.out.print(indegrees[i]);
		}
		System.out.println();*/
		return indegrees;
	}
	
	public int[] topSort() throws IllegalArgumentException {
		int n = linkedListArray.length;
		int []indegrees = indegrees();
		int[] a = new int[n];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int u = 0; u < n; u++) {
			if (indegrees[u] == 0) {
				q.add(u+1);
			}
		}
		int i = 0;
		while (!q.isEmpty()) {
			//System.out.println("i: " + i);
			int u = q.remove();
			a[i] = u;
			i++;
			for (int v = 0; v < linkedListArray[u-1].size(); v++) {
				indegrees[linkedListArray[u-1].get(v) - 1]--;
				if (indegrees[linkedListArray[u-1].get(v) - 1] == 0) {
					q.add(linkedListArray[u-1].get(v));
				}
			}	
		}
		//System.out.println("i: " + i);
		if (i != n) {
			throw new IllegalArgumentException();
		}
		return a;
	}
	
}
