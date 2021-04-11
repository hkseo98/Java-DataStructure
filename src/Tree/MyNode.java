package Tree;
import java.util.ArrayList;

public class MyNode {
	private Object element;
	private MyNode parent;
	private ArrayList children;
	private int value;
	
	MyNode() {
		element = null; 
		parent = null; 
		children = null;
		value = 0;
	}
	public MyNode(Object e) {
        this.element = e;
        this.parent = null;
        this.children = new ArrayList();
       
    }
	
	public MyNode(Object e, int value) {
        this.element = e;
        this.parent = null;
        this.children = new ArrayList();
        this.value = value;
    }
	
		public int getvalue() {
	        return this.value;
	    }
		
		public void setvalue(int v) {
			this.value = v;
	    }
	
		public Object element() {
	        return this.element;
	    }
	    
	    public MyNode parent() {
	        return this.parent;
	    }
	    
	    public ArrayList children() {
	        return this.children;
	    }
	    
	    public int degree() {
	        return this.children.size();
	    }
	    
	    public void setElement(Object e) {
	        this.element = e;
	    }
	    
	    public void setParent(MyNode p) {
	        this.parent = p;
	    }
	    
	    public void setChildren(ArrayList c) {
	        this.children = c;
	    }
	    
	    public int depth(MyNode v) {
	    	if (v.parent() == null) {
	    		return 0;
	    		}
	    	else {
	    		return depth(v.parent()) + 1;
	    	}
	    }
	   
	
}
