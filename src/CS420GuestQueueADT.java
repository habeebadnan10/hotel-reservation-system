import java.util.LinkedList;

public class CS420GuestQueueADT implements HabeebQueue<HabeebGuest> {
    private LinkedList<HabeebGuest> queue;

    public CS420GuestQueueADT() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(HabeebGuest guest) {
        queue.addLast(guest);
    }

    public HabeebGuest dequeue() {
        return queue.removeFirst();
    }

    public HabeebGuest front() {
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
