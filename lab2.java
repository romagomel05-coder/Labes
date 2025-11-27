import java.util.*;
public class lab2{
    public static void main(String[] args){
        Task1.main();
        Task2.main();
    }
}

public class Task1{
    public static void main(){
        int[] arr = new int[8];
        System.out.println("\nTask 1:\n");
        for(int i = 0; i < 8; i++){
            arr[i] = getRndInt.rndInt();
            System.out.print(arr[i] + " ");
            if(i%2==0)arr[i]=0;
        }
        System.out.println();
        for(int elem : arr){
            System.out.print(elem + " ");
        }
    }
}

public class Task2{
    static Scanner input = new Scanner(System.in);
    public static void main(){
        System.out.println("\n\nTask 2:");
        int[][] matrix = new int[3][3];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = getRndInt.rndInt();
            }
        }
        printMatrix(matrix);
        int[] minCoor = getMinInMatrixCoor(matrix); // Coor[0] - x, Coor[1] - y;
        System.out.println("\n Min Coor: " + minCoor[0] + " " + minCoor[1]);
        int[] userCoor = new int[]{0, 0};
        userCoor[0] = input.nextInt();
        userCoor[1] = input.nextInt();
        if(userCoor[0]<=matrix.length && userCoor[1] <= matrix[0].length && userCoor[0]*userCoor[1]!=0){ // x ∈ [1; matrix.length]; y ∈ [1; matrix[0].length];
            userCoor[0]--;
            userCoor[1]--;
            rowsAndcolumnsSwap(matrix, minCoor, userCoor);
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix){
        System.out.println();
        for(int[] string : matrix){
            for(int elem : string){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void rowsAndcolumnsSwap(int[][] targetMatrix, int[] elem1Coor, int[] elem2Coor){
        int tmp;
        //Rows swap
        if(elem1Coor[0]!=elem2Coor[0]){
            for(int j = 0; j < targetMatrix[0].length; j++){
                tmp = targetMatrix[elem1Coor[0]][j];
                targetMatrix[elem1Coor[0]][j] = targetMatrix[elem2Coor[0]][j];
                targetMatrix[elem2Coor[0]][j] = tmp;

            }
        }
        // Columns swap
        if(elem1Coor[1]!=elem2Coor[1]){
            for(int i = 0; i < targetMatrix.length; i++){
                tmp = targetMatrix[i][elem1Coor[1]];
                targetMatrix[i][elem1Coor[1]] = targetMatrix[i][elem2Coor[1]];
                targetMatrix[i][elem2Coor[1]] = tmp;

            }
        }
        
        
    }

    public static int[] getMinInMatrixCoor(int[][] matrix){ // Return first min coor;
        int min = 0xFFFFFFF;
        int[] minCoor = {0, 0};
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j]<min){
                    min = matrix[i][j];
                    minCoor = new int[]{i, j};
                }
            }
        }
        return minCoor;
    }
}

public interface getRndInt{
    public static int rndInt(){ 
        return (int)(Math.random() * 9)+1;
    }
}