import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class IOtest {

	public static void main(String[] args) {
		String path = "C:\\Users\\Ruiwen\\cs216\\HuffmanZip\\src\\";
		File read = new File(path + "tlc-logic.txt");
		try{
			FileInputStream input = new FileInputStream(read);
			TreeMap<Character, Integer> freqCounter = new TreeMap<Character, Integer>();
			PriorityQueue<Character> charList = new PriorityQueue<Character>();

			// build the frequency tree map
			int temp = input.read();
			while (temp != -1){
				if (freqCounter.containsKey((char)temp)){
					freqCounter.put((char)temp, freqCounter.get((char)temp) + 1);
					System.out.println((char)temp + " - " + freqCounter.get((char)temp));
				}
				else{
					freqCounter.put((char)temp, 1);
					charList.add((char) temp);
					System.out.println((char)temp + " - " + freqCounter.get((char)temp));
				}
				temp =  input.read();
				//System.out.println((char)temp);
				//temp = input.read();
			}
			input.close();
			// priority ranking for data in freqCounter
			System.out.println(charList.toString());

		}
		catch (IOException e){
			e.printStackTrace();
		}

	}

}
