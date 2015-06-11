import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MazeNavigationTest {

	@Test
	public void testCellConstruction() {
		boolean hasNorthWall = true;
		boolean hasSouthWall = true;
		boolean hasEastWall = false;
		boolean hasWestWall = true;
		CellCR testCell = new CellCR(hasNorthWall, hasSouthWall, hasEastWall,
				hasWestWall);
		assertEquals(true, testCell.isHasNorthWall());
		assertEquals(false, testCell.isHasEastWall());
		assertEquals(true, testCell.isHasSouthWall());
		assertEquals(true, testCell.isHasWestWall());
	}

	@Test
	public void testCountWalls() throws Exception {
		CellCR testCell = new CellCR(false, true, true, true);
		assertEquals(3, testCell.getNumberOfWalls());
	}

	@Test
	public void testRobotContainsMaze() {
		CleverRobot testBot = new CleverRobot(getSampleMaze());

		assertEquals(3, testBot.getCell(0, 0).getNumberOfWalls());
		assertEquals(3, testBot.getCell(0, 1).getNumberOfWalls());
	}

	@Test
	public void testRobotTracksCurrentCell() throws Exception {
		CleverRobot testBot = new CleverRobot(null);
		assertEquals(0, testBot.getCurrentCellX());
		assertEquals(0, testBot.getCurrentCellY());
	}

	@Test
	public void testRobotKnowsStartingCell() throws Exception {
		CleverRobot testBot = new CleverRobot(null);
		testBot.setStartingCell(0, 2);
		assertEquals(0, testBot.getCurrentCellX());
		assertEquals(2, testBot.getCurrentCellY());
	}

	@Test
	public void testLeftWallHug() {
		CleverRobot testBot = new CleverRobot(getSampleMaze());
		testBot.setStartingCell(0, 2);

		assertEquals(0, testBot.getCurrentCellX());
		assertEquals(2, testBot.getCurrentCellY());
		testBot.proceedToNextCell();
		System.out.println("1");
		assertEquals(1, testBot.getCurrentCellX());
		assertEquals(2, testBot.getCurrentCellY());
		testBot.proceedToNextCell();
		System.out.println("2");
		assertEquals(1, testBot.getCurrentCellX());
		assertEquals(3, testBot.getCurrentCellY());
		testBot.proceedToNextCell();
		System.out.println("3");
		assertEquals(0, testBot.getCurrentCellX());
		assertEquals(3, testBot.getCurrentCellY());
		testBot.proceedToNextCell();
		System.out.println("4");
		assertEquals(1, testBot.getCurrentCellX());
		assertEquals(3, testBot.getCurrentCellY());
		testBot.proceedToNextCell();
		System.out.println("5");
		assertEquals(1, testBot.getCurrentCellX());
		assertEquals(4, testBot.getCurrentCellY());
//		testBot.proceedToNextCell();
//		assertEquals(0, testBot.getCurrentCellX());
//		assertEquals(4, testBot.getCurrentCellY());
//		testBot.proceedToNextCell();
//		assertEquals(1, testBot.getCurrentCellX());
//		assertEquals(4, testBot.getCurrentCellY());
//		testBot.proceedToNextCell();
//		assertEquals(2, testBot.getCurrentCellX());
//		assertEquals(4, testBot.getCurrentCellY());

	}

//	@Test
//	public void testAvoidsDeadEnds() {
//		CleverRobot testBot = new CleverRobot(getSampleMaze());
//		testBot.processCells();
//
//		assertEquals(0, testBot.getCurrentCellX());
//		assertEquals(2, testBot.getCurrentCellY());
////		testBot.proceedToNextCell();
////		assertEquals(1, testBot.getCurrentCellX());
////		assertEquals(2, testBot.getCurrentCellY());
////		testBot.proceedToNextCell();
////		assertEquals(1, testBot.getCurrentCellX());
////		assertEquals(1, testBot.getCurrentCellY());
////		testBot.proceedToNextCell();
////		assertEquals(0, testBot.getCurrentCellX());
////		assertEquals(1, testBot.getCurrentCellY());
////		testBot.proceedToNextCell();
////		assertEquals(1, testBot.getCurrentCellX());
////		assertEquals(1, testBot.getCurrentCellY());
////
//	}
	
	private CellCR[][] getSampleMaze() {
		CellCR[][] sampleMaze = new CellCR[11][5];
		sampleMaze[0][0] = new CellCR(true, true, false, true);
		sampleMaze[0][1] = new CellCR(true, true, false, true);
		sampleMaze[0][2] = new CellCR(true, true, false, true);
		sampleMaze[0][3] = new CellCR(true, true, false, true);
		sampleMaze[0][4] = new CellCR(true, true, false, true);
		
		sampleMaze[1][0] = new CellCR(true, false, true, false);
		sampleMaze[1][1] = new CellCR(false, false, false, false);
		sampleMaze[1][2] = new CellCR(false, false, true, false);
		sampleMaze[1][3] = new CellCR(false, false, false, false);
		sampleMaze[1][4] = new CellCR(true, false, false, false);
		
		sampleMaze[2][0] = new CellCR(false, true, true, false);
		sampleMaze[2][1] = new CellCR(true, false, false, true);
		sampleMaze[2][2] = new CellCR(false, true, false, true);
		sampleMaze[2][3] = new CellCR(true, false, true, false);
		sampleMaze[2][4] = new CellCR(true, true, false, false);
		
		return sampleMaze;
	}

}


