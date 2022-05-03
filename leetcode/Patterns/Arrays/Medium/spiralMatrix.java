package Patterns.Arrays.Medium;
/**
 * #54 Spiral Matrix
 *  * Given an m x n matrix, return all elements of the matrix in spiral order.
 * #59 Spiral Matrix II
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * n=3
 * 1->2->3
 * 8->9  4
 * 7<-6<-5
 * 
 */
public class spiralMatrix {
    /**59
     * 坚持循环不变量原则。
     * 模拟顺时针画矩阵的过程:画每四条边，每画一条边都要坚持一致的左闭右开; 每一个拐角处的处理规则，拐角处让给新的一条边来继续画
     * 填充上行从左到右
     * 填充右列从上到下
     * 填充下行从右到左
     * 填充左列从下到上
     * 一个圈是四条边，一个loop， n*n的矩阵有n/2个loop
     * 
     */
    public int[][] generateMatrixII(int n) {
        int[][] res = new int[n][n];
        //the time of loop
        int loop = n/2;
        //the start position of each loop
        int startX = 0;
        int startY = 0;
        while(loop>0){
            for()
        }
    }
}
