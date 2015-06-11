import java.util.Stack;

public class StackBot {
	public static void main(String[] args) {

		double north = 0;

		double south = 0;

		double west = 0;

		double east = 0;

		Stack<String> commands = new Stack<String>();

		{
			commands.push("1.15 N");

			commands.push("0.79 S");

			commands.push("0.25 W");

			commands.push("0.15 W");

			commands.push("1.78 S");

			commands.push("0.95 E");

			commands.push("0.75 E");

			commands.push("1.37 N");

			commands.push("0.75 E");

			commands.push("1.85 W");

			commands.push("1.73 W");

			commands.push("0.72 N");

			commands.push("0.75 E");

			commands.push("0.65 E");

			commands.push("1.09 S");

			commands.push("1.75 W");

			commands.push("1.55 N");

			commands.push("0.73 E");

			commands.push("1.05 W");

			commands.push("0.71 E");

			commands.push("1.45 E");

			commands.push("1.75 N");

			commands.push("1.91 S");

			commands.push("0.45 S");

			commands.push("0.11 E");

		}

		while (!commands.empty()) {

			if (commands.peek().substring(5).equals("N")) {

				north += Double.parseDouble(commands.pop().substring(0, 3));

			} else if (commands.peek().substring(5).equals("S")) {

				south -= Double.parseDouble(commands.pop().substring(0, 3));

			} else if (commands.peek().substring(5).equals("E")) {

				east += Double.parseDouble(commands.pop().substring(0, 3));

			} else if (commands.peek().substring(5).equals("W")) {

				west -= Double.parseDouble(commands.pop().substring(0, 3));

			}

			if (north > 0 && east > 0) {

				System.out.println("waffle");

			} else if (north > 0 && west < 0) {

				System.out.println("taco");

			} else if (south < 0 && west < 0) {

				System.out.println("cupcake");

			} else if (south < 0 && east < 0) {

				System.out.println("poop");

			}

		}

	}
}
