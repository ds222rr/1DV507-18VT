package ds222rr_assign2.yahtzee;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Dice extends Group {
	
	private final int value;		// Value of the dice
	
	public Dice (int n) {			// Constructor
		Rectangle rectangle = new Rectangle(100, 100);
		rectangle.setFill(Color.WHITE);
		rectangle.setStrokeType(StrokeType.INSIDE);
		rectangle.setStroke(Color.BLACK);
		value = n;
		
		if (n == 1) {	// In case of a 1
			Circle one = new Circle(50, 50, 4);
			getChildren().addAll(rectangle, one);
		}
		else if (n == 2) {	// In case of a 2
			Circle one = new Circle(25, 25, 4);
			Circle two = new Circle(75, 75, 4);
			getChildren().addAll(rectangle, one, two);
		}
		else if (n == 3) {	// In case of a 3
			Circle one = new Circle(25, 25, 4);
			Circle two = new Circle(50, 50, 4);
			Circle three = new Circle(75, 75, 4);
			getChildren().addAll(rectangle, one, two, three);
		}
		else if (n == 4) {	// In case of a 4
			Circle one = new Circle(25, 25, 4);
			Circle two = new Circle(25, 75, 4);
			Circle three = new Circle(75, 25, 4);
			Circle four = new Circle(75, 75, 4);
			getChildren().addAll(rectangle, one, two, three, four);
			
		}
		else if (n == 5) {	// In case of a 5
			Circle one = new Circle(25, 25, 4);
			Circle two = new Circle(25, 75, 4);
			Circle three = new Circle(50, 50, 4);
			Circle four = new Circle(75, 25, 4);
			Circle five = new Circle(75, 75, 4);
			getChildren().addAll(rectangle, one, two, three, four, five);
		}
		else if (n == 6) {	// In case of a 6
			Circle one = new Circle(25, 25, 4);
			Circle two = new Circle(25, 50, 4);
			Circle three = new Circle(25, 75, 4);
			Circle four = new Circle(75, 25, 4);
			Circle five = new Circle(75, 50, 4);
			Circle six = new Circle(75, 75, 4);
			getChildren().addAll(rectangle, one, two, three, four, five, six);
		}
	}
	
	public int getValue() {
		return value;
	}
}
