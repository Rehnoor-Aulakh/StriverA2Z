class Solution {
    public void pattern22(int n) {
        //number of rows are 9 i.e 2*n-1
        for(int i=0;i<n;i++){
            //2 j loops one for decreasing part
            // other one for constant part
            for(int j=n;j>=n-i;j--){
                System.out.print(j);
                System.out.print(" ");
            }
            for(int j=1;j<=n-i;j++){
                //decreasing part
                System.out.print(n-i);
                System.out.print(" ");
            }
            //then same thing for reverse
            for(int j=1;j<=n-i;j++){
                //decreasing part
                System.out.print(n-i);
                System.out.print(" ");
            }
            //then increasing part
            for(int j=n-i;j<=n;j++){
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }

        //similarly second can be formed by opposite i-1 and run 
    }
}