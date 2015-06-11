import java.util.HashMap;
import java.util.Map.Entry;

public class StandardHashMap {
	public static void main(String[] args) {

		int matching = 0;

		HashMap<String, String> map1 = new HashMap<String, String>();

		map1.put("Alice", "Healthy");

		map1.put("Mary", "Ecstatic");

		map1.put("Bob", "Happy");

		map1.put("Chuck", "Fine");

		map1.put("Felix", "Sick");

		HashMap<String, String> map2 = new HashMap<String, String>();

		map2.put("Mary", "Ecstatic");

		map2.put("Felix", "Healthy");

		map2.put("Ricardo", "Superb");

		map2.put("Tam", "Fine");

		map2.put("Bob", "Happy");

		for (Entry<String, String> entry : map1.entrySet()) {

			String value = map2.get(entry.getKey());

			if (value != null) {

				if (entry.getValue().equals(value)) {

					matching = matching+1; 
					
				}

			}

		}
		
		System.out.println(matching);

	}
}
