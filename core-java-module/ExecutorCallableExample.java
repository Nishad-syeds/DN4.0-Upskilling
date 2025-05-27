import java.util.concurrent.*;

public class ExecutorCallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<String> task = () -> {
            Thread.sleep(1000);
            return "Task completed";
        };

        Future<String> future = executor.submit(task);

        System.out.println("Waiting for result...");
        System.out.println("Result: " + future.get());

        executor.shutdown();
    }
}
