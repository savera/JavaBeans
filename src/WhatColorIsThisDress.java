import java.util.HashMap;

public class WhatColorIsThisDress {

	public static void main(String[] args) {

		float totalCount = 0;

		int BB = 0;

		int WG = 0;

		HashMap<String, String> survey = new HashMap<String, String>();

		survey.put("June", "Black/Blue");

		survey.put("Michael", "White/Gold");

		survey.put("James", "White/Gold");

		survey.put("Michelle", "White/Gold");

		survey.put("Kendra", "Black/Blue");

		for (String string : survey.values()) {

			if (string.equals(("Black/Blue"))) {

				BB = BB + 1;

				 //System.out.println("BB" + BB);

			}
			if (string.equals(("White/Gold"))) {

				WG = WG + 1;

				//System.out.println("WG " + WG);

			}
		}

		totalCount = survey.size(); 
		
		float percentBB = BB/totalCount*100;
		
		float percentWG = WG/totalCount*100;
		
		System.out.println("Black/Blue " + percentBB + "%");
		
		System.out.println("White/Gold " + percentWG + "%");

	}
}
