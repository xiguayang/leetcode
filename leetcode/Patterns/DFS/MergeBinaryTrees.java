import java.util.Stack;

import javax.swing.event.TreeExpansionEvent;
import javax.swing.tree.TreeNode;
/**617 */
public class MergeBinaryTrees {
     //Recursion:
    //Time: O(N)
    //Space: O(N), O(height)
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //base case:
        if(root1==null && root2==null){
            return null;
        }else if(root1==null && root2!=null){
           return root2;
        }else if(root1!=null && root2==null){
            return root1;
        }else{
            //root1 root2 !=null
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right,root2.right);
            return root1;
        }
        
    }
    
    //Method 2: Iteraction
    // DFS using stack
    public TreeNode mergeTreesStack(TreeNode root1, TreeNode root2){
        if(root1 ==null) return root2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root1,root2});
        while(!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            if(nodes[0]==null || nodes[1]==null){
                continue;
            }
            nodes[0].val = nodes[0].val + nodes[1].val;
            if(nodes[0].left ==null){
                nodes[0].left = nodes[1].left;
            }else{
                stack.push(new TreeNode[] {nodes[0].left, nodes[1].left});
            }
            if(nodes[0].right == null){
                nodes[0].right = nodes[1].right;
            }else{
                stack.push(new TreeNode[]{nodes[0].right,nodes[1].right});
            }

        }
        return root1;
    }

  
  // Method 3: Iterative BFS
  // Time: O(n)
  // Space: O(n)
  public TreeNode mergeTreesBFS(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    // Use stack to help DFS
    Queue<TreeNode[]> queue = new LinkedList<>();
    queue.offer(new TreeNode[] {t1, t2});
    while (!queue.isEmpty()) {
      TreeNode[] cur = queue.poll();
      // no need to merge t2 into t1
      if (cur[1] == null) {
        continue;
      }
      // merge t1 and t2
      cur[0].val += cur[1].val;
      // if node in t1 == null, use node in t2 instead
      // else put both nodes in stack to merge
      if (cur[0].left == null) {
        cur[0].left = cur[1].left;
      } else {
        queue.offer(new TreeNode[] {cur[0].left, cur[1].left});
      }
      if (cur[0].right == null) {
        cur[0].right = cur[1].right;
      } else {
        queue.offer(new TreeNode[] {cur[0].right, cur[1].right});
      }
    }
    return t1;
  }
    
}
