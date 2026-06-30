public class RowWithMaxOnes{
    public static int rowWithMax1s(int[][] mat){
        int rows=mat.length;
        int cols=mat[0].length;
        int index=-1;
        int maxOnes=0;
        for(int i=0;i<rows;i++){
            int low=0;
            int high=cols-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(mat[i][mid]==1){
                    //I want the first occurence go left
                    high=mid-1;
                }
                else{
                    //0 naaa, go right
                    low=mid+1;
                }
            }
            if((cols-low-1)>maxOnes){
                maxOnes=cols-low-1;
                index=i;
            }
        }
        return index;
    }
    public static int rowWithMax1sLinear(int[][] mat) {
       int rows=mat.length;
       int cols=mat[0].length;
       int index=-1;
       int maxOnes=-1;
       for(int i=0;i<rows;i++){
            int count=0;
            for(int j=0;j<cols;j++){
                count+=mat[i][j];
            }
            if(count>maxOnes && count!=0){
                maxOnes=count;
                index=i;
            }
       }
       return index;
    }
    public static void main(String[] args) {
        int mat[][]={{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        System.out.println(rowWithMax1s(mat));
    }
}