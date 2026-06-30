public class Candy{
    public int candyOptimal(int[] ratings)  {
        int n=ratings.length;
       int i=1;
       int sum=1;
       while(i<n){
        if(ratings[i]==ratings[i-1]){
            //slope is zero, just add one
            sum+=1;
            i++;
            continue;
        }
        //increasing slope
        int peak=1;
        while(i<n && ratings[i]>ratings[i-1]){
            peak++;
            sum+=peak;
            i++;
        }
        int down=1;
        while(i<n && ratings[i]<ratings[i-1]){
            sum+=down;
            down++;
            i++;
        }
        if(down>peak){
            sum+=(down-peak);
        }
        

       }
       return sum;
    }
    
    public int candy(int[] ratings) {
        int ans=0;
        //just consider the left neighbours
        int size= ratings.length;
        int left[]= new int[size];
        for(int i=0;i<size;i++){
            if(i==0){
                left[i]=1;
            }
            else{
                if(ratings[i]>ratings[i-1]){
                    //assign more
                    left[i]=1+left[i-1];
                }
                else{
                    left[i]=1;
                }
            }
        }
        int prevRight=1;
        for(int i=size-1;i>=0;i--){
            if(i==size-1){
                prevRight=1;
                ans+=Math.max(left[i],prevRight);
            }
            else{
                if(ratings[i]>ratings[i+1]){
                    //assing more
                    
                    prevRight++;
                }
                else{
                    prevRight=1;
                }
                ans+=Math.max(prevRight,left[i]);
            }
        }
        // //sum it up
        // for(int i=0;i<size;i++){
        //     ans+=Math.max(right[i],left[i]);
        // }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}