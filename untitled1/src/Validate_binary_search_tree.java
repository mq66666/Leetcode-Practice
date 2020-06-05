public class Validate_binary_search_tree {
    public class Treenode {
        int val;
        Treenode left;
        Treenode right;

        Treenode(int a) {
            a = val;
        }
    }

    class Solution {
        public boolean isValidBST(Treenode root) {
            if(root == null){
                return true;
            }
            return helper(root,null,null);
        }

        public boolean helper(Treenode t, Integer lowerbound, Integer upperbound) {
            if(t == null){
                return true;
            }
            if(lowerbound!=null&&t.val<=lowerbound)return false;
            if(upperbound!=null&&t.val>=upperbound)return false;
            if(!helper(t.left,lowerbound,t.val))return false;
            if(!helper(t.right,t.val,upperbound))return false;
            return true;
        }
    }
}
