package Patterns.Arrays.Medium;
/**
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *  You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation
 *  example:
 *    1  2  3  --->1
 *    4  5  6  --->2
 *    7  8  9  --->3  

 * 
 * Step 1: transpose the matrix, swap[i, j ]  ==>[j ,1]
 *   1  4  7  |   |   | 
 *   2  5  8  |   |   |
 *   3  6  9  \/  \/  \/
 *            1    2   3
 * Step 2: filp horizonally, swap [i, j]  ==> [i, matrix.length-1-j]
 * =>
 *    7  4  1    |   |   | 
 *    8  5  2    |   |   |
 *    9  6  3    \/  \/  \/
 *               3   2   1


*/
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //Step 1
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //Step 2
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
    
}
