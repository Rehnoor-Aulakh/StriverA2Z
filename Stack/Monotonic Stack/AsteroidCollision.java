import java.util.*;

public class AsteroidCollision{
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ele: asteroids){
            if(ele>=0){
                st.push(ele);
                continue;
            }
            else if(!st.isEmpty() && st.peek()<0){
                st.push(ele);
                continue;
            }
            else{
                //it is negative, now problem arises
                while(!st.isEmpty() && st.peek()>0 &&st.peek()<Math.abs(ele)){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(ele)){
                    st.pop();
                    continue;
                }
                else if(!st.isEmpty() && st.peek()>Math.abs(ele)){
                    continue;
                }
                else{
                    st.push(ele);
                }
            }
        }
        int size= st.size();
        int[] ans = new int[size];
        for(int i=size-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{4,7,1,1,2,-3,-7,17,15,-16})));
    }
}