import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/* These unit tests will help you check your answers to the 2010 AP question on ArrayLists. 
 * You should try answering the question on paper first. Cookie Order is the first question on the paper.
 * http://apcentral.collegeboard.com/apc/public/repository/ap10_frq_computer_science_a.pdf
 */
public class CookieOrderTest {

	/*
	 * 1. Create a class CookieOrder.
	 * 
	 * (a) It has member variables String variety, and int numBoxes.
	 * 
	 * (b) You need to make a constructor that uses these variables for it's parameters.
	 * 
	 * (c) And write getters and setters for each member variable.
	 * 
	 * (d) When you are done, uncomment this test and run it to see if your class works.
	 */

	@Test
	public void testClimbInfo() {
		// test constructor
		CookieOrder cookie = new CookieOrder("Samoa", 500);
		assertEquals("Samoa", cookie.getVariety());
		assertEquals(500, cookie.getNumBoxes());

		// test setters and getters
		cookie.setNumBoxes(33);
		assertEquals(33, cookie.getNumBoxes());
		cookie.setVariety("Thin Mints");
		assertEquals("Thin Mints", cookie.getVariety());
	}

	/*
	 * 2. Create a class called MasterOrder.
	 * 
	 * (a) It should contain an ArrayList of CookieOrders.
	 * 
	 * (b) Create a getter and setter for this List
	 * 
	 * (c) In the constructor, initialize the ArrayList.
	 * 
	 * (d) Then run the test below to check your work.
	 */
	@Test
	public void testMasterOrderConstructor() throws Exception {
		MasterOrder masterOrder = new MasterOrder();
		assertNotNull(masterOrder.getOrders());
	}

	/* 3. Add a method to MasterOrder that allows you to add a CookieOrder to it's List. */
	@Test
	public void testAddCookieOrderConstructor() throws Exception {
		MasterOrder masterOrder = new MasterOrder();
		CookieOrder cookieOrder = new CookieOrder("chocolate chip", 3);
		masterOrder.addOrder(cookieOrder);
		assertEquals(1, masterOrder.getOrders().size());
		assertEquals(3, masterOrder.getOrders().get(0).getNumBoxes());
		assertEquals("chocolate chip", masterOrder.getOrders().get(0).getVariety());
	}

	/*
	 * PART A
	 * 
	 * The getTotalBoxes method computes and returns the sum of the number of boxes of all cookie orders. If there are no cookie orders in the master
	 * order, the method returns 0.
	 */
	@Test
	public void testGetTotalBoxes() throws Exception {
		MasterOrder goodies = new MasterOrder();
		goodies.addOrder(new CookieOrder("Chocolate Chip", 1));
		goodies.addOrder(new CookieOrder("Shortbread", 5));
		goodies.addOrder(new CookieOrder("Macaroon", 2));
		goodies.addOrder(new CookieOrder("Chocolate Chip", 3));

		assertEquals(11, goodies.getTotalBoxes());
	}

	/*
	 * PART B
	 * 
	 * The removeVariety method updates the master order by removing all of the cookie orders in which the variety of cookie matches the parameter
	 * cookieVar. The master order may contain zero or more cookie orders with the same variety as cookieVar. The method returns the total number of
	 * boxes removed from the master order.
	 */
	@Test
	public void testRemoveVariety() throws Exception {
		MasterOrder goodies = new MasterOrder();
		goodies.addOrder(new CookieOrder("Chocolate Chip", 1));
		goodies.addOrder(new CookieOrder("Shortbread", 5));
		goodies.addOrder(new CookieOrder("Macaroon", 2));
		goodies.addOrder(new CookieOrder("Chocolate Chip", 3));
		goodies.addOrder(new CookieOrder("Macaroon", 7));
		
		assertEquals(4, goodies.removeVariety("Chocolate Chip"));
		assertEquals(0, goodies.removeVariety("Brownie"));
	}

}

