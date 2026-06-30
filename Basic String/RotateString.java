public class RotateString{
    public static boolean rotateString(String s, String goal) {
        //my approach is to rotate the string the length number of times, and if any time it matches the goal return true
        //time complexity O(n^2), space O(n)
        //this is brute force
        
        int length= s.length();
        if(length!=goal.length()) return false;
        if(s.equals(goal)) return true;
        StringBuilder temp= new StringBuilder();
        temp.append(s);
        for(int i=1;i<=length;i++){
            //remove from front add it to back
            char c=temp.charAt(0);
            temp.deleteCharAt(0);
            //add it to the back
            temp.append(c);
            if(temp.toString().equals(goal)){
                return true;
            }
        }
        return false;
    }
    public static boolean rotateStringOptimized(String s, String goal){
        //the string concatenated with itself i.e. s+s,
        //if the goal is substring of it, then return true
        //the contains method guarantees O(n) finding of substring
        // by using rabin karp or kmp algorithm
        s=s+s;
        return(s.contains(goal));
    }
    public static void main(String[] args) {
        String s="abcde";
        String goal="cdeab";
        System.out.println(rotateStringOptimized(s, goal));
    }
}