public interface HabeebQueue<E> {
    void enqueue(E element);
    E dequeue();
    E front();
    boolean isEmpty();
    int size();
}
