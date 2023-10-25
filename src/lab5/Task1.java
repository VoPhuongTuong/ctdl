package lab5;

public class Task1 {
	public static void printMatrix(int[][] matrix) {
	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[i].length; j++) {
	            System.out.print(matrix[i][j] + " ");
	        }
	        System.out.println();
	    }
	    System.out.println();
	}
	public static int[] [] add(int[] [] a,int[] []b){
		int rows = a.length;
		int cols=a[0].length;
		int[] [] result=new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				result[i][j]=a[i][j]+b[i][j];
			}
		}
		return result;
	}
	public static int[][] subtract(int[][] a, int[][] b) {
	    int rows = a.length;
	    int cols = a[0].length;
	    int[][] result = new int[rows][cols];	    
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            result[i][j] = a[i][j] - b[i][j];
	        }
	    }	    
	    return result;
	}
	public static int[][] multiply(int[][] a, int[][] b) {
	    int rowsA = a.length;
	    int colsA = a[0].length;
	    int colsB = b[0].length;	    
	    int[][] result = new int[rowsA][colsB];	    
	    for (int i = 0; i < rowsA; i++) {
	        for (int j = 0; j < colsB; j++) {
	            for (int k = 0; k < colsA; k++) {
	                result[i][j] += a[i][k] * b[k][j];
	            }
	        }
	    }
	    return result;
	}
	public static int[][] transpose(int[][] a) {
	    int rows = a.length;
	    int cols = a[0].length;
	    
	    int[][] result = new int[cols][rows];
	    
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            result[j][i] = a[i][j];
	        }
	    }
	    
	    return result;
	}
public static void main(String[] args) {
	int[][] a= {{1,3},{4,5}};
	int[][] b= {{5,4,3},{5,7,8}};
	int[][] c=add(a, b);
	printMatrix(c);
	int[][] d=subtract(a, b);
	printMatrix(d);
	int[][] e=multiply(a, b);
	printMatrix(e);
	int[][] f=transpose(b);
	printMatrix(f);
			}
}
