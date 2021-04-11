package ListAndIterator;

public class MyStack extends MyArrayList {
	
	MyArrayList myarr = new MyArrayList();
	
	 public void push(Integer i){
	        myarr.addLast(i);
	    }
	 
	 public Object pop() {
	        Object popped = myarr.removeLast();
	        return popped;
	    }
	 
	 public Object top(){
	        return myarr.get(myarr.size()-1);
	    }
	 
	 public int size(){
	        return myarr.size();
	    }
	 
	 public boolean isEmpty(){
	        return myarr.isEmpty();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack mystack = new MyStack();
		
		mystack.push(1);
		mystack.push(2);
		mystack.push(3);
		mystack.push(4);
		mystack.push(5);
		mystack.push(6);
		mystack.push(7);
		mystack.push(8);
		mystack.push(9);
		mystack.push(10);
		
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());

	}

}
