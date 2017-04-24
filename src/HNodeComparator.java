import java.util.Comparator;

public class HNodeComparator implements Comparator<HNode>{

	
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	/**
	 * compare the 2 HNode by the frequencies
	 * @return 	1 if o1 is larger than o2
	 * 			return -1 if o1 is smaller than o2
	 * 			return 0 if equal
	 */
	public int compare(HNode o1, HNode o2) {
		HNode node1 =  o1;
		HNode node2 =  o2;
		if (node1.cumFreq > node2.cumFreq){
			return 1;
		}
		else if (node1.cumFreq < node2.cumFreq){
			return -1;
		}
		else{
			return node1.symbolSet.compareTo(node2.symbolSet);
		}
		
	}



}
