
public class RunTimes {
	static long startTime;
	static long endTime;
	static long time;
	
	public static void main(String args[]) {
		
		System.out.println("Logarithmic algorithm's running times:");
		for (long N = 1000; N<100000000; N *= 2) {
			startTime = System.nanoTime();
			Algorithms.logarithmicAlgorithm(N);
			endTime = System.nanoTime();
			time = (endTime - startTime) / 1000000;
			System.out.println("T(" + N + ") = " + time);
		}

		System.out.println("");
		
		System.out.println("Linear algorithm's running times:");
		for (long N = 1000; N<100000000; N *= 2) {
			startTime = System.nanoTime();
			Algorithms.linearAlgorithm(N);
			endTime = System.nanoTime();
			time = (endTime - startTime) / 1000000;
			System.out.println("T(" + N + ") = " + time);
		}
		
		System.out.println("");

		System.out.println("NlogN algorithm's running times:");
		for (long N = 1000; N<100000000; N *= 2) {
			startTime = System.nanoTime();
			Algorithms.NlogNAlgorithm(N);
			endTime = System.nanoTime();
			time = (endTime - startTime) / 1000000;
			System.out.println("T(" + N + ") = " + time);
		}
		
		System.out.println("");

		System.out.println("Quadratic algorithm's running times:");
		for (long N = 1000; N<=512000; N *= 2) {
			startTime = System.nanoTime();
			Algorithms.quadraticAlgorithm(N);
			endTime = System.nanoTime();
			time = (endTime - startTime) / 1000000;
			System.out.println("T(" + N + ") = " + time);
		}
		
		System.out.println("");

		System.out.println("Cubic algorithm's running times:");
		for (long N = 1000; N<=8000; N *= 2) {
			startTime = System.nanoTime();
			Algorithms.cubicAlgorithm(N);
			endTime = System.nanoTime();
			time = (endTime - startTime) / 1000000;
			System.out.println("T(" + N + ") = " + time);
		}
		
	}

}
