package Queue;
import java.util.Scanner;

public class ArrayStack implements Stack {
	public static Scanner sc = new Scanner(System.in);
	
	private int top;
    private int stackSize;
    private char stackArr[];
    
    public ArrayStack(int stackSize) {
        top = -1;    // 스택 포인터 초기화
        this.stackSize = stackSize;    // 스택 사이즈 설정
        stackArr = new char[this.stackSize];    // 스택 배열 생성
    }


    public char front() {
    	return stackArr[0];
    }
    
	@Override
	public int size() {
		return top+1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top == -1);
	}

	@Override
	public char top() {
		if(isEmpty()) {
            System.out.println("Peeking fail! Stack is empty!");
            return 0;
        } else { 
            System.out.println("Peeked Item : " + stackArr[top]);
            return stackArr[top];
        }
	}

	@Override
	public void push(char o) {
		 if(top == this.stackSize-1) {
	            System.out.println("Stack is full!");
	        } else {             
	            stackArr[++top] = o;    // 다음 스택 포인터가 가리키는 인덱스에 데이터 추가

	        }
	}

	@Override
	public char pop() {
		 if(isEmpty()) {
	            System.out.println("Deleting fail! Stack is empty!");
	            return 0;
	        } else { 
	            return stackArr[top--];
	        }     
	}
		 public void printStack() {
		        if(isEmpty()) {
		            System.out.println("Stack is empty!");
		        } else {
		            System.out.print("Stack elements : ");
		            for(int i=0; i<=top; i++) {
		                System.out.print(stackArr[i] + " ");
		            }
		            System.out.println();
		        }
	}
	

	 public static void main(String args[]) {
		 	char[] input = sc.nextLine().toCharArray();
		 	int stackSize = input.length;
	        
	        ArrayStack arrStack = new ArrayStack(stackSize);
	        
	        for (int i  = 0; i < stackSize; i++) {
	        	arrStack.push(input[i]);
	        }
	        String res = "";
	        for (int i  = 0; i < stackSize; i++) {
	        	char temp = arrStack.pop();
	        	if (temp == '(') {
	        		res += ')';
	        	} else if (temp == ')') {
	        		res += '(';
	        	} else {
	        		res += temp;
	        	}
	        	
	        }
	        System.out.println(res);
	    }
}
