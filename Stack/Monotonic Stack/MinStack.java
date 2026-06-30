import java.util.*;
class MinStack{
    int mini;
    Stack<Integer> st;
    public MinStack(){
        st= new Stack<>();
        mini= Integer.MAX_VALUE;
    }
    public void push(int val){
        if(st.isEmpty()){
            mini= val;
            st.push(val);
        }
        else if(mini>val){
            //insert the modified value
            st.push(2*val-mini);
            mini=val;
        }
        else{
            st.push(val);
        }
    }
    public int getMin(){
        return mini;
    }
    public int top(){
        if(st.isEmpty()){
            return -1;
        }
        int x= st.peek();
        if(x<mini){
            return mini;
        }
        else return x;
    }
    public void pop(){
        if(st.isEmpty()) return;
        if(st.peek() < mini){
            mini= 2*mini-st.peek();
        }
        st.pop();
    }

}
class MinStack2 {
    List<Integer> stack;
    //minStack stores the current minimum element of the stack
    List<Integer> minStack;
    int minEle;
    public MinStack2() {
        stack=new ArrayList<>();
        int minEle=Integer.MAX_VALUE;
        minStack= new ArrayList<>();
        minStack.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.add(val);
        minStack.add(Math.min(minEle,val));
    }

    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }
}