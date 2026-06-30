import java.util.*;
class ReverseString {
    int length;
    public void reverse(ArrayList<Character> s, int i){
        if(i<length/2){
            //swap i and length-i
            Character t=s.get(i);
            s.set(i, s.get(length-i-1));
            s.set(length-i-1, t);
            reverse(s,i+1);
        }
    }
    public ArrayList<Character> reverseString(ArrayList<Character> s) {
        this.length=s.size();
        reverse(s, 0);
        return s;
    }
}