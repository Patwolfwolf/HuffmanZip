import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HuffmanZip {

	/**
	 * @param filename output file
	 */
	public void encode(String filename){
		File read = new File(filename);
		try{
			FileInputStream input = new FileInputStream(read);
			TreeMap<Character, Integer> freqCounter = new TreeMap<Character, Integer>();
			
			// build the frequency tree map, add characters into PQ
			int temp = input.read();
			while (temp != -1){
				if (freqCounter.containsKey((char)temp)){
					freqCounter.put((char)temp, freqCounter.get((char)temp) + 1);
				}
				else{
					freqCounter.put((char)temp, 1);
				}
				temp =  input.read();
			}
			input.close();
			
			// build huffmanTree using freqCounter treemap
			HuffmanTree readTree = new HuffmanTree(freqCounter);
			input = new FileInputStream(read);
			
			//write encoded data into file
			temp = input.read();
			BitOutputStream output = new BitOutputStream(filename + ".hz");
			output.writeObject(freqCounter);
			while (temp != -1){
				if ( readTree.writeCode((char)temp, output) ){
					temp = input.read();
				}
				else{
					throw new IOException();
				}
			}
			input.close();
			output.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * @param filename input file
	 */
	public void decode(String filename){
		File write = new File(filename.substring(0, filename.length() - 3) + ".huz");
		try{
			BitInputStream input = new BitInputStream(filename);

			// build the frequency tree map using the written object in the tree
			TreeMap<Character, Integer> freqCounter = null;
			try {
				freqCounter = (TreeMap<Character, Integer>) input.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			// build huffmanTree using freqCounter treemap
			HuffmanTree readTree = new HuffmanTree(freqCounter);
			FileOutputStream output = new FileOutputStream(write);
			
			//write decoded data into file
			char temp = readTree.readCode(input);
			while (temp != '\0'){
				output.write(temp);
				temp = readTree.readCode(input);
			}
			input.close();
			output.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		HuffmanZip zip = new HuffmanZip();
		if (args[0].equals("-encode")){
			zip.encode(args[1]);
		}
		else if (args[0].equals("-decode")){
			zip.decode(args[1]);
		}
	}


}
