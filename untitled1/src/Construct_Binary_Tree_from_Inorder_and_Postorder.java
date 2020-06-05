import java.util.HashMap;

public class Construct_Binary_Tree_from_Inorder_and_Postorder {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int[] inorder;
        int[] postorder;
        HashMap<Integer, Integer> val_index_pair = new HashMap();
        int start_index;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;
            this.start_index = postorder.length - 1;
            for (int i = 0; i <= inorder.length - 1; i++) {
                val_index_pair.put(inorder[i], i);
            }
            return helper(0, inorder.length);


        }

        public TreeNode helper(int start_point, int end_point) {
            if (start_point == end_point) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[start_index]);
            int cut_point = val_index_pair.get(postorder[start_index]);
            start_index--;
            root.right = helper(cut_point + 1, end_point);
            root.left = helper(start_point, cut_point);
            return root;
        }
    }
}

