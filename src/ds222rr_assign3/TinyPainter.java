package ds222rr_assign3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.ToolBar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class TinyPainter extends Application {
	
	private static double xStart = 0;		// Start x-coordinate
	private static double yStart = 0;		// Start y-coordinate
	private Shape drawShape = new Line();	// Default shape
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage args) {
	
		// Create ComboBox to select shape
		ComboBox<String> shape = new ComboBox<String>();
		shape.getItems().addAll("Line", "Dot", "Rectangle", "Circle");
		
		// Create ComboBox to select size
		ComboBox<Integer> size = new ComboBox<Integer>();
		for (int i = 1; i <= 40; i+=3) {
			size.getItems().add(i);
		}
		
		// Create ColorPicker to select color
		ColorPicker colorPicker = new ColorPicker();

		// Create ToolBar for ComboBoxes and ColoPickerS
		ToolBar tb = new ToolBar();
		tb.getItems().addAll(shape, size, colorPicker);
		
		// Create Group
		Group root = new Group();
		root.getChildren().add(tb);
        
		// Create Scene
		Scene scene = new Scene(root, 800, 600);
		args.setTitle("Tiny Painter");
		args.setScene(scene);
		args.show();

		// Event handler for MousePressed
		scene.setOnMousePressed(e -> {
			// Call method to set start-coordinates
			setStartCoordinates(e.getSceneX(), e.getSceneY());
			// Finalize if case is a "Dot"
			if (shape.getValue() == "Dot" || shape.getValue() == "Line") {
				drawShape = drawing(e.getSceneX(), e.getSceneY(), shape.getValue(),
						drawShape, size, colorPicker.getValue());	
				root.getChildren().add(drawShape);	// Add shape to root
			}
		});
		
		//Event handler for MouseDragged
		scene.setOnMouseDragged(e -> {
			// Delete Shape while it is not finalized
			root.getChildren().remove(drawShape);			
			// Call method for drawing Shape
			drawShape = drawing(e.getSceneX(), e.getSceneY(), shape.getValue(),
					drawShape, size, colorPicker.getValue());	
			root.getChildren().add(drawShape);	// Add shape to root
		});
		
		//Event handler for MouseRelease
		scene.setOnMouseReleased(e -> {
			// Call method for drawing Shape
			drawShape = drawing(e.getSceneX(), e.getSceneY(), shape.getValue(),
								drawShape, size, colorPicker.getValue());
			root.getChildren().addAll(drawShape);	// Add shape to root
		});
	}
	
	// Method to get start coordinates
	public static void setStartCoordinates(double startX, double startY) {
		if (startX < 0) {
			xStart = 0;
		}
		else {
			xStart = startX;
		}
		
		// Selective statement to set y-coordinate of the start
		if (startY < 0) {
			yStart = 0;
		}
		else {
			yStart = startY;
		}
	}
	
	// Method for drawing Shape
	public static Shape drawing(double eX, double eY, String shapeStr, 
								Shape draw, ComboBoxBase<Integer> sizeInt, Color color) {
		double xEnd = 0;	// Ending x-coordinate for Shape
		double yEnd = 0;	// Ending y-coordinate for Shape
		
		// Selective statement to set x-coordinate of the end
		if (eX < 0) {
			xEnd = 0;
		}
		else {
			xEnd = eX;
		}
		
		// Selective statement to set y-coordinate of the end
		if (eY < 0) {
			yEnd = 0;
		}
		else {
			yEnd = eY;
		}
		
		// Selective statement to determine Shape
		if (shapeStr == "Line") {
			draw = new Line(xEnd, yEnd, xStart, yStart);
		}
		else if (shapeStr == "Dot") {
			draw = new Line(xStart, yStart, xStart, yStart);
		}
		else if (shapeStr == "Circle") {
			draw = new Circle(xStart, yStart, Math.sqrt((Math.pow((xStart-xEnd), 2)) + 
								  (Math.pow((yStart-yEnd), 2))));
		}
		else if (shapeStr == "Rectangle") {
			draw = new Rectangle (xStart, yStart, xEnd-xStart, yEnd-yStart);
		}
		// Set Colors for Shape
		draw.setFill((color));
		draw.setStroke(color);
		
		// Selective statement to set size for Dot or Line
		if (shapeStr == "Line" || shapeStr == "Dot") {
			if(sizeInt.getValue() == null) {
				draw.setStrokeWidth(1);
			}		
			else {
				draw.setStrokeWidth((int) sizeInt.getValue());
			}
		}
		// In case shape == null	
		if (shapeStr == null) {
			draw= new Line(-1, -1, -1, -1);
		}
		return draw;
	}
}