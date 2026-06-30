package FAQs;

public class CelebrityProblem {
    public int celebrity(int[][] M){
        int n= M.length;
        int top = 0;
        int bottom = n-1;
        while(top<bottom){
            //check who is the celebrity between them
            int nextTop = top;
            int nextBottom = bottom;
            if(M[top][bottom]==0){
                // top does not know bottom, maybe top is the celebrity
                if(M[bottom][top] == 1){
                    // but bottom knows top, so top is a candidate celebrity, and bottom is definitely not a celebrity
                    bottom--;
                    continue;
                }
            }
            if(M[bottom][top]==0){
                if(M[top][bottom]==1){
                    top++;
                    continue;
                }
            }
            if(M[bottom][top]==1 && M[top][bottom]==1){
                top++;
                bottom--;
            }
        }
        if(top==bottom){
            // check for row
            for(int i=0;i<n;i++){
                if(M[top][i]!=0) return -1;
                if(top==i) continue;
                if(M[i][top]!=1) return -1;
            }
            return top;
        }
        return -1;
    }

    public int celebrityBrute(int[][] M) {
        // NAIVE APPROACH
        // PICK THE ROW THAT HAS ALL ZEROS
        // THEN FOR THAT ROW NUMBER, THE COLUMN MUST BE 1 EXCEPT ITSELF
        int n= M.length;
        for(int i=0; i<n; i++){
            boolean flag= true;
            for(int j=0; j<n; j++){
                if(M[i][j]==1){
                    flag= false;
                    break;
                }
            }
            if(flag){
                // then the ith row is a candidate to be a celebrity, because it knows no one
                // so we need to check the column that everyone knows him
                boolean flag2= true;
                for(int j=0;j<n;j++){
                    if(i==j) continue;
                    if(M[j][i]==0){
                        flag2= false;
                        break;
                    }
                }
                if(flag2) return i;
            }
        }
        return -1;
    }
}
