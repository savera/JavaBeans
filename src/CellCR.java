
public class CellCR {
	
	boolean hasNorthWall; 
	boolean hasSouthWall; 
	boolean hasWestWall; 
	boolean hasEastWall; 

	public CellCR(boolean hasNorthWall, boolean hasSouthWall,
			boolean hasEastWall, boolean hasWestWall) {
		
		this.hasNorthWall = hasNorthWall; 
		this.hasEastWall = hasEastWall; 
		this.hasSouthWall = hasSouthWall; 
		this.hasWestWall = hasWestWall; 
	}

	public boolean isHasNorthWall() {
		return hasNorthWall;
	}

	public void setHasNorthWall(boolean hasNorthWall) {
		this.hasNorthWall = hasNorthWall;
	}

	public boolean isHasSouthWall() {
		return hasSouthWall;
	}

	public void setHasSouthWall(boolean hasSouthWall) {
		this.hasSouthWall = hasSouthWall;
	}

	public boolean isHasWestWall() {
		return hasWestWall;
	}

	public void setHasWestWall(boolean hasWestWall) {
		this.hasWestWall = hasWestWall;
	}

	public boolean isHasEastWall() {
		return hasEastWall;
	}

	public void setHasEastWall(boolean hasEastWall) {
		this.hasEastWall = hasEastWall;
	}

	public int getNumberOfWalls() {
		int walls = 0;
		if(hasEastWall)
			walls++;
		if(hasSouthWall)
			walls++;
		if(hasNorthWall)
			walls++;
		if(hasWestWall)
			walls++;
		return walls;	
	}

	
}
