package Tree;

public class MyBinTree extends MyTree {
	 	MyBinTree(){
	        super();
	    }
	    
	    MyBinTree(Object e){
	        super(e);                            
	    }
	    
	    public boolean isEmpty() {
	        return super.size() == 0; // super - 자식 클래스에서 상속받은 부모 클래스의 멤버변수를 참조할때 사용
	    }
	    
	    public boolean isRoot(MyBinNode v) {
	        return v.parent() == null;
	    }
	    
	    public boolean isInternal(MyBinNode v) {
	        return !this.isExternal(v);        
	    }
	    
	    public boolean isExternal(MyBinNode v) {
	        if(!this.hasLeft(v) && !this.hasRight(v))
	            return true;
	        else
	            return false;
	    }
	    
	    public MyBinNode root() {        
	        return (MyBinNode)super.root();
	    }
	    
	    public MyBinNode parent (MyBinNode v) {
	        return (MyBinNode)v.parent();
	    }
	    
	    public MyBinNode left (MyBinNode v) {
	        return (MyBinNode)v.children().get(0);
	    }
	    
	    public MyBinNode right (MyBinNode v) {
	        return (MyBinNode)v.children().get(1);
	    }
	    
	    public boolean hasLeft (MyBinNode v) {        
	        return v.children().get(0) != null;
	    }
	    
	    public boolean hasRight (MyBinNode v) {        
	        return v.children().get(1) != null;
	    }
	    
	    public MyBinNode addRoot (Object e) {        
	        return (MyBinNode)super.addRoot(e);                    
	    }
	    
	    public MyBinNode insertLeft(MyBinNode v, Object e) {
	        
	        MyBinNode mbn = null;
	        
	        if(!this.hasLeft(v)) {            
	            mbn = (MyBinNode)super.setChild(v, 0, e);            
	        }
	        
	        return mbn;
	    }
	    
	    public MyBinNode insertRight(MyBinNode v, Object e) {        
	        
	        MyBinNode mbn = null;
	        
	        if(!this.hasRight(v)) {
	            mbn = (MyBinNode)super.setChild(v, 1, e);            
	        }
	        
	        return mbn;        
	    }
	    
	    public MyBinNode addNode (Object e) {
	                    
	        MyBinNode return_node = null;
	                                                
	        if(hasLeft((MyBinNode)super.root()) && hasRight((MyBinNode)super.root())) {
	            // 루트노드의 자식이 2개면 노드 추가 불가능.
	            System.out.println("Can't add Node because Two Children exist !");
	        }
	        else if(hasLeft((MyBinNode)super.root())) {            
	            // 왼쪽자식만 있다면 오른쪽 자식으로추가.                                                                                 
	            return_node =  this.insertRight((MyBinNode)super.root(), e);
	        }
	        else if(hasRight((MyBinNode)super.root())){                                                                                   
	            return_node =  this.insertLeft((MyBinNode)super.root(), e);
	        }
	        else {
	            // 자식이 없다면 왼쪽 자식으로 삽입.         
	            return_node =  this.insertLeft((MyBinNode)super.root(), e);
	        }
	        
	        return return_node;
	    }
	    
	    public Object replace(MyBinNode v, Object e) {
	        Object temp = v.element();
	        v.setElement(e);
	        return temp;
	    }
	    
	    public MyBinNode remove(MyBinNode v) throws TwoChildrenException {
	        
	        MyBinNode parent = (MyBinNode)v.parent();
	        
	        int idx = 0;
	        
	        if(this.left(parent) == v) {
	            // v가 parent의 leftNode
	            idx = 0;
	        }
	        else {
	            // v가 parent의 rightNode
	            idx = 1;
	        }
	        
	        if(this.hasLeft(v) && this.hasRight(v)) {
	            // 지우려는 노드가 자식이 둘이면 못 지움.
	            throw new TwoChildrenException("TwochildException!!");
	        }
	        else if(this.hasLeft(v)) {
	            // 왼쪽 자식만 있다면 v를 지우고 v가 있던 자리에 v의 왼쪽 자식을 연결.         
	            MyBinNode children = (MyBinNode)v.children().get(0);
	            parent.children().set(idx, children);
	            children.setParent(parent);                            
	        }
	        else if(this.hasRight(v)) {
	            MyBinNode children = (MyBinNode)v.children().get(1);            
	            parent.children().set(idx, children);
	            children.setParent(parent);                    
	        }
	        else {         
	            parent.children().set(idx, null);                
	        }        
	            
	        return v;
	    }
	    
	    public void attach (MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException{
	        
	        if(this.isExternal(v)) { // v가 External이면 붙이고 아니면 예외처리 
	            this.insertLeft(v, t1.element());
	            this.insertRight(v, t2.element());
	        }
	        else {
	            throw new NotExternalException("NotExternalException !!");
	        }
	        
	    }
	    
	    public void preOrder(MyBinNode v) {
	        
	        System.out.print(v.element()+" ");
	        
	        if(this.hasLeft(v))
	            preOrder(this.left(v));
	        
	        if(this.hasRight(v))
	            preOrder(this.right(v));
	        
	        
	    }
	    
	    public void inOrder(MyBinNode v) {
	        
	        if(this.hasLeft(v)) {
	            System.out.print("(");
	            inOrder(this.left(v));
	        }
	                    
	        System.out.print(v.element()+"");        
	        
	        if(this.hasRight(v)) {
	            inOrder(this.right(v));
	            System.out.print(")");
	        }
	        
	    }
	    
	    
	    public int postOrder(MyBinNode v) {
	        
	        if(this.isExternal(v)) {
	        	return (int) v.element();
	        } else {
	        	int x = postOrder(v.left());
	        	int y = postOrder(v.right());
	        	char op = (char) v.element();
	        	
	        	if(op == '+') {
	        		return x + y;
	        	}
	        	else if(op == '-') {
	        		return x - y;
	        	}
	        	else if(op == '*') {
	        		return x * y;
	        	}
	        	else {
	        		return x / y;
	        	}
	        }
	    }
	    
	    
	    class TwoChildrenException extends Exception {
	        
	        TwoChildrenException(String msg){
	            super(msg);
	        }
	        
	    }
	    
	    class NotExternalException extends Exception {
	        
	        NotExternalException(String msg){
	            super(msg);
	        }
	    }
	    
	    
	public static void main(String args[]) {
		
		MyBinTree Tree = new MyBinTree('+');
		MyBinNode root = Tree.root();
		MyBinNode n2 = (MyBinNode) Tree.insertLeft(root, '*');
		MyBinNode n3 = (MyBinNode) Tree.insertRight(root, '*');
		MyBinNode n4 = (MyBinNode) Tree.insertLeft(n2, 2);
		MyBinNode n5 = (MyBinNode) Tree.insertRight(n2, '-');
		MyBinNode n6 = (MyBinNode) Tree.insertLeft(n3, 3);
		MyBinNode n7 = (MyBinNode) Tree.insertRight(n3, 2);
		MyBinNode n8 = (MyBinNode) Tree.insertLeft(n5, 3);
		MyBinNode n9 = (MyBinNode) Tree.insertRight(n5, 1);
		
		Tree.inOrder(root);
		System.out.print('=');
		System.out.print(Tree.postOrder(root));
		
	}
}
