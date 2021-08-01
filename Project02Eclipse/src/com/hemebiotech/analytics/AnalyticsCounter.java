package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;

public class AnalyticsCounter {
	private static int headacheCount = 0; // variable of the number of headache
	private static int rashCount = 0; // variable of the number of rash
	private static int pupilCount = 0; // variable of the number of pupil

	public static void main(String args[]) throws Exception {
		
		ISymptomReader symptomReader = new ReadSymptomDataFromFile("C:\\Users\\33629\\git\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
		List list = symptomReader.GetSymptoms();
				
		int i = 0; // set i to 0
		while (i < list.size()) {
			String line = (String) list.get(i);
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.equals("rash")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			i++; // increment i
		}

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
