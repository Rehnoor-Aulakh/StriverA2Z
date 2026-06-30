public class JumpGameI{
    public boolean canJumpSpaceOptimized(int[] nums){
        int size=nums.length;
        if(size==0 || size==1) return true;
        int jump=nums[0];
        if(jump>=size-1) return true;
        for(int i=1;i<size;i++){
            if(jump>=i){
                //then this index is reachable
                jump=Math.max(i+nums[i], jump);
                if(jump>=size-1) return true;
            }
        }   
        return false;
    }
    public boolean canJump(int[] nums) {
        int size=nums.length;
        if(size==0) return true;
        int jump[]= new int[size];
        jump[0]=nums[0];
        for(int i=1;i<size-1;i++){
            if(nums[i-1]>=i){
                //then this index is reachable
                jump[i]=(i+nums[i]);
                if(jump[i]>=size-1) return true;
            }
        }   
        return false;
    }
    public static void main(String[] args) {
        
    }
}