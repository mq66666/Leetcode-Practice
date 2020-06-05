public class Sumtwo {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int[] maxleft = new int[n];
        int[] maxright  = new int[n];
        if(height.length == 0 || height.length ==1 || height.length ==2){
            return ans ;
        }

        for (int i = 0; i <= (n-1);i++){
            maxleft[i] = 0;
            maxright[i] = 0;
        }
        maxleft[1] = height[0];
        maxright[n-2] = height[n-1];
        for(int i = 2; i<=(n-1);i++){
            if(height[i-1] >= maxleft[i-1]){
                maxleft[i] = height[i-1];
            }else{
                maxleft[i] = maxleft[i-1];
            }

        }
        for(int j =n-3; j>=0; j--){
            if (height[j+1]>= maxright[j+1]){
                maxright[j] = height[j+1];
            }else{
                maxright[j] = maxright[j+1];
            }
        }
        for (int i = 1; i<=n-2;i++){
            if(height[i] >=maxleft[i] || height[i]>= maxright[i]){
            }else{
                if(maxleft[i]>=maxright[i]){
                    ans = ans + maxright[i] - height[i];
                }else{
                    ans = ans + maxleft[i] - height[i];
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
