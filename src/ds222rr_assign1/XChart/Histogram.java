package ds222rr_assign1.XChart;

import java.io.File;		// Get File from Java Library
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;	// Get Scanner from Java Library 

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

public class Histogram {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);		// Create File object connected to a file
		Scanner in = new Scanner(file);		// Create Scanner object connected to a file object
		
		int arr [] = new int[12];	// Declare array to store intervals
		
		// Iterative statement to determine the amount of integers for each interval
		while (in.hasNextInt()) {
			int temp = in.nextInt();
			// In case the value of the integer is between 1 and 100
			if (temp > 0 && temp <= 100) {
				arr[((temp-1)/10)]++;	// Increase amount of integers for interval (temp-1) by 1
				arr[10]++;
			}
			// In case the value of the integer is not between 1 and 100
			else {
				arr[11]++;
			}
		}

		List<String> xData = new ArrayList<String>();		// Create new List object to store the x-axis data
		List<Integer> yData = new ArrayList<Integer>();		// Create new List object to store the y-axis data
		
		// Iterative statement to create the x-axis
		for (int i = 0; i < 100; i+= 10) {
			if (i == 0) {
				xData.add((i+1)+"-"+(i+10));
			}
			// In case of of the 2nd to the 9th interval
			else if (i != 0 && i < 90) {
				xData.add((i+1)+"-"+(i+10));	
			}
			// In case of the last interval
			else if (i == 90) {
				xData.add((i+1)+"-"+(i+10));	
			}
		}
		// Add the last two elements for the x-axis
		xData.add("Integer total");
		xData.add("other Characters");
		
		// Iterative statement to create the y-axis
		for (int i = 0; i < arr.length; i++) {
			yData.add(arr[i]);
		}
		
		// Create new CategoryChart object to display Histogram
		CategoryChart chart = new CategoryChartBuilder().width(1600).height(1200).title("Histogram").build();
		
		chart.addSeries("Numbers", xData, yData);				// Add the data to the CategoryChart chart
		new SwingWrapper<CategoryChart>(chart).displayChart();	// Display the CategoryChart chart
		
		// Create new PieChart object to display Histogram
		PieChart pieChart = new PieChartBuilder().width(1600).height(1200).build();
		
		// Iterative statement to add the data to the PieChart 
		for (int i = 0; i < arr.length; i++) {
			if (i != 10)	// To exclude the total numbers of integers from the chart
			pieChart.addSeries(xData.get(i), yData.get(i));
		}
		new SwingWrapper<PieChart>(pieChart).displayChart();	// Display the PieChart pieChart

		in.close();	// Close Scanner	
	}
}
