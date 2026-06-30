

public class IsomorphicString{
    public static boolean isomorphicString(String s, String t) {
        //now the approach is to use a map to go from s to t
        // and another map to verify that the character is already not mapped anywhere else
        int[] smap= new int[256];
        int[] tmap= new int[256];
        //now what we need to do is perform a mapping
        for(int i=0;i<s.length();i++){
            if(smap[s.charAt(i)]==0 && tmap[t.charAt(i)]==0){
                //add a new entry to both
                smap[s.charAt(i)]=t.charAt(i);
                tmap[t.charAt(i)]=s.charAt(i);
            }
            //if both are already initialised, but not equal
            else if((smap[s.charAt(i)]!=t.charAt(i)) || (tmap[t.charAt(i)]!=s.charAt(i))){
                return false;
            }
            
        }
        //if everything is okay so far
        return true;

    }
}