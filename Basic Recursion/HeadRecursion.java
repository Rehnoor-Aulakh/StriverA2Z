public class HeadRecursion{
    static void headRecursion(int n){
        if(n>0){
            headRecursion(n-1);
            System.out.print(n+" ");

        }
    }
    public static void main(String[] args) {
        headRecursion(5);
    }
}