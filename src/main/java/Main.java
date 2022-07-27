import java.util.Scanner;
import java.util.concurrent.*;

public class Main  {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Future<Integer> integerFuture = singleThreadExecutor.submit(getCallableInteger());
        System.out.println("Getting value: " + integerFuture.get());
        System.out.println("Is it done? " + integerFuture.isDone());
        System.out.println("======= Shutting Down Executor =======");
        singleThreadExecutor.shutdown();
        System.out.println("Is it done? " + integerFuture.isDone());
    }

    public static Callable<Integer> getCallableInteger() {
        // your code here
        Scanner sc = new Scanner(System.in);
        Callable<Integer> callable = () -> {
            System.out.println(Thread.currentThread().getName() + " is responsible for this call");
            System.out.print("Enter a number to store: ");
            int numberToStore = sc.nextInt();
            return numberToStore;
        };
        return callable;
    }

}