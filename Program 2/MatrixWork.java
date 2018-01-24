import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrixWork {
    
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter input-file name: ");
        Scanner in = new Scanner(System.in);
        File inputFile = new File(in.next());
        Scanner file = new Scanner(inputFile);
        
        int rowsA = file.nextInt();
        int colsA = file.nextInt();
        int[][] A = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                A[i][j] = file.nextInt();
            }
        }

        int rowsB = file.nextInt();
        int colsB = file.nextInt();
        int[][] B = new int[rowsB][colsB];
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                B[i][j] = file.nextInt();
            }
        }

        int[][] C = new int[rowsA][colsB];
        try {
        		C = matrixProduct(A, B);
        }
        catch (IllegalArgumentException e) {
        		System.out.println("Error: Matrices not compatable for mulitplication");
        		return;
        }
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println("");
        }
        
    }
    
    public static int[][] matrixProduct (int [][] A, int[][] B) throws IllegalArgumentException {
        if (!(A[0].length == B.length)) {
            throw new IllegalArgumentException();
        }
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;
        int[][] C = new int[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k=0; k< colsA; k++) {
                	   C[i][j] += A[i][k] * B[k][j];
                }
            }
        } 
        return C;
    }
}
