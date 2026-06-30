
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Divisors{
    public static int[] divisors(int n){
        TreeSet<Integer> ts= new TreeSet<>();
        //iterate till square root of n
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                ts.add(i);
                ts.add(n/i);
            }
        }
        int size= ts.size();
        int[] arr= new int[size];
        int index=0;
        for(int num: ts){
            arr[index++]=num;
        }
        return arr;    
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to find all its divisors: ");
        int n=sc.nextInt();
        sc.close();
        int[] arr= divisors(n);
        System.out.println(Arrays.toString(arr));
    }
}