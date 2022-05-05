package Tree.BFS;
import java.util.*;
import Tree.TreeNode;


//#297
//Serialize BT preorder
// using StringBuffer sb as helper, serialize a bt to a string
public class SerializeDeserializeBT {

    final String SEPERATE = ",";
    final String NULL = "#";

    // encodes a tree to a single string
    //// Serialize BT preorder
    // using StringBuffer sb as helper, serialize a bt to a string
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }

    // a helper method to generate sb
    private StringBuilder serial(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return sb.append(NULL);
        }
        sb.append(root.val).append(SEPERATE);
        serial(sb, root.left).append(SEPERATE);
        serial(sb, root.right);
        return sb;
    }

    // decode a string to Tree
    public TreeNode deserialize(String str) {
        Queue<String> q = new LinkedList<String>();
        LinkedList<String> data = (LinkedList<String>) Arrays.asList(str.split(SEPERATE));
        q = data;
        return deserial(q);
    }

    // transfer the str to queue to decode
    // Use queue to simplify position move
    private TreeNode deserial(Queue<String> q) {
        String val = q.poll();
        if (NULL.equals(val))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }

}
