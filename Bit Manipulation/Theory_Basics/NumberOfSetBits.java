package Theory_Basics;

class Solution {
    public int hammingWeight(int n) {
        // this function returns the number of set bits
        // of the binary representation of n
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }

}