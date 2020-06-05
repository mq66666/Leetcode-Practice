public class Binary_Tree_Maximum_Path_Sum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }}

        class Solution {
        int max_threesum = Integer.MIN_VALUE;
            public int maxPathSum(TreeNode root) {
                find_max(root);
                return max_threesum;

            }
            public int find_max(TreeNode n){
                if(n == null){
                    return 0;
                }
                int max = 0;
                int left_max = Math.max(find_max(n.left),0);
                int right_max = Math.max(find_max(n.right),0);
                int three_sum = left_max+n.val+right_max;
                max_threesum = Math.max(max_threesum,three_sum);
                return n.val+Math.max(left_max,right_max);
            }
        }
    }


