package Patterns.Arrays.Easy;
// 2022 Easy Array
public class ConvertArrayTo2D {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // m: rows
        // n: columns
        // 0,  1,  2, ... , n-1
        // n, n+1,n+2,... , 2n-1;
        //2n, 2n+1,2n+2,..., 3n-1;
        //.....
        //m-1,............  
        int length = original.length;
        int [][] res = new int[m][n];
        if(n*m!=length) return new int[0][0];;
        for(int i =0;i<length;i++){
            res[i/n][i%n]= original[i];
            // i = x*n+ y
            // x is the row index: x = i/n
            // y is the column index: y = i%n
            
        }
        return res;
    }
}
