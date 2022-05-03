package TestDome.JAVA;
/** 
 * boolean[][] mapMatrix = 
 * {
    {true,  false, false},
    {true,  true,  false},
    {false, true,  true}
    };
        
routeExists(0, 0, 2, 2, mapMatrix);
 * 
 * 
*/
public class RoutePlanner {

    //My Solution: do not consider go left or go up if the left/up not visited
    // public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix) {
    //     int numOfRow = mapMatrix.length;
    //     int numOfColumn = mapMatrix[0].length;
    //     //exit is false return false
    //     if(!mapMatrix[toRow][toColumn]){
    //         return false;
    //     }
    //     if(fromRow>=numOfRow||fromColumn>=numOfColumn||toRow>=numOfRow||toColumn>=numOfColumn)
    //         return false;
    //     int i = fromRow;
    //     int j = fromColumn;
    //     while(i<numOfRow-1 & j<numOfColumn-1 & i!=toRow & j!=toColumn ){
    //         if(isRightRoad(i, j, mapMatrix)){
    //             j=j+1;
    //         }else{
    //             if(isBlewRoad(i,j,mapMatrix)){
    //                 i=i+1;
    //             }else{
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;


    // }
    // public static boolean isRightRoad(int fromRow, int fromColumn, boolean[][] mapMatrix){
    //     int numOfColumn = mapMatrix[0].length;
    //     if(fromColumn<numOfColumn-1 & mapMatrix[fromRow][fromColumn+1]==true){
    //         return true;
    //     }
    //     return false;
    // }
    // public static boolean isBlewRoad(int fromRow, int fromColumn, boolean[][] mapMatrix){
    //     int numOfRow = mapMatrix.length;
    //     if(fromRow<numOfRow-1 & mapMatrix[fromRow+1][fromColumn]==true){
    //         return true;
    //     }
    //     return false;
    // }
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix) {
        //use a new 2-d array to record if the node has been visted or not
        boolean[][] mapVisited = new boolean[mapMatrix.length][mapMatrix[0].length];   
        return routeSearch(fromRow, fromColumn, toRow, toColumn,mapMatrix, mapVisited);  
    }
    // a helper method with memo
    public static boolean routeSearch(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix, boolean[][] mapVisited) {
        // out of boundrary
        if(fromRow < 0 || fromColumn < 0 || fromRow >= mapMatrix.length || fromColumn >= mapMatrix[0].length)
            return false;
        // if return back to the start point or start and exit is false
        if(mapVisited[fromRow][fromColumn] || !mapMatrix[fromRow][fromColumn]|| !mapMatrix[toRow][toColumn])
            return false;
        //if start equals false
        if(fromRow == toRow && fromColumn == toColumn)
            return true;
        //initialize the start point as visited
        mapVisited[fromRow][fromColumn] = true;
        // 4 directions: left right up down any way is true return true;
        return routeSearch(fromRow-1, fromColumn, toRow, toColumn, mapMatrix, mapVisited)
            || routeSearch(fromRow, fromColumn-1, toRow, toColumn, mapMatrix, mapVisited)
            || routeSearch(fromRow+1, fromColumn, toRow, toColumn, mapMatrix, mapVisited)            
            ||routeSearch(fromRow, fromColumn+1, toRow, toColumn, mapMatrix, mapVisited);
    }
        
    public static void main(String[] args) {
        boolean[][] mapMatrix = {
            {true,  false, false},
            {true,  true,  false},
            {false, true,  true}
        };
        
        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
