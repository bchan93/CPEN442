import java.util.HashMap;
import java.util.Iterator;
//BWSDMGHVLENQCIARXFTKUYPZO
public class p2 {

	public static void main(String[] args) {
		String myEncryptedString = "KTMCIRREZKZNNOIQANSUCAAFYIETUDLOUTENLQMGEMQIEKXIGAKGUAIYDCURDFRMQWRSCDMEVOAMRQAMGIQAKTCIMEEKYIDCAKMQXSCMCAEVHQNAQIAUVMIQCRRCEVMQUZMGRWUAEIAQPULOAPNZUYEVSRILAKOMDIVPOLEKEXBTIEMQCDQAYTUCUDKTIHRMNZAZZEMQYIVTMEEKUAIYDCNOAPWKEKDFDISRYIKRNUPKYCAVAPWKEKIQRYEVAQILAKOMOVEIUVACTFOVLROZIOGMRYEVBUCMEZIORXREAMHCKGSELQMGEMQITFCMGMEABIOLWFDCYQZKVARMGIUYVMAPWKEKKGYAWLOZSWTMNKAELKQMFIMEEKIWBHHQNOVMERMLQUBTRMCBIRPKHQBCYPMEHQAEYICUIQFIMEEKKTDCKGONIEUHRMDCBROZFLVAIDDCPALKLRNOBCZMACFKRMKRDNQALKPKIODFRMAGSUIPAUVZRMPIMEEKDCIEUTEVSRMQHQIOURYNSOGMAQYTVPZKGAAQQMQAVFUYDEAMNURBSOGMAQMBQUKTLYURIEUTBTAZGQAUKTQUYIHQVAKGDCUBHQHQVORAGIPKYTUDIEUTCDYIVZMTKQOZYIKTLYURDCDFYUBQAYAKRBCITNIOGAAGMQAQCUBAUQREAPWKEKYNSOYINDOCGUOICUYITQCULMZUIESTMEEKIWHQIOURMCTUAPWKEKERUHRMMBGIAQNTNZYTEKEZFBMUGAMKLYONDCMUONEAWANOGMKRNUZEQABCVFKQLQAPWKEKKTNZKRMUBASUIPAUVZRMLIONBCYTEVKTQUYIAQKTLYURVPBIGMQAONEAWANOGMHQBCABUEQASMWAOZMQONAPWKEKDXPKLOETNZKRNUYIMPOZVIAKGUYIUMALQUYIBCARIRRMEKXUAKQIKTCDIBOQAYAKIPLMVIMEEKRLBHAGPIMEEKIWCACAUVQASRAQCMZNZEAGZEKNIOLQWTRKAQAGWLOWGKLMAQMQUKARTACDCAEAKRWRAKUIGMMPEAONVSVACACDCAEAKRMNIOEZUTCIMEEKMCTUKTLYURMQBHHQVKQLLOIQAEXWGMHQNOZMCMCMRMGUPKUNZYIYEVKPQADCVOVFMEEKHQZEHQGMLKLOAQHQVMACCAEVOLMEIWPUAQOVEIGUUOMQCBGUUOUSQAMZCMOZRUIEYIMQBDZMGAKQDNQHMZKGIOWTZVIEUOMQBDAKWPNKAPWKEKQLMOYITHKQOLDNXQKIOBOUGMBCHQVMTNQHPKKTLYURIEGHKGUAIYDCNONCQIMIWLRXERMVAQERMVMQIQBAMVSGRAAVVFMEEKOCGIGMUOUSQAMZCMOZHUQAVFUYDEAMNUAQMOBIRMRQAMPVAGSVTBAFYPMEKTLYURAPWKEKZQIEIAEVBCHQGKLQGKGKTMEKMGYIKTLYURDCDFYUHGQAKGMVAEGMAQONNQGAYTWPPMMPHCAEOVQUQAACACMBUVQAYTEVAPWKEKKGNQLMOZWHMQCAONNQGAKRNUBCCAIDMGAPWKEKKGMCTUAPWKEKQLMOYITQIOURYSWLRBGIKGKCAVREAVEMONMQIHRMMVAEAQHQYIHAKTBHHQAEYICUIQHUMAUVQAMGUCONDXBCKRMDKTHGMWXWGMLOGMVMYUGMMQBDAMDNQHAQMLOYAQVZHQNOMQCAMQGIRBOAKRNUEAHQQMVFMEEKUAIYDCNOAPWKEKMCTUKTLYURMQIQAEAEAZPYLOHQVMVAREGHAUVAMEEKKGOICUGMYTUPTNQHYCDCIEWHUTVSOBKNGHPMIPAUVZRMQIKGVFIOHQBCDCBRPWKQMZSDYTAGREHQZABIOMYCCIMEEKVSZORBEVAUMUIGQAAGWLWLRBVMMQCDIPAUVZRMPUZKROVMUCREKTQUZEGMMQHQGANUEZMTMBXUACKQDIIEQAKGLULOMTGURBSOGMYPMEHQNOLKMEMQADPUMQBDAKWPNKYDLYUYGMCKAGQYAUKTLYURKGIOGQNODCLRBCHQZABIHMLKLOMQCBHCNOKEYIDIAMPUPMKGIBWLOZSTMEEKKGDVREZMKTHGTUKGMBGIUOMQBDAKWPNKCMOASTMEEKQLMOYIETOLNIMTHQIOURAPWKEKOLVIMEEKIEGQNOUAREAKUWPUMQBDAKWPNKIBEAYDLYURYIZTBIHAQAKGWSQAAQNTNZMUDXBCSMWAOZMQONOZHCMUAPWKEKMCTUKTLYURMQBHHQNKNZRERXYNDCONOZCMGMHQVAREAGGIPKYTUDBRQWQARMCDTUNAGIKGETQUZEAPWKEKPENOHQGMYIEZQIBTOZVFMEEKHQGAYQZKAMTAVACDVFUYDEAMNUKTGTCNZEHQAEMZONOCWFMVSHOLDKIEGHQKIEWHMQAGNZURREZKZKBPBAEAMQNZQIKGMGRWUAEIAQOIGUHQGABOVMPKAZGMOZHQZAIOMTGUOBEAGIGMHQVKBIBHHQBCVFUYDEAMNUKTUQVKMUGMAQOCWFMPGIKGUDLOSTMEEKIWIGREAMHCKGSARMQWPKKVOIIRUMZHVZDCAREIDCLMFKSMWAOZMQONMLWRGQCEZOVKHQIOURIELQSUIYCIFH";
		
		System.out.print(frequencyCount(myEncryptedString));
		System.out.print('\n');
		System.out.print(digraph(myEncryptedString));
		System.out.print('\n');
		System.out.print(quadgraph(myEncryptedString));
		System.out.print('\n');
		System.out.print(hexagraph(myEncryptedString));
		System.out.print('\n');
		System.out.print(myEncryptedString + '\n');
	}

