import java.util.ArrayList;
import java.util.List;

public class Queue {

    private final List<Request> requests;

    /**
     * Creates a new empty queue.
     */
    public Queue() {
        this.requests = new ArrayList<>();
    }

    /**
     * Adds a new request to the queue.
     *
     * @param request The request to add
     */
    public synchronized void enqueue(Request request) {
        this.requests.add(request);
    }

    /**
     * Gets the next request to process.
     *
     * @return The next request
     */
    public synchronized Request getNext() {
        return requests.remove(0);
    }

}
