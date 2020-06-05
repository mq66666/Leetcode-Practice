import java.util.HashMap;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int[] preorder;
        int[] inorder;
        HashMap<Integer, Integer> inorermap = new HashMap<>();
        int initial = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.inorder = inorder;
            this.preorder = preorder;
            for (int i = 0; i < inorder.length; i++) {
                inorermap.put(inorder[i], i);
            }
            int start = 0;
            int end = preorder.length;
            int initial_index = 0;
            return helper(start, end);


        }

        public TreeNode helper(int start, int end) {

            if(start == end){
                return null;
            }
            TreeNode root = new TreeNode(preorder[initial]);
            int cutpoint = inorermap.get(preorder[initial]);
            initial++;
            root.left = helper(start,cutpoint);
            root.right = helper(cutpoint+1,end);
            return root;
        }
    }
}
