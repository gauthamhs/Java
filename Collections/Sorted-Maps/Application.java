//Sorted Hashmaps such as LinkedHashMap,TreeMap
//There are three kinds of Maps: TreeMap,HashMap,LinkedHashMap.

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Application {

	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<Integer, String>(); // Hashmap Syntax
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(); // LinkedHashMap Syntax
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();// TreeMap Syntax.

		testMap(treeMap); // Always sorts the keys in alphabetical order.
		System.out.println();
		testMap(hashMap); // Sorts the keys, Not always.
		System.out.println();
		testMap(linkedHashMap); // Creates an order in the way you enter.
	}

	public static void testMap(Map<Integer, String> map) {
		map.put(9, "fox");
		map.put(4, "cat");
		map.put(8, "dog");
		map.put(1, "giraffe");
		map.put(0, "swan");
		map.put(15, "bear");
		map.put(6, "snake");

		for (Integer key : map.keySet()) {
			String value = map.get(key);
			System.out.println(key + ": " + value);
		}
	}
}
