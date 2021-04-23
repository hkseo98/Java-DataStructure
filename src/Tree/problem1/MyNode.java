package Tree;
import java.util.ArrayList;

public class MyNode {
    
	private String name;
    private int value;
    private MyNode parent;
    private ArrayList children;
    private int height;

    
    public MyNode() { // 생성자.
    	this.name = null;
        this.parent = null;
        this.children = new ArrayList(); 
        this.height = 0;
    }
 
    
    public MyNode(String name, int value) { // 생성자.
    	this.name = null;
        this.value = value;
        this.parent = null;
        this.height = 0;
        this.children = new ArrayList();  
    }

	public int value() {
        return this.value;
    }
    
    public MyNode parent() {
        return this.parent;
    }
    
    public String name() {
    	return this.name;
    }
    
    public int height() {
    	return this.height;
    }
    
    public ArrayList children() {
        return this.children;
    }
    
    public int degree() {
        return this.children.size();
    }
    
    public void setValue(int val) {
        this.value = val;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setParent(MyNode p) {
        this.parent = p;
    }
    
    public void setChildren(ArrayList c) {
        this.children = c;
    }
    
    public void setHeght(int h) {
        this.height = h;
    }
 
}
