import java.util.*;

public class StockSpanner {
    Stack<Integer> st;
    HashMap<Integer,Integer> hm;
    int index;
    public StockSpanner() {
        st= new Stack<>();
        hm= new HashMap<>();
        index=0;
    }

    public int next(int price) {
        hm.put(price,index++);
        //now
        if(st.isEmpty()){
            hm.put(price,index++);
            st.push(price);
            return 1;
        }
        else if(st.peek()>price){
            hm.put(price,index++);
            st.push(price);
            return 1;
        }
        else{
            //it is smaller than or equal to
            //then while stack.peek()<=price, pop it
            while(!st.isEmpty() && st.peek()<=price){
                st.pop();
            }
            int top= hm.get(st.peek());
            hm.put(price,index++);
            st.push(price);
            return index-1-top;
        }
    }
}
