import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Symmetric_Tree {

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
        public boolean isSymmetric(TreeNode root) {
            Boolean sol = false;
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }
            if ((root.right == null && root.left != null) || (root.left == null && root.right != null)) return false;
            queue.add(root.left);
            queue.add(root.right);
            while (!queue.isEmpty()) {
                TreeNode n1 = queue.poll();
                TreeNode n2 = queue.poll();
                if(n1 == null && n2 == null) continue;
                if(n1 ==null || n2 == null) return false;
                if(n1.val!=n2.val) return false;
                queue.add(n1.left);
                queue.add(n2.right);
                queue.add(n1.right);
                queue.add(n2.left);
        }
            return true;
    }
}}
