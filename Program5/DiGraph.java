// Samantha Gunzl, Quinn Coleman
// sgunzl, qcoleman
// Program 5 
// 3/14/18

import java.util.LinkedList;

import java.util.Queue;

public class DiGraph {
	
	private class VertexInfo {
		
		// natural indexing
		private int distance;
		private int predecessor;
		
		public VertexInfo(int distance, int predecessor) {
			this.distance = distance;
			this.predecessor = predecessor;	
		}
	}
	
	
	private LinkedList<Integer>[] linkedListArray;
	
	private VertexInfo[] BFS(int s) {
		int N = linkedListArray.length;
		VertexInfo[] VA = new VertexInfo[N+1];
		for (int u=1; u<=N; u++) {
			VA[u].distance = -1;
			VA[u].predecessor = -1;
		}
		VA[s].distance = 0;
		Queue queue = new LinkedList<Integer>();
		queue.add(s);
		while (!queue.isEmpty()) {
			int u = (int) (queue.remove());
			for (int v=0; v<linkedListArray[u].size(); v++) { // for u's each adjacent vertex v
				if (VA[v+1].distance == -1) { // v not discovered yet
					VA[v+1].distance = VA[u].distance + 1;
					VA[v+1].predecessor = u;
					queue.add(v+1);
				}				
			}

		}
		return VA;
	
	}
	
	
	public boolean isTherePath(int from, int to) {
		VertexInfo[] VA = BFS(from);
		if (VA[to].predecessor == -1) {
			return false;
		}
		return true;
		
	}
	
	public int lengthOfPath(int from, int to) {
		//call BFS, use data from array
		VertexInfo[] VA = BFS(from);
		return VA[to].distance;
	}
	
	public void printPath(int from, int to) {
		VertexInfo[] VA = BFS(from);
		
		
	}
	
	public DiGraph(int n) {
		linkedListArray = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			linkedListArray[i] = new LinkedList<Integer>();
		}
	}

	public boolean addEdge(int from, int to) {
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
		for (int u = 0; u < n; u++) { // loop through vertex array
			for (int v = 0; v < linkedListArray[u].size(); v++) { // loop through each linked list
				indegrees[linkedListArray[u].get(v) - 1] += 1;
			}
		}

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
		if (i != n) {
			throw new IllegalArgumentException();
		}
		return a;
	}
	
}
