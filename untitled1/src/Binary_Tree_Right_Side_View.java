import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        class Solution {
            public List<Integer> rightSideView(TreeNode root) {
                List<Integer> ans = new ArrayList<>();
                if (root == null) return ans;
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                int size = 1;
                while (!queue.isEmpty()) {
                    size = queue.size();
                    while (size > 0) {
                        size--;
                        TreeNode cur = queue.poll();
                        if (size == 0) ans.add(cur.val);
                        if (cur.left != null) queue.offer(cur.left);
                        if (cur.right != null) queue.offer(cur.right);
                    }
                }
                return ans;
            }
        }
    }
}