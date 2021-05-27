package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

	private Queue<Integer> a;
	
	private void setup1()
	{
		a = new Queue<>();
	}
	
	
	@Test
	public void testAdd()
	{
		setup1();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		
		assertEquals(4, a.size());
		assertEquals(1, a.top());
		a.remove();
		assertEquals(3, a.size());
		assertEquals(2, a.top());
		
		assertEquals(2, a.get(0));
		assertEquals(null, a.get(3));
		assertEquals(4, a.get(2));
		
	}
}
