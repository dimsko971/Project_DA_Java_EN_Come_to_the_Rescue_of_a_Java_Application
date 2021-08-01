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
		Map<String, Long> counts = symptomReader.GetSymptoms().stream().collect(Collectors.groupingBy(e ->e, Collectors.counting()));
		TreeMap<String, Long> sorted = new TreeMap<String, Long>(counts);	
		
		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write(sorted.toString());
		writer.close();
	}
}
