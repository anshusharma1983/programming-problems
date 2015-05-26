import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDictionary {

	private static String[] words = { "apple", "apron", "april" };
	private static Map<String, List<Integer>> dictionary = new HashMap<String, List<Integer>>();

	public static void main(String[] args) {
		for (int x = 0; x < words.length; x++) {
			String word = words[x];
			for (int i = 1; i < word.length(); i++) {
				String subString = word.substring(0, i);
				if (dictionary.containsKey(subString)) {
					dictionary.get(subString).add(x);
				} else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(x);
					dictionary.put(subString, list);
				}
			}
		}
//		System.out.println(dictionary);
		System.out.println(getWords("apri"));
	}
	
	static List<String> getWords(String input) {
		List<Integer> indexes = dictionary.get(input);
		List<String> returnList = new ArrayList<String>();
		for (Integer index : indexes) {
			returnList.add(words[index]);
		}
		return returnList;
	}
	
}
