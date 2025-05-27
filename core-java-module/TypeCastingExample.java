
public class TypeCastingExample {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble;  // double to int (explicit casting)

        int anotherInt = 42;
        double anotherDouble = (double) anotherInt;  // int to double (implicit casting but shown explicitly)

        System.out.println("Original double value: " + myDouble);
        System.out.println("After casting to int: " + myInt);
        System.out.println("Original int value: " + anotherInt);
        System.out.println("After casting to double: " + anotherDouble);
    }
}
