package Problem1;

public class ProblemMain {
    public static void main(String args[]) {
    	MyBinTree tree = new MyBinTree(23);
    	MyBinNode c1 =  tree.inserLeft(tree.root(), 10);
    	MyBinNode c2 = tree.inserRight(tree.root(), 33);
    	MyBinNode c3 = tree.inserLeft(c1, 7);
    	MyBinNode c4 = tree.inserRight(c1, 17);
    	MyBinNode c5 = tree.inserLeft(c2, 27);
    	MyBinNode c6 = tree.inserRight(c2, 33);
    	MyBinNode c7 = tree.inserRight(c3, 10);
    	MyBinNode c8 = tree.inserLeft(c4, 13);
    	MyBinNode c9 = tree.inserRight(c4, 20);
    	MyBinNode c10 = tree.inserLeft(c5, 25);
    	MyBinNode c11 = tree.inserRight(c5, 30);
    	
    	MyBinTree subtree = new MyBinTree(33);
    	MyBinNode l1 = subtree.inserLeft(subtree.root(), 27);
    	subtree.inserLeft(l1, 25);
    	
    	SubFinder sub = new SubFinder();
    	int rootNum = sub.subfind(tree.root(), subtree.root());
    	
    	System.out.println(rootNum);
    }
}