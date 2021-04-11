package Queue;


public class StackQueue implements Queue{
	
	private int queueSize = 100;
	ArrayStack stack1 = new ArrayStack(queueSize);
	ArrayStack stack2 = new ArrayStack(queueSize);

	
	@Override
	public int size() {
		return stack2.size();
	}

	@Override
	public boolean isEmpty() {
		return stack2.isEmpty();
	}

	@Override
	public char front() {
		if (stack2.isEmpty()) {
			return stack1.front();
		} else {
			return stack2.top();
		}

	}

	@Override
	public void enqueue(char o) {
	    stack1.push(o);
	}

	@Override
	public char dequeue() {
		if (stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		System.out.print(stack2.pop());
		return 0;
	}
	
	public static void main(String args[]) {
		StackQueue stackqueue = new StackQueue();
		
		stackqueue.enqueue('a');
		stackqueue.enqueue('b');
		stackqueue.enqueue('c');
		stackqueue.enqueue('d');
		stackqueue.enqueue('e');
		stackqueue.dequeue();
		stackqueue.dequeue();
		stackqueue.dequeue();
		stackqueue.enqueue('f');
		stackqueue.enqueue('g');
		stackqueue.enqueue('h');
		stackqueue.enqueue('i');
		stackqueue.enqueue('j');
		stackqueue.dequeue();
		stackqueue.dequeue();
		stackqueue.dequeue();
		stackqueue.enqueue('k');
		stackqueue.enqueue('l');
		stackqueue.enqueue('m');
		stackqueue.enqueue('n');
		stackqueue.enqueue('o');
		stackqueue.dequeue();
		stackqueue.dequeue();
		stackqueue.dequeue();
		stackqueue.dequeue();
		stackqueue.dequeue();
		stackqueue.dequeue();
		stackqueue.dequeue();
		
		System.out.print('\n');
		
		while(!stackqueue.isEmpty()) {
			stackqueue.dequeue();
		}
	}
}
