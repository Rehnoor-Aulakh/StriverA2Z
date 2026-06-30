
import java.util.*;

public class reverseString{
    public static void reverse(List<Character> a){
        int size=a.size();
        for(int i=0;i<size/2;i++){
            //remove the element from the backend
            char c = a.get(size-i-1);
            //replace it with the front end
            a.set(size-i-1,a.get(i));
            a.set(i,c);
        }
        System.out.println(a);
    }
    public static void main(String[] args) {
        List<Character> a= new ArrayList<>(Arrays.asList('a','b','c','d','e'));

        reverse(a);

    }
}