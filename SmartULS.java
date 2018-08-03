import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Vector;

//Universal and adaptable SmartULS data structure is used to perform 
//several operations on large relatively data sets. 
//Supports add,delete,sort,search operations.
//Implemented with the Hash Table or binary search tree depending on the input size.
//Switch between Hash Table or Binary search tree is done automatically
//as more elements added or deleted.
public class SmartULS {

	private int size;
	private Vector vectorKeys;//sequence of keys
	private Hashtable<Integer, List<String>> hash;//Hash table with list of values acessible by key
	private bst binaryTree;//Binary search tree

	
	//General getters and setters
	public int getSize() {
		return size;
	}
	
	//default constructor
	public SmartULS(){
		size=0;
		vectorKeys=new Vector();
		hash= new Hashtable();
		binaryTree=new bst();
	}
	
	public SmartULS(Vector v){
		size=v.size();
		setVectorKeys(v);
		
	}
	
	public void setVectorKeys(Vector vectorKeys) {
		this.vectorKeys = vectorKeys;
	}
	//randomly generates new non-existing key of 8 digits
	public int generate(){
		Random rnd = new Random();
		int n = 10000000 + rnd.nextInt(90000000);
		
		if (size==0)
				return n;
		
		if (size<1000){
			while(hash.containsKey(n)){
				n = 100000 + rnd.nextInt(90000000);
			}
		}
		
		if(size>=1000){
			while(binaryTree.contain(n)){
				n = 100000 + rnd.nextInt(90000000);
			}
		}
		
		return n;
	}
	//depending on input size set data structure as HashTable or BST
	public void setSmartThresholdULS(int size) {
		if (size<1000)
		{
			createHashTable();
		}
		else
		{
			createBSTree();
		}
	}

	private void createHashTable() {
		Hashtable<Integer, List<String>> hash = new Hashtable<Integer, List<String>>();
		setVectorKeys(new Vector()); 
		
	}

	private void createBSTree() {
		bst tree = new bst();
		
	}
	
	//return all keys in SmartULS as a sorted sequence. For Hash Table
	//Quick sort is used expected complexity O(nlogn), worst case O(n^2)
	//For bst sorting is O(nlogn) - inorder traversal
	public Vector allKeys(SmartULS aULS){
		
		//size set at 10 for test purposes
		if(size<10){
		Vector sortedSequence = new Vector(getVectorKeys());
		
		QuickSort(sortedSequence, 0, sortedSequence.size() - 1);
		
		return sortedSequence;}
		
		if (size>=10){
			return binaryTree.sortTree();
		}
		
		return null;
	}
//implementation of Quick sort algorithm
	private void QuickSort(Vector v, int low, int high) {
		
		int l = low;
	    int h = high;
	    int mid;
	    
	    if (high > low) {
    mid = (int) v.elementAt((low + high) / 2);

    while (l <= h) {

        while ( (l < high)
            && (int) v.elementAt(l)<mid)
          ++l;

        
        while ((h > low)
            && (int) v.elementAt(h)>mid)
          --h;

        // if the indexes have not crossed, swap
        if (l <= h)
          swap(v, l++, h--);
      }

      // if the right index has not reached the left side of array
      // must now sort the left partition
      if (low < h)
        QuickSort(v, low, h);

      // if the left index has not reached the right side of array
      // must now sort the right partition
      if (l < high)
        QuickSort(v, l, high);
    }
	}
//Auxiliary method to swap element in the sequence.
	private void swap(Vector v, int i, int j) {
		
		   int o= (int)v.elementAt(i);
		    v.setElementAt(v.elementAt(j), i);
		    v.setElementAt(o, j);
		  	}
	
	
	
//Add element in SmartULS. At a point Hash Table is converted to bst 
//and all elements are copied accordingly
	public void add(SmartULS aULS,int key,List<String> value){
		
		if (size==9){
			convertHashTableToTree();
			binaryTree.insert(key, value);
			
		}
			else{
				if (size<10){
					getVectorKeys().addElement(key);
					hash.put(key, value);
					
							}
				if (size>=10){
					binaryTree.insert(key, value);
								}
				}
		size++;
	}
//Auxiliary method to convert Hash Table to BST.
	private void convertHashTableToTree() {
		
		for (int i = 0; i < vectorKeys.size(); i++) {
			int key = (int) vectorKeys.elementAt(i);
			
			binaryTree.insert(key, hash.get(key));
			
		}
		size=vectorKeys.size();
		hash.clear();
		vectorKeys.clear();
	}
	//Auxiliary method to convert BST to Hash Table.	
	private void convertTreeToHashTable() {
		
		vectorKeys=binaryTree.sortTree();
		for (int i = 0; i < vectorKeys.size(); i++) {
			int key = (int) vectorKeys.elementAt(i);
			hash.put(key, getvalues(this, key));
			// (this, key, getvalues(this, key));
			
		}
		size=vectorKeys.size();
		
	}
//Delete entry. At a point BST is converted to the Hash Table
	public void remove(SmartULS aULS,int key){
		
		if (size<10&&!getVectorKeys().contains(key)){
			System.out.println(key + " does not exist in the database.");
			
		}
		else if (size>=10&&!binaryTree.contain(key)){
			System.out.println(key + " does not exist in the database.");
			
		}
		else{
				if(size==10)
				{
					convertTreeToHashTable();
					getVectorKeys().removeElement(key);
					hash.remove(key);
					binaryTree=null;
				}
				if(size<10)
				{
					getVectorKeys().removeElement(key);
					hash.remove(key);
				}
				if(size>10)
				{
					binaryTree.delete(key);
				}
				size--;
		}
		
	}
	
