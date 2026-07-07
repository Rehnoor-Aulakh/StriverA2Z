import java.util.Stack;

public class Add_Binary_67 {
    public String addBinary(String a, String b) {
        // using 2 pointer approach
        int carry = 0;
        int i=a.length()-1, j= b.length()-1;
        StringBuilder ans = new StringBuilder();
        while(i>=0 && j>=0){
            // check if both are 1's
            if(a.charAt(i)=='1' && b.charAt(j)=='1' && carry==0){
                carry=1;
                i--;j--;
                ans.append("0");
            }
            else if(a.charAt(i)=='1' && b.charAt(j)=='1' && carry==1){
                i--;j--;
                ans.append("1");
            }
            // only one of them is 1 and carry is 0
            else if(carry==0 && ((a.charAt(i)=='0' && b.charAt(j)=='1') || (a.charAt(i)=='1' && b.charAt(j)=='0'))){
                ans.append('1');
                i--;j--;
            }
            // only one of them is 1 and carry is 1 so 1+1 = 10
            else if(carry==1 && ((a.charAt(i)=='0' && b.charAt(j)=='1') || (a.charAt(i)=='1' && b.charAt(j)=='0'))){
                ans.append('0');
                i--;j--;
            }
            // if both are 0, and carry is 0
            else if(carry==0 && a.charAt(i)=='0' && b.charAt(j)=='0'){
                ans.append('0');
                i--;j--;
            }
            else if(carry==1 && a.charAt(i)=='0' && b.charAt(j)=='0'){
                ans.append('1');
                carry=0;
                i--;j--;
            }
        }
        // when either of them is reamining
        while(i>=0){
            if(carry==1 && a.charAt(i)=='0'){
                ans.append('1');
                carry = 0;
            }
            else if(carry==1 && a.charAt(i)=='1'){
                ans.append('0');
            }
            else if(carry==0 && a.charAt(i)=='0'){
                ans.append('0');
            }
            else if(carry==0 && a.charAt(i)=='1'){
                ans.append('1');
            }
            i--;
        }
        while(j>=0){
            if(carry==1 && b.charAt(j)=='0'){
                ans.append('1');
                carry = 0;
            }
            else if(carry==1 && b.charAt(j)=='1'){
                ans.append('0');
            }
            else if(carry==0 && b.charAt(j)=='0'){
                ans.append('0');
            }
            else if(carry==0 && b.charAt(j)=='1'){
                ans.append('1');
            }
            j--;
        }
        if(carry==1){
            ans.append('1');
        }
        return ans.reverse().toString();

    }
}
