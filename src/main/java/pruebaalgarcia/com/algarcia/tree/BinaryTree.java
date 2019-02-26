package pruebaalgarcia.com.algarcia.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	
	static Node root;
	private static List<Integer> path1 = new ArrayList(); 
    private static List<Integer> path2 = new ArrayList(); 
	
/*	public static void main(String[] args) {
		System.out.println("Hola");
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree();
		bt.traverseInOrder(root);
	}*/
	
	private Node addRecursive(Node current, int value) {
	    if (current == null) {
	        return new Node(value);
	    }
	 
	    if (value < current.value) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.value) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        // value already exists
	        return current;
	    }
	 
	    return current;
	}
	
	public void add(int value) {
	    root = addRecursive(root, value);
	}
	
	public BinaryTree createBinaryTree(String values) {
	    BinaryTree bt = new BinaryTree();
	 
	    String[] passedValues = values.split(",");
		for(int i = 0; i < passedValues.length; i++) {
			System.out.println(passedValues[i]);
			bt.add(Integer.parseInt(passedValues[i]));
		}
	    
//	    bt.add(6);
//	    bt.add(4);
//	    bt.add(8);
//	    bt.add(3);
//	    bt.add(5);
//	    bt.add(7);
//	    bt.add(9);
	 
	    return bt;
	}
	
	public void traverseInOrder(Node node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" " + node.value);
	        traverseInOrder(node.right);
	    }
	}
	
	// Finds the path from root node to given root of the tree. 
    public Integer findLCA(Integer n1, Integer n2) { 
        path1.clear(); 
        path2.clear(); 
        return findLCAInternal(root, n1, n2); 
    } 
  
    private int findLCAInternal(Node root, int n1, int n2) { 
  
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) { 
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing"); 
            return -1; 
        } 
  
        int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++) { 
              
        // System.out.println(path1.get(i) + " " + path2.get(i)); 
            if (!path1.get(i).equals(path2.get(i))) 
                break; 
        } 
  
        return path1.get(i-1); 
    } 
      
    // Finds the path from root node to given root of the tree, Stores the 
    // path in a vector path[], returns true if path exists otherwise false 
    private boolean findPath(Node root, int n, List<Integer> path) 
    { 
        // base case 
        if (root == null) { 
            return false; 
        } 
          
        // Store this node . The node will be removed if 
        // not in path from root to n. 
        path.add(root.value); 
  
        if (root.value == n) { 
            return true; 
        } 
  
        if (root.left != null && findPath(root.left, n, path)) { 
            return true; 
        } 
  
        if (root.right != null && findPath(root.right, n, path)) { 
            return true; 
        } 
  
        // If not present in subtree rooted with root, remove root from 
        // path[] and return false 
        path.remove(path.size()-1); 
  
        return false; 
    } 

}
