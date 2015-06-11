import java.util.ArrayList;

public class MasterOrder {

	ArrayList<CookieOrder> cookies;

	public void setOrder(ArrayList<CookieOrder> cookieOrder) {

		this.cookies = cookieOrder;

	}

	public ArrayList<CookieOrder> getOrders() {

		return cookies;

	}

	MasterOrder() {

		cookies = new ArrayList<CookieOrder>();

	}

	public void addOrder(CookieOrder cookieOrder) {

		cookies.add(cookieOrder);

	}

	public int getTotalBoxes() {

		int sum = 0;

		for (int i = 0; i < cookies.size(); i++) {

			sum = sum + cookies.get(i).getNumBoxes();

		}

		return sum;

	}

	public int removeVariety(String variety) {

		int boxesRemoved = 0;

		for (int i = cookies.size() - 1; i > -1; i--) {

			String cookieVariety = cookies.get(i).getVariety();

			if (variety.compareTo(cookieVariety) == 0) {

				boxesRemoved = boxesRemoved + cookies.get(i).getNumBoxes();

				cookies.remove(i);
			}

		}

		return boxesRemoved;
	}

}
