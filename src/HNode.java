
public class HNode{
	public HNode leftChild, rightChild;
	public String symbolSet;
	public int cumFreq;
	
	/**
	 * create a halfman tree node using character and frequency of the character
	 * @param c the character
	 * @param f the frequency of the character
	 */
	public HNode (char c, int f){
		this.cumFreq = f;
		this.symbolSet = "" + c;
	}
	
	/**
	 * create a halfman tree node using the left child and right child
	 * @param left the leftchild of the node
	 * @param right the rightchild of the node
	 */
	public HNode (HNode left, HNode right){
		this.leftChild = left;
		this.rightChild = right;
		this.symbolSet = this.leftChild.symbolSet + this.rightChild.symbolSet;
		this.cumFreq = this.leftChild.cumFreq + this.rightChild.cumFreq;
	}
	
	/**
	 * @return whether the node is a leaf
	 */
	public boolean isLeaf(){
		return leftChild == null && rightChild == null;
	}
	
	/**
	 * @param ch the given character
	 * @return whether the node contains the given character
	 */
	public boolean contains(char ch){
		return symbolSet.indexOf(ch) != -1;
	}
	
	
	public HNode getLeft(){
		return this.leftChild;
	}
	
	public HNode getRight(){
		return this.rightChild;
	}

	@Override
	public String toString() {
		return "HNode [leftChild=" + leftChild + ", rightChild=" + rightChild + ", symbolSet=" + symbolSet
				+ ", cumFreq=" + cumFreq + "]";
	}
	
}