	public static HashMap<String, Integer> frequencyCount(String myEncryptedString) {
		HashMap<String, Integer> letterFrequency = new HashMap<String, Integer>();

		for (char letter = 'A'; letter <= 'Z'; letter++) {
			int count = 0;
			for (int i = 0 ; i < myEncryptedString.length(); i++) {
				if (myEncryptedString.charAt(i) == letter) {
					count++;
				}
			}
			letterFrequency.put(String.valueOf(letter), count);
		}
		return letterFrequency;
	}
	
	public static HashMap<String, Integer> digraph(String myEncryptedString) {
		HashMap<String, Integer> doublesFrequency = new HashMap<String, Integer>();
		int count = 0;
		String letterPair = null;

		for (int i = 0; i < myEncryptedString.length() - 1; i++) {
			letterPair = myEncryptedString.substring(i, i+2);
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
	
	/*public static HashMap<String, Integer> trigraph(String myEncryptedString) {
		HashMap<String, Integer> triplesFrequency = new HashMap<String, Integer>();
		int count = 0;
		String letterTrio = null;
		
		for (int i = 0; i < myEncryptedString.length() - 2; i++) {
			letterTrio = myEncryptedString.substring(i, i+3);
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
	}*/
	
	public static HashMap<String, Integer> quadgraph(String myEncryptedString) {
		HashMap<String, Integer> quadsFrequency = new HashMap<String, Integer>();
		int count = 0;
		String letterQuad = null;
		
		for (int i = 0; i < myEncryptedString.length() - 3; i++) {
			letterQuad = myEncryptedString.substring(i, i+4);
			if (quadsFrequency.get(letterQuad) != null) {
				count = quadsFrequency.get(letterQuad);
				count++;
				quadsFrequency.put(letterQuad, count);
			} else {
				quadsFrequency.put(letterQuad, 1);
			}
		}
		
		filterFrequencies(quadsFrequency);
		return quadsFrequency;
	}
	
	public static HashMap<String, Integer> hexagraph(String myEncryptedString) {
		HashMap<String, Integer> hexesFrequency = new HashMap<String, Integer>();
		int count = 0;
		String letterHex = null;
		
		for (int i = 0; i < myEncryptedString.length() - 5; i++) {
			letterHex = myEncryptedString.substring(i, i+6);
			if (hexesFrequency.get(letterHex) != null) {
				count = hexesFrequency.get(letterHex);
				count++;
				hexesFrequency.put(letterHex, count);
			} else {
				hexesFrequency.put(letterHex, 1);
			}
		}
		
		filterFrequencies(hexesFrequency);
		return hexesFrequency;
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
}