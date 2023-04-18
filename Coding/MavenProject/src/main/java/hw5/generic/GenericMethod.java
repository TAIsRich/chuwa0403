package hw5.generic;

public class GenericMethod {
    public static void main(String[] args) {
        Method m = new Method();
//        m.method(new User());
//        m.method2(new User());
//        m.method2(new StudentUser());
//        m.method(new StudentUser());;
        // m.maixum(1,"aa","d"); -> show the syntax error
        m.maixum(1,4,6);
        m.maixum("Aa", "d","a");

        m.getInfo(1,"aaa",3.0);

        User u1 = new User(10);
        User u2 = new User(15);



        TeacherUser t1 = new TeacherUser(100);
        TeacherUser t2 = new TeacherUser(120);

        StudentUser s1 = new StudentUser('a');
        StudentUser s2 = new StudentUser('c');


         m.methodG(u1,s1);
//        m.methodG(s1,s2);
//        m.methodG(t1,t2);
        m.methodG(s1,t1);

//        m.methodO(u1,s1);
        //        m.methodO(t1,s1);


        method(s1,s2);

        Inter1 i1 = new Inter1();
        Inter2 i2 = new Inter2();
        m.method3(i1, i2);
        m.method3(i1, i1);

        method(t1, s1);

    }
    static void method(User x,StudentUser y){
        x.print(); // --> student
        y.print(); // --> student
        if(x.compareTo(y)>0){
            System.out.println("win");
        }
    }
}
class Method{
    <T extends Comparable<T>> T maixum(T x, T y, T z){
        // Comparable<String> and Comparable<Integer> is not belong to the same superclass
        // although String and Integer are all Object
        T max = x;
        if(y.compareTo(max) > 0){
            max = y;
        }
        if(z.compareTo(max) >0){
            max = z;
        }
        return max;
    }
    <T1, T2, T3> void getInfo(T1 x, T2 y, T3 z){
        System.out.println("x: "+x+" y: "+y+" z: "+z);
    }



    <T extends User> void methodG(T x, T y){
        if(x.compareTo(y)>0){
            System.out.println("win");
        }
    }

    <T extends UserInter> void method3(T x, T y){
        System.out.println("use interface");
        x.print();
        y.print();
    }


}

interface UserInter{
    void print();
}

class Inter1 implements UserInter{
    @Override
    public void print() {
        System.out.println("interface im 1");
    }
}

class Inter2 implements UserInter{
    @Override
    public void print() {
        System.out.println("interface im 2");
    }
}


class User {
    private int i;
    User(){}
    User(int i){
        this.i = i;
    }
    public int getI() {
        return i;
    }
    public void print(){
        System.out.println("user");
    }

    public int compareTo(User o) {
        System.out.println("compare user");
        return i-o.getI();
    }
}



class StudentUser extends User{
    private char c;
    StudentUser(char c){
        this.c = c;
    }
    public char getC() {
        return c;
    }
    public void print(){
        System.out.println("student");
    }

    public int compareTo(StudentUser o) {
        System.out.println("compare student");
        return c-o.getC();
    }

    @Override
    public int compareTo(User o) {
        System.out.println("compare to method overriding from user");
        return 1;
    }

    void studentMethod(){

    }
}
class TeacherUser extends User{
    private int s;

    TeacherUser(int s){
        this.s = s;
    }

    public int getS() {
        return s;
    }

    public int compareTo(TeacherUser o) {
        System.out.println("compare teacher");
        return s-o.getS();
    }
}

