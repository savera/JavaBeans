import java.util.HashMap;
public class Cell {
	private HashMap<String,Boolean> wallMap;
	private boolean hasNorthWall;
	private boolean hasSouthWall;
	private boolean hasEastWall;
	private boolean hasWestWall;
	private int x;
	private int y;
	private HashMap<String,String> wallType;
	public Cell() {
	}
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Cell(boolean hasNorthWall, boolean hasSouthWall, boolean hasEastWall, boolean hasWestWall, int x, int y) {
			wallMap = new HashMap<String,Boolean>();
			wallMap.put("North", new Boolean(hasNorthWall));
			wallMap.put("South", new Boolean(hasSouthWall));
			wallMap.put("East", new Boolean(hasEastWall));
			wallMap.put("West", new Boolean(hasWestWall));
			this.x = x;
			this.y = y;
			
	
	}
	public Cell(boolean hasNorthWall, boolean hasSouthWall, boolean hasEastWall, boolean hasWestWall) {
		wallMap = new HashMap<String,Boolean>();
		wallMap.put("North", new Boolean(hasNorthWall));
		wallMap.put("South", new Boolean(hasSouthWall));
		wallMap.put("East", new Boolean(hasEastWall));
		wallMap.put("West", new Boolean(hasWestWall));
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean hasNorthWall() {
		return hasWall("North");
	}
	public boolean hasSouthWall() {
		return hasWall("South");
	}
	public boolean hasEastWall() {
		return hasWall("East");
	}
	public boolean hasWestWall() {
		return hasWall("West");
	}
	
	private boolean hasWall(String direction) {
		if (this.wallMap == null) {
			System.out.println(direction);
			System.out.println("wallMap null");
		}
		return this.wallMap.get(direction).booleanValue();
	}
	
	public int getNumberOfWalls() {
		int wallCount = 0;
		for (Boolean hasWall : this.wallMap.values()) {
			if (hasWall.booleanValue()) {
				wallCount++;
			}
		}
		return wallCount;
	}
	public HashMap<String, Boolean> getWallMap() {
		return wallMap;
	}
	public void setWallMap(HashMap<String, Boolean> wallMap) {
		this.wallMap = wallMap;
	}
}


