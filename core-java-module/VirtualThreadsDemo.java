public class VirtualThreadsDemo {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Running in virtual thread: " + Thread.currentThread());

        for (int i = 0; i < 5; i++) {
            Thread.startVirtualThread(task);
        }
    }
}
