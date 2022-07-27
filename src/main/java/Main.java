import java.util.Scanner;
import java.util.concurrent.*;

public class Main  {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // using first method that takes no parameter
        ExecutorService firstExecutor = Executors.newSingleThreadExecutor();
        Future<Integer> integerFuture = firstExecutor.submit(getCallableInteger());
        int firstValue = integerFuture.get();
        System.out.println("Getting value from first method: " + firstValue);
        System.out.println("Is it done? " + integerFuture.isDone());
        System.out.println("======= Shutting Down Executor =======");
        firstExecutor.shutdown();
        System.out.println("Is it done? " + integerFuture.isDone());

        System.out.println("=====================================");
        System.out.println("============= SEPARATOR =============");
        System.out.println("=====================================");

        // using second method that takes a Scanner object
        ExecutorService secondExecutor = Executors.newFixedThreadPool(3);
        int secondValue = secondExecutor.submit(getCallableInteger(new Scanner(System.in))).get();
        System.out.println("Getting value from second method: " + secondValue);
        secondExecutor.shutdown();
    }

    /* getCallableInteger() method that takes no parameter */
    public static Callable<Integer> getCallableInteger() {
        // your code here
        Scanner sc = new Scanner(System.in);
        Callable<Integer> callable = () -> {
            System.out.println(Thread.currentThread().getName() + " is responsible for this first method");
            System.out.print("Enter a number to store: ");
            int numberToStore = sc.nextInt();
            return numberToStore;
        };
        return callable;
    }

    /* getCallableInteger() method that takes a Scanner object */
    public static Callable<Integer> getCallableInteger(Scanner sc) {
        return (() -> {
            // implementing call() method here
            System.out.println(Thread.currentThread().getName() + " is responsible for this second method");
            System.out.print("Enter a number to store: ");
            return sc.nextInt();
        });
    }

}