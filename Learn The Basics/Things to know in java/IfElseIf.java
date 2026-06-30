
import java.util.Random;

public class IfElseIf{
    public static void studentGrade(int marks){
        if(marks>=90){
            System.out.println("A");
        }
        else if(marks>=70){
            System.out.println("B");
        }
        else if(marks>=50){
            System.out.println("C");
        }
        else if(marks>=35){
            System.out.println("D");
        }
        else{
            System.out.println("Fail");
        }
    }
    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            if(i%2==0){
                int random = (int)(Math.random()*101);
                studentGrade(random);
            }
            else{
                Random r = new Random();
                int random = r.nextInt(101);
                studentGrade(random);
            }
        }
        
    }
}