import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {

    private static int num;

    public int getNum() {
        return this.num;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter num: ");
            num = scanner.nextInt();
            System.out.println(getCallableInteger());
        }

    }
    public static Callable<Integer> getCallableInteger() {
        // your code here
        System.out.println("STATUS: I am in getCallableInteger() method");
        Callable<Integer> callable = () -> {
            System.out.println("STATUS: I am in call() method");
            return num;
        };
        return callable;
    }

}