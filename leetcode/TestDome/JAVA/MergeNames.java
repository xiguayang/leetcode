package TestDome.JAVA;
import java.util.HashSet;
import java.util.Set;

public class MergeNames {
    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> resSet = new HashSet<>();
        for(int i = 0; i<names1.length;i++){
            resSet.add(names1[i]);
        }
        for(int i = 0; i<names2.length;i++){
            resSet.add(names2[i]);
        }
        // throw new UnsupportedOperationException("Waiting to be implemented.");
        int n = resSet.size();
        String res[] = new String[n];
  
        int i = 0;
        for (String x : resSet)
            res[i++] = x;
        return res;

    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
