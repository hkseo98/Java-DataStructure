package ListAndIterator;

public class MyQueue extends MyArrayList{
	
	MyArrayList myarr = new MyArrayList();
	
	public boolean isEmpty(){
        return myarr.isEmpty();
    }
	
	public int size(){
        return myarr.size();
    }
	
	public Object front(){
        return myarr.get(0);
    }

	public void enqueue(Integer i){
		myarr.addLast(i);
    }
	
	 public Object dequeue() {
	        Object dequeued = myarr.removeFirst();
	        return dequeued;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyQueue myqueue = new MyQueue();
		
		myqueue.enqueue(1);
		myqueue.enqueue(2);
		myqueue.enqueue(3);
		myqueue.enqueue(4);
		myqueue.enqueue(5);
		myqueue.enqueue(6);
		myqueue.enqueue(7);
		myqueue.enqueue(8);
		myqueue.enqueue(9);
		myqueue.enqueue(10);
		
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
	}

}
