// I worked on the assignment alone, using only course-provided materials.

public class PrimitiveOperations {

    // a)
    public static void main(String[] args) {

     int x = 5;
     double y = 2.2;

        System.out.println("int = " + x);
        System.out.println("double = " + y);

        double z = x * y;
        System.out.println("x * y = " + z);

        double b = (double) x;
        System.out.println("casted variable double = " + b);

        int a = (int) y;
        System.out.println("casted variable int = " + a);

        char t = 'T';
        System.out.println("char = " + t);

        t = (char) (t + 32);
        System.out.println("char Lowercase = " + t);

    }
}
