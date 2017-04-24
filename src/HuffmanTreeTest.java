import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class HuffmanTreeTest {

	private TreeMap<Character, Integer> tree;
	private TreeMap<Character, Integer> tree2;
	private HuffmanTree huff;
	private HuffmanTree huff2;

	@Before
	public void setUp(){
		
		tree = new TreeMap<Character, Integer>();
		tree.put('a', 20);
		tree.put('b', 55);
		tree.put('c', 20);
		tree.put('d', 5);
		tree.put('e', 30);
		tree.put('f', 35);
		tree.put('g', 50);
		tree.put('h', 45);
		
		huff = new HuffmanTree(tree);
		
		tree2 = new TreeMap<Character, Integer>();
		tree2.put('a', 70);
		tree2.put('b', 3);
		tree2.put('c', 20);
		tree2.put('d', 37);
		
		huff2 = new HuffmanTree(tree2);

	}

	@Test
	public void test_encode(){
		assertEquals(huff.encode('a'), "11011");
		assertEquals(huff.encode('b'), "01");
		assertEquals(huff.encode('c'), "1100");
		assertEquals(huff.encode('d'), "11010");
		assertEquals(huff.encode('e'), "100");
		assertEquals(huff.encode('f'), "101");
		assertEquals(huff.encode('g'), "00");
		assertEquals(huff.encode('h'), "111");
		try { huff.encode('k'); fail(); }
		catch (NoSuchElementException e) { /* test passed */ }
	}
	
	
	@Test
	public void test_encodeLoop(){
		assertEquals(huff.encodeLoop('a'), "11011");
		assertEquals(huff.encodeLoop('b'), "01");
		assertEquals(huff.encodeLoop('c'), "1100");
		assertEquals(huff.encodeLoop('d'), "11010");
		assertEquals(huff.encodeLoop('e'), "100");
		assertEquals(huff.encodeLoop('f'), "101");
		assertEquals(huff.encodeLoop('g'), "00");
		assertEquals(huff.encodeLoop('h'), "111");
		try { huff.encode('k'); fail(); }
		catch (NoSuchElementException e) { /* test passed */ }
		
//		assertEquals(huff2.encodeLoop('a'), "0");
//		assertEquals(huff2.encodeLoop('b'), "100");
//		assertEquals(huff2.encodeLoop('c'), "101");
//		assertEquals(huff2.encodeLoop('d'), "11");
	}
	
	
	@Test
	public void test_decode(){
		assertEquals(huff.decode("11011"), 'a');
		assertEquals(huff.decode("01"), 'b');
		assertEquals(huff.decode("1100"), 'c');
		assertEquals(huff.decode("11010"), 'd');
		assertEquals(huff.decode("100"), 'e');
		assertEquals(huff.decode("101"), 'f');
		assertEquals(huff.decode("00"), 'g');
		assertEquals(huff.decode("111"), 'h');
		assertEquals(huff.decode("1110"), '\0');
		assertEquals(huff.decode("10000"), '\0');
	}
	
	
	
	
}
