//Remember this-- java is always call by value
//when you pass object, you are passing the value of reference
//so java is call by value of reference, so it looks like it is calling by reference
class Wrapper{
    int value=5;
}

public class PassbyReference{
    static void modify(Wrapper obj){
        obj.value+=10;
    }
    public static void main(String[] args) {
        Wrapper wr=new Wrapper();
        //Initial value of wrapper would be 5
        System.out.println(wr.value);
        //after modification, the actual value got changed, because of call by reference
        //since objects are passed by reference
        modify(wr);
        System.out.println(wr.value);
    }
}