import java.util.HashMap;

public class DatingPool {

	public static void main(String[] args) {

		int total = 0;

		HashMap<String, String> elgibleBachelors = new HashMap();

		elgibleBachelors.put("Max", "Conservative");

		elgibleBachelors.put("Bob", "conservative");

		elgibleBachelors.put("Diego ", "libertarian");

		elgibleBachelors.put("Felix", "Independant");

		elgibleBachelors.put("William", " Republican");

		elgibleBachelors.put("Chuck", " Republican");

		elgibleBachelors.put("Matthew ", "liberal");

		elgibleBachelors.put("Jose ", "Democrat");

		elgibleBachelors.put("Elizabeth ", "liberal");

		for (String string : elgibleBachelors.values()) {

			if (string.equals("liberal")) {

				total = total + 1;

			}

		}

		System.out.println(total);

	}
}
