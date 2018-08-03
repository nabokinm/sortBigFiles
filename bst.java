import java.util.ArrayList;
import java.util.List;
import java.util.Vector;





public class bst {
	
	// Node class for Binary Search Tree
	private class Node{

			
			int key;
	        int treeSize;
	        Node l;
	        Node r;
	        List<String> values;
	        

	        private Node(){
	        	values=  new ArrayList<String>();
	        }
	        
	        private Node(int aKey, List<String> value){
	        	values=  value;
	        	key=aKey;
	        }
	        
	        	
	        } 
	    
	
	Node root;
	Vector sortedSequence;//to return keys from binary tree in sorted order
	
	
	
	public Node getRoot() {
		return root;
		
	}

	public bst(){
        this.root = null;
        sortedSequence=new Vector();
        
    }
	
	  public List<String> contains(int key){
	    		    	
	    	return search(root, key); 	
	    }
	    
//search binarytree method. if less than valuse search left, 
//if more than value go right, else (equal to value) - return this node.
// Note that this method returns list string (list of different properties of this entry)
	    private List<String> search(Node p, int key) {
	    	 if (p == null)
		         return null;
		      else
		      if (key==p.key)
		      	return p.values;
		      else
		      if (key<p.key)
		         return search(p.l, key);
		      else
		         return search(p.r, key);
		}
	    
	    public boolean contain(int key){
	    	
	    	return searchs(root, key); 	
	    }
	    
//returns true if key is found and false otherwise
	    private boolean searchs(Node p, int key) {
	    	 if (p == null)
		         return false;
		      else
		      if (key==p.key)
		      	return true;
		      else
		      if (key<p.key)
		         return searchs(p.l, key);
		      else
		         return searchs(p.r, key);
		}
	    
	    public Vector sortTree(){
			sortTree(root);
			
			return sortedSequence;
			
	    }
//to return sort list of keys just return inorder traversal (left-root-right)
	    private void sortTree(Node t){
	        if (t!=null){
	        	sortTree(t.l);
	        	sortedSequence.addElement(t.key);
	        	sortTree(t.r);
	        }
	    }
	    
	    public void insert(int key, List<String> val){
	        	       
	           root = insert(root, key, val);
	        
	               
	        }
	    		
//insert key and element at right place to maintain bst property
	    	private	Node insert(Node p, int keys, List<String> value){
	    		if (p == null){
	    			Node aNode =new Node (keys, value);
	                return aNode;
	    		}

	            
	             if (keys<p.key)
	                p.l = insert(p.l, keys,value);
	             else
	                p.r = insert(p.r, keys, value);

	             return p;
	    	}
	    	
	    	   public void print(){
	   			print(root);
	   			   			
	   	    }
//print node in inorder traversal order
	   	    private void print(Node t){
	   	        if (t!=null){
	   	        	print(t.l);
	   	        	System.out.println("Key: " + t.key + ", value: " + t.values);
	   	        	print(t.r);
	   	        }
	   	    }
	   	    
	   	 public void delete(int aKey){
	     	
	     	      root = delete(root, aKey);


	     	  
	     }
//delete a node and perform necessary adjustments to keep bst organized
	     private Node delete(Node p, int aKey) {
	     	 if (p == null)  
	     		 return null;
	         //no children cases-just delete no adjustments 
	     	 else
	          if (aKey<p.key)
	          p.l = delete (p.l, aKey);
	          else
	          if (aKey>p.key)
	          p.r = delete (p.r, aKey);
	     	 //node with children has to adjust
	          else
	          {		//if only one child - replace parent with a child and delete child
	             if (p.l == null) return p.r;
	             else
	             if (p.r == null) return p.l;
	            //case with 2 children
	             else
	             {
	             // get data from the rightmost node in the left subtree
	                p.key = retrieveData(p.l);
	             // delete the rightmost node in the left subtree
	                p.l =  delete(p.l, p.key) ;
	             }
	          }
	          return p;
	 	      }
	     
	     private int retrieveData(Node p)
		   {
		      while (p.r != null) 
		    	  p = p.r;

		      return p.key;
		   }
	     
	     public int preorder(int key){
	    	 if(root.key==key){
	    		 System.out.println("No previous for the root!");
	    		
	    	 }
	    		 
	    	int prev =preorder(root, key);
	    	return prev;
	     }
	     //this method is used to return a previous node- it is a parent node 
	     private int preorder(Node p, int aKey){

	    	
	    	 if (p == null)
		         return -1;
		      else
		      if (p.l!=null&&aKey==p.l.key)
		      	return p.key;
		      else if(p.r!=null&&aKey==p.r.key)
		    	  return p.key;
		      else
		      if (aKey<p.key)
		         return preorder(p.l, aKey);
		      else
		         return preorder(p.r, aKey);
	    		 
	    	 
	     }
	     
	     public int next(int key){
	    		 
	    	int next =next(root, key);
	    	return next;
	     }
	   //this method is used to return a next node- it is a left or right child of 
	     //a current node
		private int next(Node p, int aKey) {
			 if (p == null)
		         return -1;
		      else
		      if (p.l!=null&&aKey==p.key)
		      	return p.l.key;
		      else if(p.r!=null&&aKey==p.key)
		    	  return p.r.key;
		      else
		      if (aKey<p.key)
		         return next(p.l, aKey);
		      else
		         return next(p.r, aKey);
			
		}
}
