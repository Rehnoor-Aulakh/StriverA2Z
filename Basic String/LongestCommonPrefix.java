public class LongestCommonPrefix{
    public static String findCommon(String s1, String s2){
        int size=Math.min(s1.length(),s2.length());
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<size;i++){
            if(s1.charAt(i)==s2.charAt(i)){
                ans.append(s1.charAt(i));
            }
            else{
                //they mismathc
                return ans.toString();
            }
        }
        return ans.toString();
    }
     public static String longestCommonPrefix(String[] str) {
        //your code goes here
        //we store the common string amongst 0 and 1 first and then go on reducing that as we move forward
        String common = findCommon(str[0],str[1]);
        for(int i=2;i<str.length;i++){
            common=findCommon(common, str[i]);
        }

        return common;
    }
    public static void main(String[] args) {
        String[] str = {"flowers" , "flow" , "fly", "flight" };
        System.out.println(longestCommonPrefix(str));
    }
}