// Using Custom Objects in Sets, and as keys in maps.

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class Human {

	private int id;
	private String name;

	public Human(int id, String name) { 
		
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "{id: " + id + ", name: " + name + " }";

	}

	@Override
	public int hashCode() {
		final int prime = 31; // This will prevent duplicated when objects are
								// inserted into sets and maps.
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

public class Application {
	public static void main(String[] args) {
		Map<Human, Integer> map = new LinkedHashMap<Human, Integer>(); //Linkedhashmap prints in the order which we created the objects
		Human human1 = new Human(4, "Karthik");
		Human human2 = new Human(2, "Zameer"); // Keys
		Human human3 = new Human(7, "Basya");
		Human human4 = new Human(4, "Karthik"); // Doesn't allow duplicates in maps if hash-code and equals are implemented.

		map.put(human1, 10);
		map.put(human2, 20);
		map.put(human3, 30);
		map.put(human4, 10);

		// System.out.println(map);
		for (Human key : map.keySet()) { // key is variable, can be set to anything, map is the map type
			System.out.println(key + ": " + map.get(key));
		}
		System.out.println();

		Set<Human> set = new HashSet<Human>();

		set.add(human1);
		set.add(human2);
		set.add(human3);
		set.add(human4);

		System.out.println(set);

	}

}
