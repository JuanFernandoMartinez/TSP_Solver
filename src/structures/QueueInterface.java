package structures;

public interface QueueInterface<T> {
	public T top();
	public boolean add(T t);
	public boolean remove();
	public T get(int index);
	public int size();
	public boolean isEmpty();
}
