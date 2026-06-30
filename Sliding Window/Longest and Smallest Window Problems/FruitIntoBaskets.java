public class FruitIntoBaskets{
    public static int totalFruit(int[] fruits) {
        int type1=-1,type2=-1;
        int last1=-1,last2=-1;
        int maxLen=0;
        int l=0;
        for(int r=0;r<fruits.length;r++){
            //first check that if it is there, then increase the length
            if(fruits[r]==type1){
                last1=r;
            }
            else if(fruits[r]==type2){
                last2=r;
            }
            else{
                if(type1==-1){
                    type1=fruits[r];
                    last1=r;
                }
                else if(type2==-1){
                    type2=fruits[r];
                    last2=r;
                }
                else{
                    //remove the older fruit
                    if(last1<last2){
                        l=last1+1;
                        type1=fruits[r];
                        last1=r;
                    }
                    else{
                        l=last2+1;
                        type2=fruits[r];
                        last2=r;
                    }
                }
            }
            maxLen=Math.max(maxLen,r-l+1);

        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{0,1,2,2}));
    }
}