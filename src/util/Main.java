import java.util.Scanner;

public class Main {

    private static void stackClient() {
        Stack<String> stack = new LinkedListStack<String>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if(s.equals("-"))
                stack.pop();
            else
                stack.push(s);
        }
        System.out.println(stack);
    }

    private static void queueClient() {
        LinkedListQueue<String> q = new LinkedListQueue<String>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if(s.equals("-"))
                q.dequeue();
            else
                q.enqueue(s);
        }
        System.out.println(q);
    }

    private static void arithmeticExpressionClient() {
        String s = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        ArithmeticExpression ae = new ArithmeticExpression(s);
        int result = ae.evaluate();
        System.out.println(s + " = " + result);
    }

    private static void phoneNumberClient() {
        PhoneNumber pn1 = new PhoneNumber(206, 555, 4121);
        PhoneNumber pn2 = PhoneNumber.getInstance("206-555-4121");
        PhoneNumber pn3 = PhoneNumber.getInstance("206-555-5176");
        System.out.println(pn1 + (pn1.equals(pn2) ? " == " : " != ") + pn2);
        System.out.println(pn2 + (pn2.equals(pn3) ? " == " : " != ") + pn3);
        System.out.println(pn3 + (pn3.equals(pn1) ? " == " : " != ") + pn1);
    }

    public static void main(String[] args) {
        phoneNumberClient();
    }
}