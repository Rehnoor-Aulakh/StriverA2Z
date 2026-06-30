public class TailRecursion{
    static void tailRecursion(int n){
        if(n>0){

            System.out.print(n+" ");
            tailRecursion(n-1);

        }
    }
    public static void main(String[] args) {
        tailRecursion(5);
    }
}