	//Return values associated with a given key
	public List<String> getvalues(SmartULS aULS,int key){
		
		if (size<10&&!getVectorKeys().contains(key)){
			System.out.println(key + " does not exist in the database.");
			return null; 
		}
		else{
			if(size<10)
			return hash.get(key);
			else{
				return binaryTree.contains(key);
			}
			
		}
		
	}
	
//return next key for a given key. In hashTabke next key is next in linked
//list sense. In bst nex is left or right child (can be also changed to return
// next in inorder traversal if necessary).
	public int nextKey(SmartULS aULS,int key){
		if(size<10){
		if (!getVectorKeys().contains(key)){
			System.out.println(key + " does not exist in the database.");
			return -1;
		}
		int currentIndex=getVectorKeys().indexOf(key);
		
		if (getVectorKeys().size()-1==currentIndex){
			System.out.println("No next element because " + key + " was the last key.");
			return -1;
		}
		
		return (int) getVectorKeys().elementAt(currentIndex+1);
		}
		else{
			return binaryTree.next(key);
		}
	}
	
//return previous key for a given key. In hashTabke previous key is previous in 
//linked list sense. In bst previous is a parent (can be also changed to return
// previous in inorder traversal if necessary).
	public int prevKey(SmartULS aULS,int key){
		if(size<10){
		if (!getVectorKeys().contains(key)){
			System.out.println(key + " does not exist in the database.");
			return -1;
		}
		int currentIndex=getVectorKeys().indexOf(key);
		
		if (currentIndex==0){
			System.out.println("No prevoius element because " + key + " is the first key.");
			return -1;
		}
		
		return (int) getVectorKeys().elementAt(currentIndex-1);
		}
		
		else{
			return binaryTree.preorder(key);
			
		}
	}
//returns the number of keys that are within 
//the specified range of the two keys key1 and key2.
	public int rangeKey(int key1, int key2){
		if(size<10){
		if (!getVectorKeys().contains(key1)||!getVectorKeys().contains(key2)){
			System.out.println(" One or both keys does not exist in the database.");
			return -1;
		}
		
		Vector sorted = allKeys(this);
		int result =0;
		boolean firstKeyFound=false;
		
		for(int i =0; i< sorted.size();i++){
			if ((int)sorted.elementAt(i)==key1){
				firstKeyFound=true;
				result++;
				continue;
			}
			if((int)sorted.elementAt(i)==key2){
				result++;
				break;
			}
			if (firstKeyFound)
				result++;
		}
		
		return result;
		}
		else{
		if(!binaryTree.contain(key1)||!binaryTree.contain(key2)){
			System.out.println(" One or both keys does not exist in the database.");
		return -1;}
		
		Vector sorted = allKeys(this);
		int result =0;
		boolean firstKeyFound=false;
		
		for(int i =0; i< sorted.size();i++){
			if ((int)sorted.elementAt(i)==key1){
				firstKeyFound=true;
				result++;
				continue;
			}
			if((int)sorted.elementAt(i)==key2){
				result++;
				break;
			}
			if (firstKeyFound)
				result++;
		}
		
		return result;
		}
	}

	public Vector getVectorKeys() {
		return vectorKeys;
	}


//print all key and values	
	public void print(){
		if (size==0){
			System.out.println("Nothing to print. The database is empty.");
		}
		
		if (size<10){
			
			for (int i = 0; i < vectorKeys.size(); i++) {
				System.out.println("Key: " + vectorKeys.elementAt(i) + 
						", value: " + hash.get(vectorKeys.elementAt(i))); 
			}
		}
		if (size>=10){	
			binaryTree.print();
		}
	}
}
