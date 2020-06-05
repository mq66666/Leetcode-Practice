import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Travesal {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> level = new ArrayList<List<Integer>>();
            if(root == null){
                return level;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            int queue_size;
            queue.add(root);
            while (!queue.isEmpty()) {
                queue_size = queue.size();
                List<Integer> l = new ArrayList<>();
                while (queue_size != 0) {
                    queue_size--;
                    TreeNode n = queue.poll();
                    l.add(n.val);
                    if (n.left != null) queue.add(n.left);
                    if (n.right != null) queue.add(n.right);
                }
                level.add(l);
            }
            return level;
        }
    }
}
