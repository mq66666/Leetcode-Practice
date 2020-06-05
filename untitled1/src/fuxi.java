import java.util.List;

public class fuxi {
    class Solution {
        int maxdp = 1;
        public int depthSumInverse(List<NestedInteger> nestedList) {
            maxdepth(nestedList,1);
            return depthsum(nestedList,1,maxdp);

        }
        public int depthsum(List<NestedInteger> n,int d,int maxdp){
            int sum = 0;
            for (NestedInteger N:n){
                if(N.isInteger()){
                    sum = sum + (maxdp-d+1)*N.getInteger();
                }
                else{
                    sum = sum + depthsum(N.getList(),d+1,maxdp);
                }
            }
            return sum;
        }
        public void maxdepth(List<NestedInteger> n, int stdp){
            for (NestedInteger N:n){
                if(N.isInteger()){
                    maxdp = Math.max(maxdp,stdp);
                }
                else{
                    maxdepth(N.getList(),stdp+1);
                }
            }
        }
    }


}
