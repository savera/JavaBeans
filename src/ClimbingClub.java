import java.util.ArrayList;

public class ClimbingClub {

	private ArrayList<ClimbInfo> climbList;

	ClimbingClub() {

		climbList = new ArrayList<ClimbInfo>();

	}

	public ArrayList<ClimbInfo> getClimbList() {

		return climbList;

	}

	public void addClimb(String peakName, int climbTime) {
		String name;

		for (int i = 0; i < climbList.size(); i++) {

			System.out.println("Hello");

			name = climbList.get(i).getName();

			if (peakName.compareTo(name) <= 0) {

				climbList.add(i, new ClimbInfo(peakName, climbTime));

				System.out.println("Breaking");

				break;

			}

		}
		climbList.add(new ClimbInfo(peakName, climbTime));

	}

}
