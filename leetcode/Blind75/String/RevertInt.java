package Blind75.String;
public class RevertInt{
    public static long revertInt(int num){
        long  res = 0;
        while(num!=0){
            res = res*10 + num%10;
            num = num/10;
        }
        if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE){
            return 0;
            
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(revertInt(1200556));
    }
}