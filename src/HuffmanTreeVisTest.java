import java.util.TreeMap;

public class HuffmanTreeVisTest {


	public static void main(String[] args)
	{
		TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>();
		treeMap.put('a', 20);
		treeMap.put('b', 55);
		treeMap.put('c', 20);
		treeMap.put('d', 5);
		treeMap.put('e', 30);
		treeMap.put('f', 35);
		treeMap.put('g', 50);
		treeMap.put('h', 45);

		HuffmanTree tree = new HuffmanTree(treeMap);           // make the tree

		new HuffmanVis(tree.getRoot(), "");   // visualize the tree
	}

}
