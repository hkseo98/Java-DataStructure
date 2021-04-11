package Tree;
import java.util.ArrayList;

public class MyTree extends MyNode {
	private MyNode root;
    private int totalSize;
    
    public MyTree() {
        this.root = null;
        this.totalSize = 0;        
    }
    
    public MyTree(Object e) {        
        this.root = new MyNode(e);                    
        this.totalSize = 1;
    }
    
    public int size() {
        return this.totalSize;
    }
    
    public MyNode root() {
        return this.root;
    }
    
    public ArrayList children(MyNode v) {
        return v.children();
    }
    
    public boolean isExternal(MyNode v) {
        return v.children().isEmpty();
    }
    
    public MyNode addRoot(Object e) {
        MyNode temp = this.root;
        this.root = new MyNode(e);            
        this.totalSize = 1;
        return temp;        
    }
    
    public MyNode addNode(Object e) {
        MyNode newNode = new MyNode(e);        
        newNode.setParent(this.root);
        this.root.children().add(newNode);        
        this.totalSize++;
        return newNode;
    }
    
    public MyNode addChild(MyNode v, Object e) {
        MyNode newNode = new MyNode(e);    
        newNode.setParent(v);
        v.children().add(newNode);
        this.totalSize++;
        return newNode;
    }
    
    public MyNode addChild(MyNode v, Object e, int val) {
        MyNode newNode = new MyNode(e, val);        
        newNode.setParent(v);
        v.children().add(newNode);
        this.totalSize++;
        return newNode;
    }
    
    public MyNode setChild(MyNode v, int i, Object e) {
        MyNode newNode = new MyNode(e);        
        newNode.setParent(v);
        v.children().set(i, newNode);
        return newNode;
    }
    
    public MyNode removeChild(MyNode v, int i) {
        this.totalSize--;
        return (MyNode)v.children().remove(i);
    }
    
    
    public void PreOrder(MyNode v) {
    	int depth = v.depth(v);
    	for (int i = 0; i < depth; i++) {
    		System.out.printf("%s", " ");
    	}
    	System.out.println(v.element());
    	for (Object i : v.children()) {
    		PreOrder(((MyNode) i));
    	}
    }
    
    
    public void BackOrder(MyNode v) {
    	for (Object i : v.children()) {
    		BackOrder(((MyNode) i));
    	}
    	if (v.children().isEmpty() == false) {
    		int kb = 0;
    		for (Object i : v.children()) {
    			kb += ((MyNode) i).getvalue();
    		}
    		System.out.printf("%s %s %s%s\n", v.element(), "=", kb, "KB");
    		v.setvalue(kb);
    	}
    }
    	
    
    public static void main(String args[]) {
    	
    	MyTree mytree = new MyTree();
    	mytree.addRoot("Computers’R Us");
    	MyNode node1 = mytree.addChild(mytree.root(), "Sales");
    	MyNode node2 = mytree.addChild(mytree.root(), "Manufacturing");
    	MyNode node3 = mytree.addChild(mytree.root(), "R&D");
    	MyNode node4 = mytree.addChild(node1, "US");
    	MyNode node5 = mytree.addChild(node1, "International");
    	MyNode node6 = mytree.addChild(node2, "Laptops");
    	MyNode node7 = mytree.addChild(node2, "Desktops");
    	MyNode node8 = mytree.addChild(node5, "Europe");
    	MyNode node9 = mytree.addChild(node5, "Asia");
    	MyNode node10 = mytree.addChild(node5, "Canada");
    	
    	
    	System.out.println("[Level 0]");
    	System.out.println(mytree.root().element());
    	
    	System.out.println("[Level 1]");
    	System.out.printf("%s %s %s\n", node1.element(), node2.element(), node3.element());
 
    	System.out.println("[Level 2]");
    	System.out.printf("%s %s %s %s\n", node4.element(), node5.element(), node6.element(), node7.element());
    	
    	System.out.println("[Level 3]");
    	System.out.printf("%s %s %s\n\n\n", node8.element(), node9.element(), node10.element());
    	
    	
    	MyTree mytree2 = new MyTree();
    	mytree2.addRoot("Make Money Fast!");
    	MyNode n1 = mytree2.addChild(mytree2.root(), "1. Motivations");
    	MyNode n2 = mytree2.addChild(mytree2.root(), "2. Methods");
    	MyNode n3 = mytree2.addChild(n1, "1.1 Greed");
    	MyNode n4 = mytree2.addChild(n1, "1.2 Avidity");
    	MyNode n5 = mytree2.addChild(n2, "2.1 Stock Fraud");
    	MyNode n6 = mytree2.addChild(n2, "2.2 Ponzi Scheme");
    	MyNode n7 = mytree2.addChild(n2, "2.3 Bank Robbery");
    	mytree2.PreOrder(mytree2.root());
    	System.out.println();
    	System.out.println();
    	
    	
    	MyTree mytree3 = new MyTree();
    	mytree3.addRoot("cs16/");
    	MyNode n_1 = mytree3.addChild(mytree3.root(), "homeworks/");
    	MyNode n_2 = mytree3.addChild(mytree3.root(), "programs/");
    	MyNode n_3 = mytree3.addChild(mytree3.root(), "todo.txt", 1);
    	MyNode n_4 = mytree3.addChild(n_1, "h1c.doc", 3);
    	MyNode n_5 = mytree3.addChild(n_1, "h1nc.doc", 2);
    	MyNode n_6 = mytree3.addChild(n_2, "DDR.java", 10);
    	MyNode n_7 = mytree3.addChild(n_2, "stocks.java", 25);
    	MyNode n_8 = mytree3.addChild(n_2, "Robot.java", 20);
    	mytree3.BackOrder(mytree3.root());
    	
    }
}
