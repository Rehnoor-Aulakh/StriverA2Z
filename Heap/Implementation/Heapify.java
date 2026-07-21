package Implementation;

public class Heapify {
    public void heapify(int[] nums, int ind, int val) {
        // if the value at the current index is equal to the already set value, then no change
        // but if the value is smaller than the value at the current index, then we need to go up
        if(nums[ind]== val) return;
        if(val < nums[ind]){
            // we need to move it up
            nums[ind] = val;
            int i = (ind-1)/2;
            // i is the position above
            // stopping conidion is when nums[i] < nums[ind]
            while(i>=0 && nums[i] > nums[ind]){
                // swap these two
                // I will use bitwise swap
                nums[i] = nums[i] ^ nums[ind];
                nums[ind] = nums[i] ^ nums[ind];
                nums[i] = nums[i] ^ nums[ind];
                ind = i;
                i = (i-1)/2;
            }
        }
        else{
            // val > nums[ind], the current index is smaller than the value that we need to put there
            // so a value from down below has to come up, so the candidates of replacement are 2*ind+1 and 2*ind+2, whichever is smaller would come here
            // first we need to check if ind is a leaf node
            nums[ind]= val;
            // we know that leaf nodes are between 0 to (n/2-1)
            while(2*ind+1<nums.length){
                int leftChild = 2*ind+1;
                int rightChild = 2*ind+2;
                int smallestChild = leftChild;
                if(rightChild<nums.length && nums[rightChild] < nums[leftChild]){
                    smallestChild = rightChild;
                }
                if(nums[smallestChild]>= nums[ind]) break;
                nums[ind] = nums[ind] ^ nums[smallestChild];
                nums[smallestChild] = nums[ind] ^ nums[smallestChild];
                nums[ind] = nums[ind] ^ nums[smallestChild];
                ind = smallestChild;
            }
        }
    }
}
