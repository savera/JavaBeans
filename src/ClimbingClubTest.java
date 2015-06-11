
// Copyright Wintriss Technical Schools 2013

import static org.junit.Assert.*;
import org.junit.Test;

/* These unit tests will help you check your answers to the AP Climbing Club question. 
* You should try answering the question on paper first. 
* http://apcentral.collegeboard.com/apc/public/repository/ap_frq_computerscience_12.pdf
*/

public class ClimbingClubTest {

	@Test
	public void testClimbInfo() {
		// test constructor
		ClimbInfo climbInfo = new ClimbInfo("Big Mountain", 500);
		assertEquals(500, climbInfo.getTime());
		assertEquals("Big Mountain", climbInfo.getName());

		// test setters
		climbInfo.setTime(20030);
		assertEquals(20030, climbInfo.getTime());
		climbInfo.setName("Everest");
		assertEquals("Everest", climbInfo.getName());
	}

	@Test
	public void testClimbList() throws Exception {
		ClimbingClub climbingClub = new ClimbingClub();
		assertTrue(climbingClub.getClimbList().getClass().getName()
				.contains("ArrayList"));
	}

//	/*
//	 * Part (a) 
// * Write an implementation of the ClimbingClub method addClimb that stores
//	 * the ClimbInfo objects in the order they were added. This implementation
//	 * of addClimb should create a new ClimbInfo object with the given name and
//	 * time. It appends a reference to that object to the end of climbList.
//	 */
	//@Test
	/*public void testAddClimb() throws Exception {
		ClimbingClub climbingClub = new ClimbingClub();
		climbingClub.addClimb("JavaMountain", 34);
		climbingClub.addClimb("JavaMountain", 34);
		assertEquals(2, climbingClub.getClimbList().size());
		// TODO: add an assert to test the name of the climb is correct
	}
//
//	/* Part (b) 
//	 * Write an implementation of the ClimbingClub method addClimb that stores
//	 * the elements of climbList in alphabetical order by name (as determined by
//	 * the compareTo method of the String class). This implementation of
//	 * addClimb should create a new ClimbInfo object with the given name and
//	 * time and then insert the object into the appropriate position in
//	 * climbList. Entries that have the same name will be grouped together and
//	 * can appear in any order within the group.
//	 */
	@Test
	public void testAddClimbOrdered() throws Exception {
		ClimbingClub hikerClub = new ClimbingClub();
		hikerClub.addClimb("Monadnock", 274);
		hikerClub.addClimb("Whiteface", 301);
		hikerClub.addClimb("Algonquin", 225);
		hikerClub.addClimb("Monadnock", 344);
		assertEquals("Algonquin", hikerClub.getClimbList().get(0).getName());
		assertEquals("Monadnock", hikerClub.getClimbList().get(1).getName());
		assertEquals("Monadnock", hikerClub.getClimbList().get(2).getName());
		assertEquals("Whiteface", hikerClub.getClimbList().get(3).getName());

	}
//	
	/* now answer Part (c) on the test */

}
