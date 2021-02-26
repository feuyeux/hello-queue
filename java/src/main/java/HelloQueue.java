import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 *
 */
public class HelloQueue {
    private static final int min = 1;
    private static final int max = 20;
    private static final Random r = new Random();
    private static final int MAX_TIME = 100;

    private static int randomOne() {
        return r.nextInt((max - min) + 1) + min;
    }

    private static final BlockingQueue<List<Integer>> queue = new LinkedBlockingQueue<>();

    private static void produce() {
        ScheduledExecutorService s = Executors.newScheduledThreadPool(4);
        s.scheduleAtFixedRate(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(randomOne());
            }
            try {
                queue.put(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    private static void consume() {
        for (int n = 0; n < MAX_TIME; n++) {
            try {
                List<Integer> list = queue.take();
                System.out.println("\nreceived:");
                list.forEach(i -> System.out.print(i + " "));
                System.out.println("\nhandled:");
                list.stream().distinct().sorted().limit(5).forEach(i -> System.out.print(i + " "));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        produce();
        consume();
    }
}
