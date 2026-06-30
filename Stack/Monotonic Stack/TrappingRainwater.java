public class TrappingRainwater {
    public static int optimized(int[] height){
        int total=0,lMax=0,rMax=0,left=0,n=height.length,right=n-1;
        while(left<right){
            int l= height[left];
            int r=height[right];
            if(l<=r){
                if(l<lMax){
                    total+=(lMax-l);
                }
                lMax=Math.max(lMax,l);
                left++;
            }else{
                if(r<rMax){
                    total+=(rMax-r);
                }
                rMax=Math.max(rMax,r);
                right--;
            }
        }
        return total;
    }
    private int[] prefixMax(int[] height){
        int[] prefix= new int[height.length];
        prefix[0]=height[0];
        for(int i=1;i<height.length;i++){
            prefix[i]=Math.max(prefix[i-1],height[i]);
        }
        return prefix;
    }
    private int[] suffixMax(int[] height){
        int size=height.length;
        int[] suffix= new int[size];
        suffix[size-1]=height[size-1];
        for(int i=size-2;i>=0;i--){
            suffix[i]= Math.max(suffix[i+1],height[i]);
        }
        return suffix;
    }
    public int trap(int[] height) {
        int prefix[]= prefixMax(height);
        int suffix[] = suffixMax(height);
        int total=0;
        for(int i=0;i<height.length;i++){
            int leftMax=prefix[i];
            int rightMax=suffix[i];
            if(height[i]<leftMax && height[i]<rightMax){
                total+=Math.min(rightMax,leftMax)-height[i];
            }
        }
        return total;
    }
}
