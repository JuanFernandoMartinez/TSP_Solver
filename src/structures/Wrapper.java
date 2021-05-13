package structures;

public class Wrapper<T> {

	private T element;
	private Wrapper<T> next;
	
	
	public Wrapper(T t) {
		element = t;
		next = null;
	}
	
	
	public boolean add(Wrapper<T> n)
	{
		if (next == null)
		{
			next = n;
			return true;
		}else
		{
			return next.add(n);
		}
	}
	
	
	public boolean remove(T t)
	{
		if (next.element == t)
		{
			next = next.next;
			return true;
		}else
		{
			return next.remove(t);
		}
	}


	public T getElement() {
		return element;
	}


	public void setElement(T element) {
		this.element = element;
	}


	public Wrapper<T> getNext() {
		return next;
	}


	public void setNext(Wrapper<T> next) {
		this.next = next;
	}
	
	public T get(int index)
	{
		if (index == 0)
		{
			return element;
		}else
		{
			if (next == null) return null;
			else
			{
				return next.get(index-1);
			}
		}
	}
}
