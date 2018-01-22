import java.io.File;
import com.sun.java_cup.internal.runtime.Scanner;

public class MatrixWork {
    
    public static void main(String[] args) {
        System.out.println("Enter input-file name: ");
        Scanner in = new Scanner();
        File inputFile = new File(in.next());
        Scanner file = new Scanner(inputFile);
        
        int rowsA = file.next();
        int colsA = file.next();
        int[][] A = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                A[i][j] = file.nextInt();
            }
        }

        int rowsB = file.next();
        int colsB = file.next();
        int[][] B = new int[rowsB][colsB];
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                B[i][j] = file.nextInt();
            }
        }

        int[][] C = new int[rowsA][colsB];
        C = matrixProduct(A, B);
 
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
            for (int j = 0; j < colsA; j++) {
                C[i][j] += A[i][j] * B[
            }
        } 
    }
}
