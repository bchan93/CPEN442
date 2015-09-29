import java.util.HashMap;
import java.util.Iterator;

public class p1 {

	public static void main(String[] args) {
		String myString = "UNJUGJEZWDNLRJCQECATHEAWCATLWGGTGACQDCNVPATEVWDENJJPINACWETWVEETGWWDEJNKDWGZWDEJCAWEVALZEJJGADNLUECINAKZCQEWDEKGJTEAUPWWGALLDGAEGADNLEIUVGNTEVETLNJXHCNLWQGCWTGWWDEOQGPJTCJJLEEDNILWCATNAKQGIICHCFNAKGAEDCATNAWDECNVQGIICWDEGWDEVHCLNADNLWVGPLEVRGQXEWTGWIOTECVUCKKNALELCATUGZZNALQGIICDEUEKCACKCNACATIOTECVWGGXLCATUVCATOUPQXLQGIICCATKVPUULQGIICCATQDPUULQGIICCATUPVVGHLELQGIICCATDGVAUJGHEVLQGIICCATUGJKEVLQGIICUVCQEKNVTJELQGIICKGGTUGTNELQGIICUVGQXDGPLELCATRVGPTZGGWLTGWRVGPTZEEWLDGPWETCAEJTEVJODGUUNWZVGIWDEUCQXGZWDERCFNJNGA";
		
		System.out.print(frequencyCount(myString));
		System.out.print('\n');
		System.out.print(digraph(myString));
		System.out.print('\n');
		System.out.print(trigraph(myString));
		System.out.print('\n');
		System.out.print(myString + '\n');
		System.out.print(decrypt(myString));
		System.out.print('\n');
	}

	public static HashMap<String, Integer> frequencyCount(String myString) {
		HashMap<String, Integer> letterFrequency = new HashMap<String, Integer>();

		for (char letter = 'A'; letter <= 'Z'; letter++) {
			int count = 0;
			for (int i = 0 ; i < myString.length(); i++) {
				if (myString.charAt(i) == letter) {
					count++;
				}
			}
			letterFrequency.put(String.valueOf(letter), count);
		}
		return letterFrequency;
	}
	
	public static HashMap<String, Integer> digraph(String myString) {
		HashMap<String, Integer> doublesFrequency = new HashMap<String, Integer>();
		int count = 0;
		String letterPair = null;

		for (int i = 0; i < myString.length() - 1; i++) {
			letterPair = myString.substring(i, i+2);
			if (doublesFrequency.get(letterPair) != null) {
				count = doublesFrequency.get(letterPair);
				count++;
				doublesFrequency.put(letterPair, count);
			} else {
				doublesFrequency.put(letterPair, 1);
			}
		}
		filterFrequencies(doublesFrequency);
		return doublesFrequency;
	}
	
	public static HashMap<String, Integer> trigraph(String myString) {
		HashMap<String, Integer> triplesFrequency = new HashMap<String, Integer>();
		int count = 0;
		String letterTrio = null;
		
		for (int i = 0; i < myString.length() - 2; i++) {
			letterTrio = myString.substring(i, i+3);
			if (triplesFrequency.get(letterTrio) != null) {
				count = triplesFrequency.get(letterTrio);
				count++;
				triplesFrequency.put(letterTrio, count);
			} else {
				triplesFrequency.put(letterTrio, 1);
			}
		}
		
		filterFrequencies(triplesFrequency);
		return triplesFrequency;
	}
	
	public static void filterFrequencies(HashMap<String, Integer> mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        HashMap.Entry pair = (HashMap.Entry)it.next();
	        if ((int)pair.getValue() <= 3) {
	        	it.remove();
	        }
	    }
	    return;
	}
	
	public static String decrypt(String myString) {
		HashMap<String, String> combinedStrings = new HashMap<String, String>();
		StringBuilder myDecryptedString = new StringBuilder();
		
		combinedStrings.put("G", "O");//n_ahevowmlgs_iyucp_dbrtk_f
		combinedStrings.put("C", "A");//
		combinedStrings.put("E", "E");//
		combinedStrings.put("A", "N");//
		combinedStrings.put("T", "D");//
		combinedStrings.put("W", "T");//
		combinedStrings.put("L", "S");//
		combinedStrings.put("I", "M");//
		combinedStrings.put("N", "I");//
		combinedStrings.put("V", "R");//
		combinedStrings.put("D", "H");//
		combinedStrings.put("U", "B");//
		combinedStrings.put("Q", "C");//
		combinedStrings.put("J", "L");//
		combinedStrings.put("P", "U");//
		combinedStrings.put("K", "G");//
		combinedStrings.put("Z", "F");//
		combinedStrings.put("X", "K");//
		combinedStrings.put("H", "W");//
		combinedStrings.put("O", "Y");//
		combinedStrings.put("R", "P");//
		combinedStrings.put("F", "V");//
		
		for (int i = 0; i < myString.length(); i++) {
			String letter = String.valueOf(myString.charAt(i));
			myDecryptedString.append(combinedStrings.get(letter));
		}
		return myDecryptedString.toString();
	}
}