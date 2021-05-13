package structures;

public class Queue<T> implements QueueInterface<T> {
	
	private Wrapper<T> top;
	private Wrapper<T> back;
	private int size;
	
	public Queue() {
		size = 0;
	}

	@Override
	public T top() {
		
		return top.getElement();
	}

	@Override
	public boolean add(T t) {
		if (top == null)
		{
			top = new Wrapper<T>(t);
			back = top;
			size++;
			return true;
		}else
		{
			back.add(new Wrapper<T>(t));
			back = back.getNext();
			size++;
			return true;
		}
		
	}

	@Override
	public boolean remove() {
		if (top == null)
		{
			return false;
		}else
		{
			top = top.getNext();
			size--;
			return true;
		}
		
	}

	@Override
	public T get(int index) {
		if (top == null) return null;
		else
		{
			return top.get(index);
		}
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) return true;
		return false;
	}
	
}
