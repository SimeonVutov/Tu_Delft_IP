import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class QueueSyncTest {

    private Queue queue;

    @BeforeEach
    void setUp() throws Exception {
        this.queue = new Queue();
        Field requests = Queue.class.getDeclaredField("requests");
        requests.setAccessible(true);
        requests.set(this.queue, new SlowQueue());
    }

    @RepeatedTest(10)
    @DisplayName("First student enqueues first")
    public void enqueue() throws Exception {
        Request request1 = new Request("This is a question", "Room 1");
        Request request2 = new Request("This is another question", "Room 1");

        Thread t1 = new Thread(() -> queue.enqueue(request1));
        Thread t2 = new Thread(() -> queue.enqueue(request2));

        t1.start();
        try {
            Thread.sleep(5L);
        } catch (Exception ignored) {}
        t2.start();

        t1.join();
        t2.join();
        assertEquals(request1, queue.getNext());
    }

    @RepeatedTest(10)
    @DisplayName("Cannot get the same request")
    public void getNext() throws Exception {
        Request request1 = new Request("This is a question", "Room 1");
        Request request2 = new Request("This is another question", "Room 1");
        queue.enqueue(request1);
        queue.enqueue(request2);

        class GetNextThread extends Thread {
            public Request request;
            @Override
            public void run() {
                this.request = queue.getNext();
            }
        }

        GetNextThread t1 = new GetNextThread();
        GetNextThread t2 = new GetNextThread();

        t1.start();
        try {
            Thread.sleep(5L);
        } catch (Exception ignored) {}
        t2.start();

        t1.join();
        t2.join();
        assertNotEquals(t1.request, t2.request);
    }

    @RepeatedTest(10)
    @DisplayName("Enqueue then get next")
    public void enqueueDequeue() throws Exception {
        Request request = new Request("This is a question", "Room 1");

        Thread t1 = new Thread(() -> queue.enqueue(request));
        class NoThrowThread extends Thread {
            public boolean threw = false;
            @Override
            public void run() {
                try {
                    queue.getNext();
                } catch (IndexOutOfBoundsException ignored) {
                    threw = true;
                }
            }
        }
        NoThrowThread t2 = new NoThrowThread();

        t1.start();
        try {
            Thread.sleep(5L);
        } catch (Exception ignored) {}
        t2.start();

        t1.join();
        t2.join();

        assertFalse(t2.threw);
    }

    private static class SlowQueue extends ArrayList<Request> {
        private static final Random rand = new Random();
        @Override
        public boolean add(Request request) {
            try {
                Thread.sleep(rand.nextInt(10, 100));
            } catch (Exception ignored) {}
            return super.add(request);
        }
        @Override
        public Request remove(int index) {
            Request value = get(index);
            try {
                Thread.sleep(rand.nextInt(10, 100));
            } catch (Exception ignored) {}
            super.remove(index);
            return value;
        }
    }

}
