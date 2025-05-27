
public class OperatorPrecedenceDemo {
    public static void main(String[] args) {
        int result = 10 + 5 * 2; // Multiplication has higher precedence than addition
        System.out.println("Result of 10 + 5 * 2 = " + result);
        // Explanation: First 5*2 = 10, then 10 + 10 = 20

        int complexResult = (10 + 5) * 2;
        System.out.println("Result of (10 + 5) * 2 = " + complexResult);
        // Explanation: Parentheses evaluated first, 10+5=15, then 15*2=30
    }
}
