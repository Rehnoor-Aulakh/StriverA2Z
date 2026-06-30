public class NumberOfSubstrings_abc{
    public static int numberOfSubstrings(String s) {
        int[] map={-1,-1,-1};
        int count=0;
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-'a']=i;
            if(map[0]!=-1 && map[1]!=-1 && map[2]!=-1){
                count=count+1+Math.min(map[0],Math.min(map[1],map[2]));
            }

        }   
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("aaacb"));
    }
}