class Student{
    int marks;
}
public class call_by_value_vs_reference{
    static void change(Student s){
        s=new Student();
        s.marks=100;
    }
    public static void main(String[] args) {
        Student st= new Student();
        st.marks=22;
        change(st);
        System.out.println(st.marks);
    }
}