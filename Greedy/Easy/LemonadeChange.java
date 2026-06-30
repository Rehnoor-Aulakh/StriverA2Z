

public class LemonadeChange{
    public boolean lemonadeChange(int[] bills) {
        int count5=0;
        int count10=0;
        for(int bill: bills){
            switch (bill) {
                case 5:
                    //perfectly fine
                    count5++;
                    break;
                case 10:
                    //I need to return one 5
                    if(count5<=0) return false;
                    count10++;
                    count5--;
                    break;
            //bill is 20
                case 20:
                    //first try to use 10 and 5
                    if(count10>0 && count5>0){
                        count10--;count5--;
                    }
                    //else try to use 3* 5
                    else if(count5>2){
                        count5-=3;
                    }
                    else{
                        return false;
                    }
                    break;

                default:
                    break;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        
    }
}