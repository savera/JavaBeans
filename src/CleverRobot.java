public class CleverRobot {

	private CellCR[][] sampleMaze;
	private int x;
	private int y;

	public CleverRobot(CellCR[][] sampleMaze) {

		this.sampleMaze = sampleMaze;
		this.x = x;
		this.y = y;
	}

	public CellCR getCell(int x, int y) {

		return sampleMaze[x][y];
	}

	public Object getCurrentCellX() {
		// TODO Auto-generated method stub
		return x;
	}

	public Object getCurrentCellY() {
		// TODO Auto-generated method stub
		return y;
	}

	public void setStartingCell(int i, int j) {
		this.x = i;
		this.y = j;

	}

	public void proceedToNextCell() {
		CellCR currentCell = sampleMaze[x][y];
		if (currentCell.getNumberOfWalls() == 3) {
			if (currentCell.isHasNorthWall()) {
				currentCell.hasNorthWall = false; 
				x++;
			}
//			if (currentCell.isHasSouthWall()) {
//				currentCell.hasSouthWall = false; 
//				x++;
//			}
//			if (currentCell.isHasEastWall()) {
//				currentCell.hasEastWall = false; 
//				y--;
//			}
//			if (currentCell.isHasWestWall()) {
//				currentCell.hasWestWall = false; 
//				y++;
//			}
		}
		if (currentCell.getNumberOfWalls() == 1) {
			if (currentCell.isHasEastWall()) {
				
				y++;
			}
		}
		//System.out.println(currentCell.getNumberOfWalls());
		if (currentCell.getNumberOfWalls() == 0) {
			
			x--;
			
		}
		

	}
	
	public void processCells(){
		CellCR currentCell = sampleMaze[x][y]; 
		
		
	}

}
