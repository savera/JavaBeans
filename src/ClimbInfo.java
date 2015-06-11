public class ClimbInfo {

	String peakName;

	int climbTime;

	ClimbInfo(String peakName, int climbTime) {

		this.peakName = peakName;

		this.climbTime = climbTime;

	}

	public void setName(String peakName) {

		this.peakName = peakName;
		
	}

	public String getName() {

		return peakName;

	}

	public void setTime(int climbTime) {

		this.climbTime = climbTime; 
		
	}
	
	public int getTime() {

		return climbTime;

	}

}
