//Remember this- java is always call by value

public class PassbyValue{
    static void modify(int a){
        a=a+10;
    }
    public static void main(String[] args) {
        int x=5;
        modify(x);
        System.out.println(x);
    }
}