package ds222rr_assign1.XChart;

import java.util.ArrayList;
import java.util.List;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

public class SinMain {
	public static void main(String[] args) {
		
		// Create new PieChart object to display the requested curve
	    XYChart chart = new XYChartBuilder().width(1600).height(1200).build();
	   
	    List<Double> xData = new ArrayList<Double>();	// Create new List object to store the x-axis data
	    List<Double> yData = new ArrayList<Double>();	// Create new List object to store the y-axis data

	    // Iterative statement to plot the requested curve
	    for (double i = 0; i < 2*Math.PI; i = i + Math.PI/10000) {
	    	xData.add(i);
	    	yData.add((1 + i/Math.PI)*Math.cos(i)*Math.cos(40*i));
	    }
	    chart.addSeries("Curve", xData, yData);		// Add the data to the XYChart chart
	    new SwingWrapper<>(chart).displayChart();	// Display the XYChart chart
	}
}

