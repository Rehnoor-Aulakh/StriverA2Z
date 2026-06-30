public class LongestRepeatingCharacterReplacement{
    public static int characterReplacementBetter(String s, int k){
        int n=s.length();
        int maxLen=0;
        int l=0,r=0;
        int[] map = new int[26];
        int maxFreq=0;
        for(r=0;r<n;r++){
            //first increment in the map
            map[s.charAt(r)-'A']++;
            //then check if it is valid
            maxFreq=Math.max(maxFreq,map[s.charAt(r)-'A']);
                //we need to slide the window
                while(r-l+1-maxFreq>k){
                    //slide l forward
                    map[s.charAt(l)-'A']--;
                    l++;
                }

            
            maxLen= Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
    public static int characterReplacementBrute(String s, int k){
        int n=s.length();
        int maxLen=0;
        int map[];
        //map to track the frequency of every character
        
        for(int i=0;i<n;i++){
            int maxFreq=0;
            map=new int[26];
            for(int j=i;j<n;j++){
                //check the element if there in map
                //increment in the map
                map[s.charAt(j)-'A']++;
                maxFreq=Math.max(maxFreq, map[s.charAt(j)-'A']);
                int changes = j-i+1 - maxFreq;
                if(changes<=k){
                    maxLen= Math.max(maxLen, j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }

    
    public static void main(String[] args) {
        System.out.println(characterReplacementBetter("BAABAABBBAAA", 2));
    }
}