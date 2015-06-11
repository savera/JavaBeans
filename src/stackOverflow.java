public class stackOverflow {
	public static void main(String[] args) {

		stackOverflow so = new stackOverflow();

		so.methodOne();

	}

	public void methodOne() {

		methodTwo();

	}

	public void methodTwo() {

		methodOne();

	}
}
