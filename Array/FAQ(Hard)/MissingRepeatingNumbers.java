import java.util.*;

public class MissingRepeatingNumbers{
    public static int[] findMissingRepeatingNumbersXOR(int[] nums){
        int n= nums.length;
        int xr=0;
        for(int i=0;i<n;i++){
            xr = xr ^ nums[i];
            xr = xr ^ (i+1);
        }
        //now I want the rightmost bit of xr
        int bitNo= 0;
        while(true){
            if(( xr & (1<<bitNo)) != 0){
                break;
            }
            bitNo++;
        }
        int mask=1<<bitNo;
        //Now bitNo stores the rightmost bit where repeating number and missing number and different
        int grp0=0;
        int grp1=0;
        //check the bitNo'th bit of every number and if it is 0, xor in grp0, if it is 1, xor in grp1
        //so I have to & with 2^bitNo, if the number is 0, xor in grp0
        for(int i=0;i<n;i++){
            //check for nums[i] and (i+1)
            if((nums[i] & mask) !=0 ){
                grp1=grp1^nums[i];
            }else{
                grp0=grp0^nums[i];
            }
            if(((i+1) & mask) != 0){
                grp1=grp1^(i+1);
            }
            else{
                grp0=grp0^(i+1);
            }
        }
        //xor can still not tell which one is missing and which one is repeating
        //we have to iterate the array to confirm that
        int repeating=0;
        int missing=0;
        for(int num: nums){
            if(num==grp0){
                repeating=grp0;
                missing=grp1;
                break;
            }
            else if(num==grp1){
                repeating=grp1;
                missing=grp0;
                break;
            }
        }
        int ans[]=new int[2];
        ans[0]=repeating;
        ans[1]=missing;
        return ans;

    }
    public static int[] findMissingRepeatingNumbers(int[] nums){
        int n= nums.length;
        // X-Y = S-Sn(diff1)
        // X^2 - Y^2 = S2 - S2n
        // (X-Y)(X+Y) = S2-S2n(diff2)
        long S=0;
        long S2=0;
        for(int num:nums){
            S+=num;
            S2+=(long)num*num;
        }
        long Sn=(long) n*(n+1)/2;
        long S2n=(long) n*(n+1)*(2*n+1)/6;
        long xminusy= S-Sn;
        long diff2= S2-S2n;
        long xsumy = diff2/xminusy;
        //now just need to create array of x and y
        int[] ans= new int[2];
        long x=(xsumy+xminusy)/2;
        ans[0]=(int)x;
        ans[1]= (int)(xsumy-x);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1, 2, 3, 6, 7, 5, 7};
        System.out.println(Arrays.toString(findMissingRepeatingNumbersXOR(nums)));

    }
}